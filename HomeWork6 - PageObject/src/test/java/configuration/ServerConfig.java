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

    @Key("personal.firstname")
    @DefaultValue("Иван")
    String firstname();

    @Key("personal.lastname")
    @DefaultValue("Иванов")
    String lastname();

    @Key("personal.eu.firstname")
    @DefaultValue("Ivan")
    String euFirstName();

    @Key("personal.eu.lastname")
    @DefaultValue("Ivanov")
    String euLastName();

    @Key("personal.blogname")
    @DefaultValue("Ivan0345")
    String blogName();

    @Key("personal.datebirth")
    @DefaultValue("10.10.2000")
    String dateBirth();

    @Key("personal.contacts.email")
    @DefaultValue("test@test.ru")
    String contactEmail();

    @Key("personal.contacts.phone")
    @DefaultValue("+79000000000")
    String contactPhone();

    @Key("personal.contacts.messenger.one")
    @DefaultValue("Тelegram")
    String contactMessengerOne();

    @Key("personal.contacts.messenger.two")
    @DefaultValue("WhatsApp")
    String contactMessengerTwo();

    @Key("personal.contacts.messenger.one.link")
    @DefaultValue("@test1")
    String contactMessengerOneLink();

    @Key("personal.contacts.messenger.two.link")
    @DefaultValue("+79000000000")
    String contactMessengerTwoLink();

}
