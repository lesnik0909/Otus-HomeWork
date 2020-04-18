package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CareerPage;

import static configuration.ConfigProperties.*;
import static elements.CareerElements.*;

public class CareerSteps {
    final public static Logger logger = Logger.getLogger(CareerPage.class);

    WebDriver driver;
    WebDriverWait wait;

    CareerPage careerPage;

    public CareerSteps(WebDriver driver, WebDriverWait wait) {
        careerPage = new CareerPage(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    //Поиск вакансий
    public CareerSteps searchVacancies(String searchString) {
        careerPage.searchVacancy.clear();
        careerPage.searchVacancy.sendKeys(searchString);
        careerPage.searchVacancy.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULT_VACANCY)));
        String vacancy = careerPage.searchResultVacancy.getText().toLowerCase();
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
    public CareerSteps allVacancies() {
        careerPage.allVacancies.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VACANCIES)));
        return this;
    }

    //Открытие страницы "Все компании"
    public CareerSteps allCompanies() {
        careerPage.allClients.click();
        switchToTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALL_COMPANIES)));
        return this;
    }

}
