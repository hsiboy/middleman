package middleman.server;

import com.sun.net.httpserver.HttpExchange;
import middleman.configuration.ProxyConfig;
import middleman.framework.*;
import middleman.server.components.NewProxyRequestDocument;
import middleman.server.components.StubRequest;
import middleman.server.components.TemplateAttribute;
import middleman.server.components.TemplateAttributes;
import middleman.utils.Block;
import org.antlr.stringtemplate.AttributeRenderer;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.net.URI;
import java.util.*;

public class WebContext {
    private WebServer server;
    private final HttpExchange httpExchange;
    StringTemplateGroup templateGroup;

    public WebContext(WebServer server, HttpExchange httpExchange) {
        this.server = server;
        this.httpExchange = httpExchange;
        this.templateGroup = new StringTemplateGroup("view");
    }

    public static TemplateAttribute attribute(final String name, final Object value) {
        return new TemplateAttribute(name, value);
    }

    public static TemplateAttributes with(final TemplateAttribute... attributes) {
        return new TemplateAttributes(attributes);
    }

    public void renderTemplateResponse(String templateName) {
        renderTemplateHtmlResponse(templateName, new TemplateAttributes(new TemplateAttribute[]{}));
    }

    public void renderTemplateHtmlResponse(String templateName, TemplateAttributes templateAttributes) {
        Hashtable<String, String> htmlHeaders = new Hashtable<String, String>();
        htmlHeaders.put("content-type", "text/html");

        renderTemplateResponse(templateName, templateAttributes, htmlHeaders, new HashMap<Class, AttributeRenderer>());
    }

    public void renderTemplateCSVResponse(String templateName, TemplateAttributes templateAttributes) {
        Map<String, String> csvHeaders = new HashMap<String, String>();
        csvHeaders.put("Content-type", "application/vnd.ms-excel");
        csvHeaders.put("Content-disposition", "attachment; filename=proxy-logs.csv");

        renderTemplateResponse(templateName, templateAttributes, csvHeaders, new HashMap<Class, AttributeRenderer>());
    }

    public void renderTemplateXMLResponse(String templateName, TemplateAttributes templateAttributes) {
        Hashtable<String, String> xmlHeaders = new Hashtable<String, String>();
        xmlHeaders.put("Content-type", "text/xml");

        Map<Class, AttributeRenderer> renderers = new HashMap<Class, AttributeRenderer>();
        renderers.put(String.class, new AttributeRenderer() {
            public String toString(Object o) {
                return StringEscapeUtils.escapeXml(o.toString());
            }

            public String toString(Object o, String s) {
                return StringEscapeUtils.escapeXml(o.toString());
            }
        });

        renderTemplateResponse(templateName, templateAttributes, xmlHeaders, renderers);
    }

    private void renderTemplateResponse(String templateName, TemplateAttributes templateAttributes, Map<String, String> headers, Map<Class, AttributeRenderer> renderers) {
        try {
            StringTemplate template = templateGroup.getInstanceOf("middleman/templates/" + templateName);

            templateAttributes.applyTo(template);

            for (Map.Entry<Class, AttributeRenderer> renderer : renderers.entrySet()) {
                template.registerRenderer(renderer.getKey(), renderer.getValue());   
            }

            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpExchange.getResponseHeaders().set(header.getKey(), header.getValue());
            }

            writeResponse(200, template.toString());

        } catch (Exception e) {
            handleException(e);
        }
    }

    public void renderResponse(InputStream inputStream) {
        try {
            byte[] buffer = new byte[1024];
            OutputStream responseStream = httpExchange.getResponseBody();

            httpExchange.sendResponseHeaders(200, inputStream.available());

            int read = inputStream.read(buffer);
            while (read >= 0) {
                responseStream.write(buffer, 0, read);
                read = inputStream.read(buffer);
            }

            responseStream.close();
            inputStream.close();
        } catch (IOException e) {
            handleException(e);
        }

    }

    private void handleException(Exception e) {
        try {
            httpExchange.sendResponseHeaders(500, 0L);
            httpExchange.getResponseBody().close();
        } catch (IOException e1) {
            throw new RuntimeException("Can't even tell people about the errors", e);
        }
    }

    private void writeResponse(int code, String responseText) {
        try {
            byte[] responseBytes = responseText.getBytes();
            httpExchange.sendResponseHeaders(code, responseBytes.length);
            OutputStream responseStream = httpExchange.getResponseBody();
            responseStream.write(responseBytes);
            responseStream.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void redirectTo(String uri) {
        try {
            ArrayList<String> values = new ArrayList<String>();
            values.add(uri);
            httpExchange.getResponseHeaders().put("Location", values);
            httpExchange.sendResponseHeaders(302, -1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebServer getServer() {
        return server;
    }

    public void present(List<DispatchEntry<Presenter>> routeRegistry, WebContext context) {
        for (DispatchEntry<Presenter> entry : routeRegistry) {
            if (context.requestMatchesUriPattern(entry.matcher)) {
                entry.handler.present(context);
                return;
            }
        }
        context.noHandlerForRequest();
    }

    public void executeCommand(List<DispatchEntry<Command>> routeRegistry, WebContext context) {
        for (DispatchEntry<Command> entry : routeRegistry) {
            if (context.requestMatchesUriPattern(entry.matcher)) {
                entry.handler.executeCommand(context);
                return;
            }

        }
        context.noHandlerForRequest();
    }

    private void noHandlerForRequest() {
        throw new NoRouteException(getRequestUri());

    }

    private boolean requestMatchesUriPattern(UriMatcher pattern) {
        return pattern.matches(getRequestUri());
    }

    public URI getRequestUri() {
        return httpExchange.getRequestURI();
    }

    public ProxyConfig getServerConfig() {
        return getServer().getConfig();
    }

    public List<ProxyConfig> getRunningProxies() {
        return getServer().getRunningProxies();
    }

    public void eachLine(InputStream input, Block<String> visitor) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        try {
            String line = reader.readLine();
            while (line != null) {
                String[] parameters = line.split("&");
                for (String parameter : parameters) {
                    visitor.yield(parameter.replaceAll("\\+", " "));
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException ignored) {
            }
        }
    }

    public void fillRequestDocument(final RequestDocument document) {
        InputStream input = httpExchange.getRequestBody();
        try {
        eachLine(input, new Block<String>() {
            public void yield(String item) {
                String[] elements = item.split("=");
                document.set(elements[0], elements[1]);
            }
        });
        } finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    public void createOrUpdateStub(StubRequest stubRequest) {
        getServerConfig().createOrUpdateStub(stubRequest);
    }

    public void startNewProxy(NewProxyRequestDocument document) {
        getServer().startNewProxy(document.getProxyName(), document.getProxyPort());
    }
}
