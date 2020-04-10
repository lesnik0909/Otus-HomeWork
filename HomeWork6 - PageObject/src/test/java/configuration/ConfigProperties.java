package configuration;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProperties {
    public static ServerConfig getCfg() {
        return cfg;
    }

    public static void setCfg(ServerConfig cfg) {
        ConfigProperties.cfg = cfg;
    }

    private static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public static final String LOGIN = cfg.lkUserName();
    public static final String PASSWORD = cfg.lkPassword();
    public static final String FIRST_NAME = cfg.firstname();
    public static final String LAST_NAME = cfg.lastname();
    public static final String EU_FIRST_NAME = cfg.euFirstName();
    public static final String EU_LAST_NAME = cfg.euLastName();
    public static final String BLOG_NAME = cfg.blogName();
    public static final String DATE_BIRTH = cfg.dateBirth();
    public static final String EMAIL = cfg.contactEmail();
    public static final String PHONE = cfg.contactPhone();
    public static final String MESSENGER_ONE = cfg.contactMessengerOne();
    public static final String MESSENGER_TWO = cfg.contactMessengerTwo();
    public static final String MESSENGER_ONE_LINK = cfg.contactMessengerOneLink();
    public static final String MESSENGER_TWO_LINK = cfg.contactMessengerTwoLink();
}
