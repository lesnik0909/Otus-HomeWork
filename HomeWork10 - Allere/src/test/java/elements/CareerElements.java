package elements;

public class CareerElements {
    public static final String SEARCH_VACANCY = "//input[contains(@name, 'q')]"; //Поле ввода в строке поиска
    public static final String SEARCH_RESULT_VACANCY = "//div[contains(@class, 'vacancy-card__title')]"; //Заголовки вакансий на странице поиска
    public static final String ALL_VACANCIES = "//a[contains(@class, 'btn-blue') and contains(text(), 'Все вакансии')]"; //Ссылка "Все вакансии"
    public static final String VACANCIES = "//h1[contains(@class, 'page-title__title') and contains(text(), 'Вакансии')]"; //Заголовок на странице "Все вакансии"
    public static final String ALL_OUR_CLIENTS = "//a[contains(@class, 'btn-blue') and contains(text(), 'Все наши клиенты')]"; //Ссылка "Все наши клиенты"
    public static final String ALL_COMPANIES = "//a[contains(text(), 'Все компании')]"; //Заголовок на странице "Все компании"

}
