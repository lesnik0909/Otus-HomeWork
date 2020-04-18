package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static elements.MainElements.*;

public class MainPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = SEARCH)
    public WebElement search;

    @FindBy (xpath =INPUT_SEARCH)
    public WebElement inputSearch;

    @FindBy (xpath = SEARCH_RESULT_TITLE)
    public List<WebElement> searchResultTitle;

    @FindBy (xpath = SERVICES_HABR)
    public WebElement servicesHabr;

    @FindBy (xpath = HABR)
    public WebElement habr;

    @FindBy (xpath = Q_AND_A)
    public WebElement qAndA;

    @FindBy (xpath = CAREER)
    public WebElement career;

    @FindBy (xpath = FREELANCE)
    public WebElement freelance;

    @FindBy (xpath = LOGO)
    public WebElement logo;

    @FindBy (xpath = SWITCH_BUTTON)
    public WebElement switchButton;

    @FindBy (xpath = SUBMIT_SETTING)
    public WebElement submitSetting;

    @FindBy (xpath = TO_COME_IN)
    public WebElement toComeIn;

    @FindBy (xpath = REGISTRATION)
    public WebElement registration;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

}
