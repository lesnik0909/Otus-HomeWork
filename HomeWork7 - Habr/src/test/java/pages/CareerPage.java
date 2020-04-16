package pages;

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
import org.w3c.dom.html.HTMLInputElement;

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
    public WebElement allVacancies;

    @FindBy(xpath = ALL_OUR_CLIENTS)
    public WebElement allClients;

    public CareerPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Поиск вакансий
    public CareerPage searchVacancies(String searchString) {
        searchVacancy.clear();
        searchVacancy.sendKeys(searchString);
        searchVacancy.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULT_VACANCY)));
        String vacancy = searchResultVacancy.getText().toLowerCase();
        Assert.assertTrue(vacancy.contains(SEARCH_VACANCY_STRING), "На странице поиска в названии вакансии отсутствует искомая фраза '" + SEARCH_VACANCY_STRING + "'");
        logger.info("На странице поиска в названии вакансии присутствует искомая фраза '" + SEARCH_VACANCY_STRING + "'");
        return this;
    }

    //Переключение с текущей вкладки на следующую
    public void switchToTab() {
        for (String handle: driver.getWindowHandles()) {
//            System.out.println(handle);
            driver.switchTo().window(handle);
        }
    }

    //Открытие страницы "Все вакансии"
    public CareerPage allVacancies() {
        allVacancies.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VACANCIES)));
        return this;
    }

    //Открытие страницы "Все компании"
    public CareerPage allCompanies() {
        allClients.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALL_COMPANIES)));
        return this;
    }

}
