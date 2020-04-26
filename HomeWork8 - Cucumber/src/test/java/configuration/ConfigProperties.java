package configuration;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProperties {

    private static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public static final String LOGIN = cfg.lkUserName();
    public static final String PASSWORD = cfg.lkPassword();

}
