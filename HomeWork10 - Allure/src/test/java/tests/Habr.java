package tests;

import io.qameta.allure.*;
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

    @BeforeTest
    public void serUpTests() {
        mainSteps = new MainSteps(driver, wait);
        qAndASteps = new QAndASteps(driver, wait);
        careerSteps = new CareerSteps(driver, wait);
    }

    //Проверка открытия сервиса "Habr"
    @Epic("Сервис \"Habr\"")
    @Story("Проверка открытия сервиса \"Habr\"")
    @Description("Проверка открытия сервиса \"Habr\"")
    @Test(description = "Проверка открытия сервиса \"Habr\"")
    public void serviceHabr() {
        mainSteps
                .open()
                .verifyTitle(HABR_TITLE);
    }

    //Проверка открытия сервиса "Q&A"
    @Epic("Сервис \"Q&A\"")
    @Story("Проверка открытия сервиса \"Q&A\"")
    @Description("Проверка открытия сервиса \"Q&A\"")
    @Test(description = "Проверка открытия сервиса \"Q&A\"")
    public void serviceQAndA() {
        mainSteps
                .open()
                .serviceQAndA()
                .verifyTitle(HABR_Q_AND_A_TITLE);
    }

    //Проверка открытия сервиса "Карьера"
    @Epic("Сервис \"Карьера\"")
    @Story("Проверка открытия сервиса \"Карьера\"")
    @Description("Проверка открытия сервиса \"Карьера\"")
    @Test(description = "Проверка открытия сервиса \"Карьера\"")
    public void serviceCareer() {
        mainSteps
                .open()
                .serviceCareer()
                .verifyTitle(HABR_CAREER_TITLE);
    }

    //Проверка открытия сервиса "Фриланс"
    @Epic("Сервис \"Фриланс\"")
    @Story("Проверка открытия сервиса \"Фриланс\"")
    @Description("Проверка открытия сервиса \"Фриланс\"")
    @Test(description = "Проверка открытия сервиса \"Фриланс\"")
    public void serviceFreelance() {
        mainSteps
                .open()
                .serviceFreelance()
                .verifyTitle(HABR_FREELANCE_TITLE);
    }

    //Поиск на сервисе "Habr"
    @Epic("Сервис \"Habr\"")
    @Story("Поиск на сервисе \"Habr\"")
    @Description("Поиск на сервисе \"Habr\"")
    @Test(description = "Поиск на сервисе \"Habr\"")
    public void habrSearch() {
        mainSteps
                .open()
                .searchOpen()
                .search(SEARCH_STRING, SEARCH_RESULT_TITLE);
    }

    //Проверка фильтров на сервисе "Habr" по времени
    @Epic("Сервис \"Habr\"")
    @Story("Проверка фильтров на сервисе \"Habr\" по времени")
    @Description("Проверка фильтров на сервисе \"Habr\" по времени")
    @Test(description = "Проверка фильтров на сервисе \"Habr\" по времени")
    public void habrFiltersTime() {
        mainSteps
                .open()
                .filtersTime("Сутки", DAY_FILTERS)
                .filtersTime("Неделя", WEEK_FILTERS)
                .filtersTime("Месяц", MONTH_FILTERS)
                .filtersTime("Год", YEAR_FILTERS);
    }

    //Проверка фильтров на сервисе "Habr" по типу
    @Epic("Сервис \"Habr\"")
    @Story("Проверка фильтров на сервисе \"Habr\" по типу")
    @Description("Проверка фильтров на сервисе \"Habr\" по типу")
    @Test(description = "Проверка фильтров на сервисе \"Habr\" по типу")
    public void habrFiltersType() {
        mainSteps
                .open()
                .filtersType("Все подряд");
    }

    //Поиск на сервисе "Q&A"
    @Epic("Сервис \"Q&A\"")
    @Story("Поиск на сервисе \"Q&A\"")
    @Description("Поиск на сервисе \"Q&A\"")
    @Test(description = "Поиск на сервисе \"Q&A\"")
    public void QAndASearch() {
        mainSteps
                .open()
                .serviceQAndA()
                .search(SEARCH_STRING, SEARCH_RESULT_QUESTION);
    }

    //Проверка фильтров на сервисе "Q&A" по типу
    @Epic("Сервис \"Q&A\"")
    @Story("Проверка фильтров на сервисе \"Q&A\" по типу")
    @Description("Проверка фильтров на сервисе \"Q&A\" по типу")
    @Test(description = "Проверка фильтров на сервисе \"Q&A\" по типу")
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
    @Epic("Сервис \"Q&A\"")
    @Story("Проверка кнопки \"О сервисе\" на сервисе \"Q&A\"")
    @Description("Проверка кнопки \"О сервисе\" на сервисе \"Q&A\"")
    @Test(description = "Проверка кнопки \"О сервисе\" на сервисе \"Q&A\"")
    public void QAndAAboutService() {
        mainSteps
                .open()
                .serviceQAndA();
        qAndASteps.AboutServicePage();
        mainSteps.verifyTitle(HABR_Q_AND_A_HELP_TITLE);
    }

    //Поиск на сервисе "Карьера"
    @Epic("Сервис \"Карьера\"")
    @Story("Поиск на сервисе \"Карьера\"")
    @Description("Поиск на сервисе \"Карьера\"")
    @Test(description = "Поиск на сервисе \"Карьера\"")
    public void careerSearchVacancies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.searchVacancies(SEARCH_VACANCY_STRING);
    }

    //Все вакансии на сервисе "Карьера"
    @Epic("Сервис \"Карьера\"")
    @Story("Все вакансии на сервисе \"Карьера\"")
    @Description("Все вакансии на сервисе \"Карьера\"")
    @Test(description = "Все вакансии на сервисе \"Карьера\"")
    public void careerAllVacancies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.allVacancies();
        mainSteps.verifyTitle(HABR_CAREER_VACANCIES_TITLE);
    }

    //Все компании на сервисе "Карьера"
    @Epic("Сервис \"Карьера\"")
    @Story("Все компании на сервисе \"Карьера\"")
    @Description("Все компании на сервисе \"Карьера\"")
    @Test(description = "Все компании на сервисе \"Карьера\"")
    public void careerAllCompanies() {
        mainSteps
                .open()
                .serviceCareer();
        careerSteps.allCompanies();
        mainSteps.verifyTitle(HABR_CAREER_COMPANIES_TITLE);
    }

    //Переключение языка на сервисе "Habr"
    @Epic("Сервис \"Habr\"")
    @Story("Переключение языка на сервисе \"Habr\"")
    @Description("Переключение языка на сервисе \"Habr\"")
    @Test(description = "Переключение языка на сервисе \"Habr\"")
    public void habrSwitchLanguage() {
        mainSteps
                .open()
                .switchLanguage(ENGLISH, ALL_STREAMS_EN)
                .verifyTitle(HABR_EN_TITLE)
                .switchLanguage(RUSSIAN, ALL_STREAMS_RU)
                .verifyTitle(HABR_TITLE);
    }

    //Кнопка "Войти" на сервисе "Habr"
    @Epic("Сервис \"Habr\"")
    @Story("Кнопка \"Войти\" на сервисе \"Habr\"")
    @Description("Кнопка \"Войти\" на сервисе \"Habr\"")
    @Test(description = "Кнопка \"Войти\" на сервисе \"Habr\"")
    public void habrToComeIn() {
        mainSteps
                .open()
                .toComeIn()
                .verifyTitle(HABR_ENTRANCE_TITLE);
    }

    //Кнопка "Регистрация" на сервисе "Habr"
    @Epic("Сервис \"Habr\"")
    @Story("Кнопка \"Регистрация\" на сервисе \"Habr\"")
    @Description("Кнопка \"Регистрация\" на сервисе \"Habr\"")
    @Test(description = "Кнопка \"Регистрация\" на сервисе \"Habr\"")
    public void habrRegistration() {
        mainSteps
                .open()
                .registration()
                .verifyTitle(HABR_REGISTRATION_TITLE);
    }

}