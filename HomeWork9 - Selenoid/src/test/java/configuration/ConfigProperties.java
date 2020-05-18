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

    public static final String SEARCH_STRING = cfg.searchString();
    public static final String SEARCH_VACANCY_STRING = cfg.searchVacancyString();
    public static final String HABR_TITLE = cfg.habrTitle();
    public static final String HABR_EN_TITLE = cfg.habrEnTitle();
    public static final String HABR_Q_AND_A_TITLE = cfg.habrQAndATitle();
    public static final String HABR_CAREER_TITLE = cfg.habrCareerTitle();
    public static final String HABR_FREELANCE_TITLE = cfg.habrFreelanceTitle();
    public static final String HABR_Q_AND_A_HELP_TITLE = cfg.habrQAndAHelpTitle();
    public static final String HABR_CAREER_VACANCIES_TITLE = cfg.habrCareerVacanciesTitle();
    public static final String HABR_CAREER_COMPANIES_TITLE = cfg.habrCareerCompaniesTitle();
    public static final String HABR_ENTRANCE_TITLE = cfg.habrEntranceTitle();
    public static final String HABR_REGISTRATION_TITLE = cfg.habrRegistrationTitle();
    public static final String INTERESTING_QUESTIONS_FILTERS = cfg.interestingQuestionsFilters();
    public static final String NEW_QUESTIONS_FILTERS = cfg.newQuestionsFilters();
    public static final String UNANSWERED_QUESTIONS_FILTERS = cfg.unansweredQuestionsFilters();
    public static final String DAY_FILTERS = cfg.dayFilters();
    public static final String WEEK_FILTERS = cfg.weekFilters();
    public static final String MONTH_FILTERS = cfg.monthFilters();
    public static final String YEAR_FILTERS = cfg.yearFilters();
}
