package tests;

import pages.CareerPage;
import pages.MainPage;
import pages.QAndAPage;
import presets.BaseTest;
import org.testng.annotations.*;
import steps.CareerSteps;
import steps.MainSteps;

import static configuration.ConfigProperties.*;
import static elements.MainElements.*;
import static elements.QAndAElements.*;


public class Habr extends BaseTest {

    MainPage mainPage;
    QAndAPage qAndAPage;
    CareerPage careerPage;

    MainSteps mainSteps;

    @BeforeTest
    public void serUpTests() {
        mainPage = new MainPage(driver, wait);
        qAndAPage = new QAndAPage(driver, wait);
        careerPage = new CareerPage(driver, wait);
        mainSteps = new MainSteps();
    }

    //Проверка выноса методов в steps
    @Test
    public void openCareerResouse() {
        mainSteps.openResourse();
    }

    //Проверка открытия сервиса "Habr"
    @Test
    public void serviceHabr() {
        mainPage
                .open()
                .verifyTitle(HABR_TITLE);
    }

    //Проверка открытия сервиса "Q&A"
    @Test
    public void serviceQAndA() {
        mainPage
                .open()
                .serviceQAndA()
                .verifyTitle(HABR_Q_AND_A_TITLE);
    }

    //Проверка открытия сервиса "Карьера"
    @Test
    public void serviceCareer() {
        mainPage
                .open()
                .serviceCareer()
                .verifyTitle(HABR_CAREER_TITLE);
    }

    //Проверка открытия сервиса "Фриланс"
    @Test
    public void serviceFreelance() {
        mainPage
                .open()
                .serviceFreelance()
                .verifyTitle(HABR_FREELANCE_TITLE);
    }

    //Поиск на сервисе "Habr"
    @Test
    public void habrSearch() {
        mainPage
                .open()
                .searchOpen()
                .search(SEARCH_STRING, SEARCH_RESULT_TITLE);
    }

    //Проверка фильтров на сервисе "Habr" по времени
    @Test
    public void habrFiltersTime() {
        mainPage
                .open()
                .filtersTime("Сутки", DAY_FILTERS)
                .filtersTime("Неделя", WEEK_FILTERS)
                .filtersTime("Месяц", MONTH_FILTERS)
                .filtersTime("Год", YEAR_FILTERS);
    }

    //Проверка фильтров на сервисе "Habr" по типу
    @Test
    public void habrFiltersType() {
        mainPage
                .open()
                .filtersType("Все подряд");
    }

    //Поиск на сервисе "Q&A"
    @Test
    public void QAndASearch() {
        mainPage
                .open()
                .serviceQAndA()
                .search(SEARCH_STRING, SEARCH_RESULT_QUESTION);
    }

    //Проверка фильтров на сервисе "Q&A" по типу
    @Test
    public void QAndAFilters() {
        mainPage
                .open()
                .serviceQAndA();
        qAndAPage
                .filtersQuestions("Интересные", INTERESTING_QUESTIONS_FILTERS)
                .filtersQuestions("Новые вопросы", NEW_QUESTIONS_FILTERS)
                .filtersQuestions("Без ответа", UNANSWERED_QUESTIONS_FILTERS);
    }

    //Проверка кнопки "О сервисе" на сервисе "Q&A"
    @Test
    public void QAndAAboutService() {
        mainPage
                .open()
                .serviceQAndA();
        qAndAPage.AboutServicePage();
        mainPage.verifyTitle(HABR_Q_AND_A_HELP_TITLE);
    }

    //Поиск на сервисе "Карьера"
    @Test
    public void careerSearchVacancies() {
        mainPage
                .open()
                .serviceCareer();
        careerPage.searchVacancies(SEARCH_VACANCY_STRING);
    }

    //Все вакансии на сервисе "Карьера"
    @Test
    public void careerAllVacancies() {
        mainPage
                .open()
                .serviceCareer();
        careerPage.allVacancies();
        mainPage.verifyTitle(HABR_CAREER_VACANCIES_TITLE);
    }

    //Все компании на сервисе "Карьера"
    @Test
    public void careerAllCompanies() {
        mainPage
                .open()
                .serviceCareer();
        careerPage.allCompanies();
        mainPage.verifyTitle(HABR_CAREER_COMPANIES_TITLE);
    }

    //Переключение языка на сервисе "Habr"
    @Test
    public void habrSwitchLanguage() {
        mainPage
                .open()
                .switchLanguage(ENGLISH, ALL_STREAMS_EN)
                .verifyTitle(HABR_EN_TITLE)
                .switchLanguage(RUSSIAN, ALL_STREAMS_RU)
                .verifyTitle(HABR_TITLE);
    }

    //Кнопка "Войти" на сервисе "Habr"
    @Test
    public void habrToComeIn() {
        mainPage
                .open()
                .toComeIn()
                .verifyTitle(HABR_ENTRANCE_TITLE);
    }

    //Кнопка "Регистрация" на сервисе "Habr"
    @Test
    public void habrRegistration() {
        mainPage
                .open()
                .registration()
                .verifyTitle(HABR_REGISTRATION_TITLE);
    }

}