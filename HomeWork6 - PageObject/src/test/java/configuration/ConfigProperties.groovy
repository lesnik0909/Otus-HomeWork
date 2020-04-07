package configuration

import org.aeonbits.owner.ConfigFactory

public class ConfigProperties {
    static  ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public static final String LOGIN = cfg.lkUserName(); // Логин входа в систему
    public static final String PASSWORD = cfg.lkPassword(); // Пароль входа в систему
    public static final String FIRST_NAME = cfg.firstname(); // Имя пользователя
    public static final String LAST_NAME = cfg.lastname(); // Фамилия пользователя
    public static final String EU_FIRST_NAME = cfg.euFirstName(); // Имя пользователя на латинском
    public static final String EU_LAST_NAME = cfg.euLastName(); // Фамилия пользователя на латинском
    public static final String BLOG_NAME = cfg.blogName(); // Имя пользователя для отображения в блоге
    public static final String DATE_BIRTH = cfg.dateBirth(); // Дата рождения пользователя
    public static final String EMAIL = cfg.contactEmail(); // Email пользователя
    public static final String PHONE = cfg.contactPhone(); // Телефон пользователя
    public static final String MESSENGER_ONE = cfg.contactMessengerOne(); // Первый контакт пользователя
    public static final String MESSENGER_TWO = cfg.contactMessengerTwo(); // Второй контакт пользователя
    public static final String MESSENGER_ONE_LINK = cfg.contactMessengerOneLink(); // Значение контакта №1
    public static final String MESSENGER_TWO_LINK = cfg.contactMessengerTwoLink(); // Значение контакта №2

}
