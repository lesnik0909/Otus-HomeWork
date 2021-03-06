package tests;

import presets.BaseTest;
import org.testng.annotations.*;
import steps.CareerSteps;
import steps.MainSteps;
import steps.QAndASteps;

import static configuration.ConfigProperties.*;
import static elements.MainElements.*;
import static elements.QAndAElements.*;


public class Habr extends BaseTest {

    MainSteps mainSteps;
    QAndASteps qAndASteps;
    CareerSteps careerSteps;

    @BeforeMethod
    public void serUpTests() {
        mainSteps = new MainSteps(driver, wait);
        qAndASteps = new QAndASteps(driver, wait);
        careerSteps = new CareerSteps(driver, wait);
    }

    //Проверка открытия сервиса "Habr"
    @Test
    public void serviceHabr() {
        mainSteps
                .open()
                .verifyTitle(HABR_TITLE);
    }

    //Проверка открытия сервиса "Q&A"
    @Test
    public void serviceQAndA() {
        mainSteps
                .open()
                .serviceQAndA()
                .verifyTitle(HABR_Q_AND_A_TITLE);
    }

    //Проверка открытия сервиса "Карьера"
    @Test
    public void serviceCareer() {
        mainSteps
                .open()
                .serviceCareer()
                .verifyTitle(HABR_CAREER_TITLE);
    }

    //Проверка открытия сервиса "Фриланс"
    @Test
    public void serviceFreelance() {
        mainSteps
                .open()
                .serviceFreelance()
                .verifyTitle(HABR_FREELANCE_TITLE);
    }

    //Поиск на сервисе "Habr"
    @Test
    public void habrSearch() {
        mainSteps
                .open()
                .searchOpen()
                .search(SEARCH_STRING, SEARCH_RESULT_TITLE);
    }

    //Проверка фильтров на сервисе "Habr" по времени
    @Test
    public void habrFiltersTime() {
        mainSteps
                .open()
                .filtersTime("Сутки", DAY_FILTERS)
                .filtersTime("Неделя", WEEK_FILTERS)
                .filtersTime("Месяц", MONTH_FILTERS)
                .filtersTime("Год", YEAR_FILTERS);
    }

    //Проверка фильтров на сервисе "Habr" по типу
    @Test
    public void habrFiltersType() {
        mainSteps
                .open()
                .filtersType("Все подряд");
    }

    //Поиск на сервисе "Q&A"
    @Test
    public void QAndASearch() {
        mainSteps
                .open()
                .serviceQAndA()
                .search(SEARCH_STRING, SEARCH_RESULT_QUESTION);
    }

    //Проверка фильтров на сервисе "Q&A" по типу
    @Test
    public void QAndAFilters() {
        mainSteps
                .open()
                .serviceQAndA();
        qAndASteps
                .filtersQuestions("Интересные", INTERESTING_QUESTIONS_FILTERS)
                .filtersQuestions("Новые вопросы", NEW_QUESTIONS_FILTERS)
                .filtersQuestions("Без ответа", UNANSWERED_QUESTIONS_FILTERS);
    }

    //Проверка кнопки "О сервисе" на сервисе "Q&A"
    @Test
    public void QAndAAboutService() {
        mainSteps
                .open()
                .serviceQAndA();
        qAndASteps.AboutServicePage();
        mainSteps.verifyTitle(HABR_Q_AND_A_HELP_TITLE);
    }

    //Поиск на сервисе "Карьера"
    @Test
    public void careerSearchVacancies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.searchVacancies(SEARCH_VACANCY_STRING);
    }

    //Все вакансии на сервисе "Карьера"
    @Test
    public void careerAllVacancies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.allVacancies();
        mainSteps.verifyTitle(HABR_CAREER_VACANCIES_TITLE);
    }

    //Все компании на сервисе "Карьера"
    @Test
    public void careerAllCompanies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.allCompanies();
        mainSteps.verifyTitle(HABR_CAREER_COMPANIES_TITLE);
    }

    //Переключение языка на сервисе "Habr"
    @Test
    public void habrSwitchLanguage() {
        mainSteps
                .open()
                .switchLanguage(ENGLISH, ALL_STREAMS_EN)
                .verifyTitle(HABR_EN_TITLE)
                .switchLanguage(RUSSIAN, ALL_STREAMS_RU)
                .verifyTitle(HABR_TITLE);
    }

    //Кнопка "Войти" на сервисе "Habr"
    @Test
    public void habrToComeIn() {
        mainSteps
                .open()
                .toComeIn()
                .verifyTitle(HABR_ENTRANCE_TITLE);
    }

    //Кнопка "Регистрация" на сервисе "Habr"
    @Test
    public void habrRegistration() {
        mainSteps
                .open()
                .registration()
                .verifyTitle(HABR_REGISTRATION_TITLE);
    }

}
