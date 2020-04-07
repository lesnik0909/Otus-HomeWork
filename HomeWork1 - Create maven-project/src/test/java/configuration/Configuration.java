package configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

public interface Configuration {
    @Sources("classpath:config.properties")
    public interface ServerConfig extends Config {
        @Key("default.browser")
        @DefaultValue("chrome")
        String browserNameProperty();
    }
}
