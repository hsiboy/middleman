package middleman.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import middleman.logging.ApplicationLog;
import middleman.utils.Block;

public class MiddlemanConfiguration {
	private int configurationPort;
	private final Map<String, ProxyConfig> configurations;
	private final ApplicationLog applicationLog;

	interface OptionHandler {
		void handle(Queue<String> args);
	}

	private static final Map<String, OptionHandler> optionHandlers = new HashMap<String, OptionHandler>();

	public MiddlemanConfiguration(final ApplicationLog applicationLog) {
		this.applicationLog = applicationLog;
		configurationPort = 2000;
		configurations = new HashMap<String, ProxyConfig>();

		optionHandlers.put("-port", new OptionHandler() {
			public void handle(Queue<String> args) {
				if (!args.isEmpty()) {
					String arg = args.remove();
					try {
						configurationPort = Integer.parseInt(arg);
					} catch (NumberFormatException e) {
						applicationLog.log("Invalid port number argument \"" + arg + "\" ignored");
					}
				} else {
					applicationLog.log("Invalid option parameter to -port - Integer port number required");
				}
			}
		});

	}

	public MiddlemanConfiguration(final ApplicationLog applicationLog, final int configPort) {
		this.applicationLog = applicationLog;
		configurationPort = configPort;
		configurations = new HashMap<String, ProxyConfig>();

		optionHandlers.put("-port", new OptionHandler() {
			public void handle(Queue<String> args) {
				if (!args.isEmpty()) {
					String arg = args.remove();
					try {
						configurationPort = Integer.parseInt(arg);
					} catch (NumberFormatException e) {
						applicationLog.log("Invalid port number argument \"" + arg + "\" ignored");
					}
				} else {
					applicationLog.log("Invalid option parameter to -port - Integer port number required");
				}
			}
		});

	}


	public void parseArgs(String[] args) {
		Queue<String> commandLine = new LinkedList<String>();

		commandLine.addAll(Arrays.asList(args));

		parseOptions(commandLine);
		
//TODO put some smarts around this - it be smelly.
		
		ConfigurationFileReader reader = new ConfigurationFileReader(applicationLog);
		try {

			if (commandLine.size() > 0) {
				reader.readConfiguration(new FileInputStream(commandLine.remove()), this);
			} else {
				reader.readConfiguration(new FileInputStream("middleman.config"), this);
				System.out.println("\tNo Command Line Args Detected - Reading midleman.config\n\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void parseOptions(Queue<String> args) {
		while (!args.isEmpty() && args.peek().startsWith("-")) {
			String option = args.remove();
			OptionHandler handler = optionHandlers.get(option);
			if (handler != null) {
				handler.handle(args);
			} else {
				applicationLog.log("Invalid option " + option + " ignored");
			}


		}
	}

	public void eachProxy(Block<ProxyConfig> visitor) {
		for (String name : configurations.keySet()) {
			visitor.yield(configurations.get(name));
		}
	}

	public int getConfigurationPort() {
		return configurationPort;
	}

	public void setConfigurationPort(int portNumber) {
		this.configurationPort = portNumber;
	}

	public void add(ProxyConfig proxyConfig) {
		configurations.put(proxyConfig.getName(), proxyConfig);
	}

	public Boolean hasProxy(String proxyName) {
		return configurations.containsKey(proxyName);
	}

	public ProxyConfig getProxyByName(String proxyName) {
		return configurations.get(proxyName);
	}

}
