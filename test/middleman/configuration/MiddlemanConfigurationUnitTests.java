package middleman.configuration;

import middleman.logging.ApplicationLog;
import middleman.utils.Block;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MiddlemanConfigurationUnitTests {
    ApplicationLog nullLogger = new ApplicationLog() {

        public void log(String message, Throwable t) {
        }

        public void log(String message) {
        }

        public void trace(String message) {
        }
    };


    @Test
    public void portNumberCanBePassedAsCommandLineOption() {
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(nullLogger);
        String[] options = {"-port", "9090",""};
        configuration.parseArgs(options);

        assertThat(configuration.getConfigurationPort(), equalTo(9090));
    }

    
    @Test
    public void acceptsConfigurationFileParameter() {
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(nullLogger);
        String[] options = {"-port", "123", "middleman.config"};
        configuration.parseArgs(options);

        Block<ProxyConfig> mockVisitor = mock(Block.class);

        configuration.eachProxy(mockVisitor);

        verify(mockVisitor, times(1)).yield((ProxyConfig) anyObject());
    }

    @Test
    public void configurationLoadsConfigurationFileIfNoArgumentsSupplied() {
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(nullLogger);
        configuration.parseArgs(new String[]{});

        Block<ProxyConfig> mockVisitor = mock(Block.class);

        configuration.eachProxy(mockVisitor);

        verify(mockVisitor, times(1)).yield((ProxyConfig) anyObject());
    }

    @Test
    public void defaultConfigurationPortIs200() {
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(nullLogger);
        configuration.parseArgs(new String[]{});

        assertThat(configuration.getConfigurationPort(), equalTo(2000));
    }

    @Test
    public void warningGivenForInvalidPortNumber() {
        ApplicationLog mockLogger = mock(ApplicationLog.class);
        MiddlemanConfiguration configuration = new MiddlemanConfiguration(mockLogger);
        String[] options = {"-port", "ewoir"};

        configuration.parseArgs(options);

        verify(mockLogger).log("Invalid port number argument \"ewoir\" ignored");
    }
}
