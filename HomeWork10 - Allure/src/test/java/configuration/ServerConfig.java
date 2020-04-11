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

    @Key("search.string")
    @DefaultValue("covid-19")
    String searchString();

    @Key("search.vacancy.string")
    @DefaultValue("тестировщик")
    String searchVacancyString();

    @Key("habr.title")
    @DefaultValue("Лучшие публикации за сутки / Хабр")
    String habrTitle();

    @Key("habr.en.title")
    @DefaultValue("Top of the last 24 hours / Habr")
    String habrEnTitle();

    @Key("habr.q&a.title")
    @DefaultValue("Интересные вопросы — Хабр Q&A")
    String habrQAndATitle();

    @Key("habr.career.title")
    @DefaultValue("Работа в IT-индустрии — Хабр Карьера")
    String habrCareerTitle();

    @Key("habr.freelance.title")
    @DefaultValue("Хабр Фриланс")
    String habrFreelanceTitle();

    @Key("habr.q&a.help.title")
    @DefaultValue("О сервисе — Помощь — Хабр Q&A")
    String habrQAndAHelpTitle();

    @Key("habr.career.vacancies.title")
    @DefaultValue("Вакансии — Хабр Карьера")
    String habrCareerVacanciesTitle();

    @Key("habr.career.companies.title")
    @DefaultValue("Компании — Хабр Карьера")
    String habrCareerCompaniesTitle();

    @Key("habr.entrance.title")
    @DefaultValue("Вход — Habr Account")
    String habrEntranceTitle();

    @Key("habr.registration.title")
    @DefaultValue("Регистрация аккаунта — Habr Account")
    String habrRegistrationTitle();

    @Key("interesting.questions.filters")
    @DefaultValue("Интересные вопросы")
    String interestingQuestionsFilters();

    @Key("new.questions.filters")
    @DefaultValue("Новые вопросы")
    String newQuestionsFilters();

    @Key("unanswered.questions.filters")
    @DefaultValue("Вопросы без ответа")
    String unansweredQuestionsFilters();

    @Key("day.filters")
    @DefaultValue("сутки")
    String dayFilters();

    @Key("week.filters")
    @DefaultValue("неделю")
    String weekFilters();

    @Key("month.filters")
    @DefaultValue("месяц")
    String monthFilters();

    @Key("year.filters")
    @DefaultValue("год")
    String yearFilters();

}
