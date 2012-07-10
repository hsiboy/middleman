package middleman;

import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class Xml {
    private final InputSource inputSource;
    private XPath xPath;

    public Xml(InputStream stream) {
        this(new InputSource(stream));
    }

    public Xml(InputSource inputSource) {
        this.inputSource = inputSource;
        xPath = XPathFactory.newInstance().newXPath();
    }

    public String get(String xpath) {
        try {
            return xPath.evaluate(xpath, inputSource);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }
}
