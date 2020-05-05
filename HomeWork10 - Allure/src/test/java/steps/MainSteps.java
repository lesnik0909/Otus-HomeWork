package steps;

import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;
import presets.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static configuration.ConfigProperties.SEARCH_STRING;
import static configuration.Url.*;
import static elements.MainElements.*;

public class MainSteps {
    final public static Logger logger = Logger.getLogger(MainSteps.class);

    WebDriver driver;
    WebDriverWait wait;

    MainPage mainPage;

    public MainSteps(WebDriver driver, WebDriverWait wait) {
        mainPage = new MainPage(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    //Открытие ресурса
    @Step("Открытие ресурса")
    public MainSteps open() {
        driver.get(URL_SYSTEM);
        BaseTest.saveScreenshot();
        return this;
    }

    //Проверка соответствия заголовка страницы
    @Step("Проверка соответствия заголовка страницы")
    public MainSteps verifyTitle(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        return this;
    }

    //Проверка фильтров статей по времени
    @Step("Проверка фильтров статей по времени \"{time}\"")
    public MainSteps filtersTime(String filterName, String time) {
        mainPage.getFilterPosts(filterName).click();
        wait.until(ExpectedConditions.titleContains("Лучшие публикации за " + time + " / Хабр"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Лучшие публикации за " + time + " / Хабр";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        return this;
    }

    //Проверка фильтров статей по типу
    @Step("Проверка фильтров статей по типу")
    public MainSteps filtersType(String filterName) {
        mainPage.getFilterPosts(filterName).click();
        wait.until(ExpectedConditions.titleContains("Все публикации подряд / Хабр"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Все публикации подряд / Хабр";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        return this;
    }

    //Открытие сервиса "Q&A"
    @Step("Открытие сервиса \"Q&A\"")
    public MainSteps serviceQAndA() {
        mainPage.servicesHabr.click();
        mainPage.qAndA.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO)));
        return this;
    }

    //Открытие сервиса "Карьера"
    @Step("Открытие сервиса \"Карьера\"")
    public MainSteps serviceCareer() {
        mainPage.servicesHabr.click();
        mainPage.career.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO)));
        return this;
    }

    //Открытие сервиса "Фриланс"
    @Step("Открытие сервиса \"Фриланс\"")
    public MainSteps serviceFreelance() {
        mainPage.servicesHabr.click();
        mainPage.freelance.click();
        return this;
    }

    //Открытие строки поиска на "Habr"
    @Step("Открытие строки поиска на \"Habr\"")
    public MainSteps searchOpen() {
        mainPage.search.click();
        return this;
    }

    //Поиск поста или вопроса
    @Step("Поиск поста или вопроса по фразе \"{searchString}\"")
    public MainSteps search(String searchString, String searchResultTitle) {
        mainPage.inputSearch.clear();
        mainPage.inputSearch.sendKeys(searchString);
        mainPage.inputSearch.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultTitle)));
        //Определить общее количество элементов на странице
        List<WebElement> searchResult = driver.findElements(By.xpath(searchResultTitle));
        //Получить текст элементов
        ArrayList<String> searchResultTitles = new ArrayList<>();
        for (int counter = 0; counter < searchResult.size(); counter++) {
            searchResultTitles.add(searchResult.get(counter).getText().toLowerCase());
//            logger.info(searchResultTitles.get(counter));
            Assert.assertTrue(searchResultTitles.get(counter).contains(SEARCH_STRING), "На странице поиска в названии постов отсутствует искомая фраза '" + SEARCH_STRING + "'");
        }
        logger.info("На странице поиска в названии постов присутствует искомая фраза '" + SEARCH_STRING + "'");
        return this;
    }

    //Переключение языка на "Habr"
    @Step("Переключение языка на \"Habr\"")
    public MainSteps switchLanguage(String language, String heading) {
        mainPage.switchButton.click();
        driver.findElement(By.xpath(language)).click();
        mainPage.submitSetting.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(heading)));
        return this;
    }

    //Кнопка "Войти" на "Habr"
    @Step("Кнопка \"Войти\" на \"Habr\"")
    public MainSteps toComeIn() {
        mainPage.toComeIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADING_ENTRANCE)));
        return this;
    }

    //Кнопка "Регистрация" на "Habr"
    @Step("Кнопка \"Регистрация\" на \"Habr\"")
    public MainSteps registration() {
        mainPage.registration.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADING_REGISTRATION)));
        return this;
    }

}
