package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import presets.DriverManager;

import java.util.List;

import static elements.MainElements.*;

public class MainPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = BANNER)
    public WebElement banner;

    @FindBy(xpath = OPEN_LOGIN)
    public WebElement openLogin;

    @FindBy(xpath = INPUT_LOGIN)
    public WebElement inputLogin;

    @FindBy(xpath = INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy (xpath = SUBMIT_LOGIN_PAGE)
    public WebElement submitLoginPage;

    @FindBy (xpath = ERROR_MESSAGE)
    public WebElement errorMessage;

    @FindBy (xpath = CHOOSE_COURSE)
    public WebElement chooseCourse;

    @FindBy (xpath = TESTING)
    public WebElement testing;

    @FindBy (xpath = HOME_PAGE)
    public WebElement homePage;

    @FindBy (xpath = CLOSE_PAGE_LOGIN)
    public WebElement closePageLogin;

    public MainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
        PageFactory.initElements(driver, this);
    }

}
