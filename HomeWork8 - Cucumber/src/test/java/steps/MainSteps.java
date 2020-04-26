package steps;

import cucumber.api.java.en.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;
import presets.DriverManager;

import static configuration.ConfigProperties.*;
import static configuration.Url.*;
import static elements.MainElements.*;

public class MainSteps {
    final public static Logger logger = Logger.getLogger(MainSteps.class);

    WebDriver driver;
    WebDriverWait wait;

    MainPage mainPage;

    public MainSteps() {
        mainPage = new MainPage();
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    //Открытие ресурса
    @Given("Open main page")
    public MainSteps open() {
        driver.get(URL_SYSTEM);
        return this;
    }

    //Закрытие баннера
    public void bannerClose() {
        try {
            mainPage.banner.click();

        } catch (Exception e) {
        }
    }

    //Сравнение заголовка страницы
    public void camperTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + actualTitle + "] matches expected title [" + expectedTitle + "]");
    }

    //Проверка заголовка главной страницы
    @Then("Check main page")
    public MainSteps camperTitleMain() {
        camperTitle("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям");
        return this;
    }

    //Вход в личный кабинет
    @When("Open page LK and login")
    public MainSteps loginLk() {
        mainPage.openLogin.click();
        mainPage.inputLogin.clear();
        mainPage.inputLogin.sendKeys(LOGIN);
        mainPage.inputPassword.clear();
        mainPage.inputPassword.sendKeys(PASSWORD);
        mainPage.submitLoginPage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE)));
        return this;
    }

    //Проверка сообщения об ошибке входа
    @Then("Check error message")
    public MainSteps checkErrorLogin() {
        Assert.assertTrue(mainPage.errorMessage.isDisplayed(), "На странице отсутствует сообщение \"Такая пара логин/пароль не существует\"");
        logger.info("На странице присутствует сообщение \"Такая пара логин/пароль не существует\"");
        return this;
    }

    //Открытие страницы выбора курсов
    @When("Open choose course page")
    public MainSteps chooseCourse() {
        bannerClose();
        mainPage.chooseCourse.click();
        return this;
    }

    //Выбор вкладки "Тестирование"
    @Then("Open testing course page and check title")
    public MainSteps testingCourse() {
        mainPage.testing.click();
        camperTitle("Курсы по тестированию");
        return this;
    }

    //Открытие вкладки "Тестирование" и возврат на главную страницу
    @When("Open course page and return home page")
    public MainSteps openCourse() {
        chooseCourse();
        testingCourse();
        mainPage.homePage.click();
        return this;
    }

    //Открытие и закрытие страницы входа в личный кабинет
    @When("Open and close login page")
    public MainSteps openAndClosePageLogin() {
        mainPage.openLogin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADER_PAGE_LOGIN)));
        mainPage.closePageLogin.click();
        return this;
    }

}
