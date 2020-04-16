package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static elements.QAndAElements.*;

public class QAndAPage {
    final public static Logger logger = Logger.getLogger(MainPage.class);

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = TO_LEARN_MORE)
    public WebElement toLearnMoreButton;

    public QAndAPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getFilterQuestions(String filterName) {
        return driver.findElement(By.xpath("//div[contains(@class, 'page__filters')]//a[contains(text(), '" + filterName +"')]"));
    }

    //Фильтры вопросов
    public QAndAPage filtersQuestions(String filterName, String type) {
        getFilterQuestions(filterName).click();
        wait.until(ExpectedConditions.titleContains(type + " — Хабр Q&A"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = type + " — Хабр Q&A";
        Assert.assertEquals(ActualTitle, ExpectedTitle, "Фактическое и ожидаемое название страницы не совпадают");
        logger.info("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        return this;
    }

    //Кнопка "Узнать больше"
    public QAndAPage AboutServicePage() {
        toLearnMoreButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ABOUT_SERVICE)));
        Assert.assertTrue(driver.findElement(By.xpath(ABOUT_SERVICE)).isDisplayed(), "Заголовок на странице не найден");
        return this;
    }

}
