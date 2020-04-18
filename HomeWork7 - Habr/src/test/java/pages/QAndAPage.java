package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static elements.QAndAElements.*;

public class QAndAPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = TO_LEARN_MORE)
    public WebElement toLearnMoreButton;

    public QAndAPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

}
