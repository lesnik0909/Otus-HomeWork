package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

import static configuration.Url.*;

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
    @Given("I open main page")
    public MainSteps open() {
        driver.get(URL_SYSTEM);
        return this;
    }

    @Then("I check open page")
    public MainSteps camperTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        Assert.assertEquals(actualTitle, expectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + actualTitle + "] matches expected title [" + expectedTitle + "]");
        return this;
    }

}
