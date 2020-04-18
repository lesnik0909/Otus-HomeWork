package steps;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CareerPage;
import pages.QAndAPage;

import static elements.QAndAElements.*;


public class QAndASteps {
    final public static Logger logger = Logger.getLogger(CareerPage.class);

    WebDriver driver;
    WebDriverWait wait;

    QAndAPage qAndAPage;

    public QAndASteps(WebDriver driver, WebDriverWait wait) {
        qAndAPage = new QAndAPage(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    //Получение локатора фильтра
    public WebElement getFilterQuestions(String filterName) {
        return driver.findElement(By.xpath("//div[contains(@class, 'page__filters')]//a[contains(text(), '" + filterName +"')]"));
    }

    //Фильтры вопросов
    @Step("Фильтры вопросов, \"{type}\"")
    public QAndASteps filtersQuestions(String filterName, String type) {
        getFilterQuestions(filterName).click();
        wait.until(ExpectedConditions.titleContains(type + " — Хабр Q&A"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = type + " — Хабр Q&A";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        return this;
    }

    //Кнопка "Узнать больше"
    @Step("Кнопка \"Узнать больше\"")
    public QAndASteps AboutServicePage() {
        qAndAPage.toLearnMoreButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ABOUT_SERVICE)));
        Assert.assertTrue(driver.findElement(By.xpath(ABOUT_SERVICE)).isDisplayed(), "Заголовок на странице не найден");
        return this;
    }

}
