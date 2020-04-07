package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static configuration.ConfigProperties.*;
import static elements.LoginElements.*;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = INPUT_LOGIN)
    private WebElement inputLogin;

    @FindBy(xpath = INPUT_PASSWORD)
    private WebElement inputPassword;

    @FindBy (xpath = SUBMIT_LOGIN_PAGE)
    private WebElement submitLoginPage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Авторизация на странице авторизации
    public LoginPage toAuth() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITTLE_LOGIN_PAGE)));
        inputLogin.clear();
        inputLogin.sendKeys(LOGIN);
        inputPassword.clear();
        inputPassword.sendKeys(PASSWORD);
        submitLoginPage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LK)));
        PageFactory.initElements(driver, this);
        return this;
    }
}
