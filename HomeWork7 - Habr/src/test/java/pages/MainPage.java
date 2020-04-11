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

import java.util.ArrayList;
import java.util.List;

import static configuration.ConfigProperties.*;
import static configuration.Url.*;
import static elements.MainElements.*;

public class MainPage {
    final public static Logger logger = Logger.getLogger(MainPage.class);

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = SEARCH)
    private WebElement search;

    @FindBy (xpath =INPUT_SEARCH)
    private WebElement inputSearch;

    @FindBy (xpath = SEARCH_RESULT_TITLE)
    private List<WebElement> searchResultTitle;

    @FindBy (xpath = FILTER_ALL)
    private WebElement all;

    @FindBy (xpath = FILTER_BEST)
    private WebElement best;

    @FindBy (xpath = FILTER_DAY)
    private WebElement day;

    @FindBy (xpath = FILTER_WEEK)
    private WebElement week;

    @FindBy (xpath = FILTER_MONTH)
    private WebElement month;

    @FindBy (xpath = FILTER_YEAR)
    private WebElement year;

    @FindBy (xpath = SERVICES_HABR)
    private WebElement servicesHabr;

    @FindBy (xpath = HABR)
    private WebElement habr;

    @FindBy (xpath = Q_AND_A)
    private WebElement qAndA;

    @FindBy (xpath = CAREER)
    private WebElement career;

    @FindBy (xpath = FREELANCE)
    private WebElement freelance;

    @FindBy (xpath = LOGO)
    private WebElement logo;

    @FindBy (xpath = SWITCH_BUTTON)
    private WebElement switchButton;

    @FindBy (xpath = SUBMIT_SETTING)
    private WebElement submitSetting;

    @FindBy (xpath = TO_COME_IN)
    private WebElement toComeIn;

    @FindBy (xpath = REGISTRATION)
    private WebElement registration;


    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Открытие ресурса
    public MainPage open() {
        driver.get(URL_SYSTEM);
        PageFactory.initElements(driver, this);
        return this;
    }

    //Проверка соответствия заголовка страницы
    public MainPage verifyTitle(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        PageFactory.initElements(driver, this);
        return this;
    }

    //Проверка фильтров статей по времени
    public MainPage filtersTime(String filterTime, String time) {
        driver.findElement(By.xpath(filterTime)).click();
        wait.until(ExpectedConditions.titleContains("Лучшие публикации за " + time + " / Хабр"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Лучшие публикации за " + time + " / Хабр";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        PageFactory.initElements(driver, this);
        return this;
    }

    //Проверка фильтров статей по типу
    public MainPage filtersType(String filterType) {
        driver.findElement(By.xpath(filterType)).click();
        wait.until(ExpectedConditions.titleContains("Все публикации подряд / Хабр"));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Все публикации подряд / Хабр";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("Actual title [" + ActualTitle + "] matches expected title [" + ExpectedTitle + "]");
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открытие сервиса "Q&A"
    public MainPage serviceQAndA() {
        servicesHabr.click();
        qAndA.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открытие сервиса "Карьера"
    public MainPage serviceCareer() {
        servicesHabr.click();
        career.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открытие сервиса "Фриланс"
    public MainPage serviceFreelance() {
        servicesHabr.click();
        freelance.click();
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открытие строки поиска на "Habr"
    public MainPage searchOpen() {
        search.click();
        PageFactory.initElements(driver, this);
        return this;
    }

    //Поиск поста или вопроса
    public MainPage search(String  searchString, String searchResultTitle) {
        inputSearch.clear();
        inputSearch.sendKeys(searchString);
        inputSearch.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultTitle)));
        //Определить общее количество элементов на странице
        List<WebElement> searchResult = driver.findElements(By.xpath(searchResultTitle));

        //Получить текст элементов
        ArrayList<String> searchResultTitles = new ArrayList<>();
        for (int counter = 0; counter < searchResult.size(); counter++) {
            searchResultTitles.add(searchResult.get(counter).getText().toLowerCase());
//            logger.info(searchResultTitles.get(counter));
            Assert.assertTrue(searchResultTitles.get(counter).contains(SEARCH_STRING));
        }
        System.out.println("На странице поиска в названии постов присутствует искомая фраза '" + SEARCH_STRING + "'");
        PageFactory.initElements(driver, this);
        return this;
    }

    //Переключение языка на "Habr"
    public MainPage switchLanguage(String language, String heading) {
        switchButton.click();
        driver.findElement(By.xpath(language)).click();
        submitSetting.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(heading)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Кнопка "Войти" на "Habr"
    public MainPage toComeIn() {
        toComeIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADING_ENTRANCE)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Кнопка "Регистрация" на "Habr"
    public MainPage registration() {
        registration.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADING_REGISTRATION)));
        PageFactory.initElements(driver, this);
        return this;
    }

}
