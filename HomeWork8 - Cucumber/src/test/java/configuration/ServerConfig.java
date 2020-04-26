package configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("default.browser")
    @DefaultValue("chrome")
    String browserNameProperty();

    @Key("tests.waiting.time")
    @DefaultValue("10")
    int testsWaitingTime();

    @Key("tests.implicitly.waiting.time")
    @DefaultValue("4")
    int testsImplicitlyWaitingTime();

    @Key("lk.username")
    @DefaultValue("test@test.ru")
    String lkUserName();

    @Key("lk.password")
    @DefaultValue("test")
    String lkPassword();

}
