package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static configuration.ConfigProperties.*;
import static elements.CareerElements.*;


public class CareerPage {
    final public static Logger logger = Logger.getLogger(CareerPage.class);

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = SEARCH_VACANCY)
    private WebElement searchVacancy;

    @FindBy(xpath = SEARCH_RESULT_VACANCY)
    private WebElement searchResultVacancy;

    @FindBy(xpath = ALL_VACANCIES)
    private WebElement allVacancies;

    @FindBy(xpath = ALL_OUR_CLIENTS)
    private WebElement allClients;

    public CareerPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Поиск вакансий
    @Step("Поиск вакансий по фразе \"{searchString}\"")
    public CareerPage searchVacancies(String searchString) {
        searchVacancy.clear();
        searchVacancy.sendKeys(searchString);
        searchVacancy.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULT_VACANCY)));
        String vacancy = searchResultVacancy.getText().toLowerCase();
        Assert.assertTrue(vacancy.contains(SEARCH_VACANCY_STRING));
        System.out.println("На странице поиска в названии вакансий присутствует искомая фраза '" + SEARCH_VACANCY_STRING + "'");
        PageFactory.initElements(driver, this);
        return this;
    }

    //Переключение с текущей вкладки на следующую
    @Step("Переключение с текущей вкладки на следующую")
    public void switchToTab() {
        for (String handle: driver.getWindowHandles()) {
//            System.out.println(handle);
            driver.switchTo().window(handle);
        }
    }

    //Открытие страницы "Все вакансии"
    @Step("Открытие страницы \"Все вакансии\"")
    public CareerPage allVacancies() {
        allVacancies.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VACANCIES)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открытие страницы "Все компании"
    @Step("Открытие страницы \"Все компании\"")
    public CareerPage allCompanies() {
        allClients.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALL_COMPANIES)));
        PageFactory.initElements(driver, this);
        return this;
    }

}
