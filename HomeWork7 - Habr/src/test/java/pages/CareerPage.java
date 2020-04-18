package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static elements.CareerElements.*;


public class CareerPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = SEARCH_VACANCY)
    public WebElement searchVacancy;

    @FindBy(xpath = SEARCH_RESULT_VACANCY)
    public WebElement searchResultVacancy;

    @FindBy(xpath = ALL_VACANCIES)
    public WebElement allVacancies;

    @FindBy(xpath = ALL_OUR_CLIENTS)
    public WebElement allClients;

    public CareerPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

}
