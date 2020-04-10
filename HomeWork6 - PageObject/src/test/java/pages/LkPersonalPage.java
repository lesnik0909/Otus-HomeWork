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
import java.util.List;
import static configuration.ConfigProperties.*;
import static configuration.Url.*;
import static elements.LoginElements.*;
import static elements.LkPersonalElements.*;

public class LkPersonalPage {
    final public static Logger logger = Logger.getLogger(LkPersonalPage.class);

    WebDriver driver;
    WebDriverWait wait;

    String emailValue;
    String phoneValue;

    @FindBy(css = BANNER)
    private WebElement banner;

    @FindBy(xpath = OPEN_LOGIN)
    private WebElement openLogin;

    @FindBy (xpath = LK)
    private WebElement lk;

    @FindBy (xpath = MY_PROFILE)
    private WebElement myProfile;

    @FindBy (xpath = INPUT_FIRST_NAME)
    private WebElement inputFirstName;

    @FindBy (xpath = INPUT_LAST_NAME)
    private WebElement inputLastName;

    @FindBy (xpath = INPUT_EU_FIRST_NAME)
    private WebElement inputEuFirstName;

    @FindBy (xpath = INPUT_EU_lAST_NAME)
    private WebElement inputEuLastName;

    @FindBy (xpath = INPUT_BLOG_NAME)
    private WebElement inputBlogName;

    @FindBy (xpath = INPUT_DATE_BIRTH)
    private WebElement inputBirthDate;

    @FindBy (xpath = INPUT_EMAIL)
    private WebElement inputEmail;

    @FindBy (xpath = INPUT_PHONE)
    private WebElement inputPhone;

    @FindBy (xpath = COMMUNICATION_METHOD)
    private List<WebElement> communicationMethod;

    @FindBy (xpath = ADD_COMMUNICATION_METHOD)
    private WebElement addCommunicationMethod;

    @FindBy (xpath = SUBMIT_PERSONAL_FORM)
    private WebElement submitPersonalForm;

    public LkPersonalPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //Открыть страницу авторизации
    public LkPersonalPage open() throws InterruptedException {
        driver.get(URL_SYSTEM);
        try {
            banner.click();
        } catch (Exception e) {
        }
        openLogin.click();
        PageFactory.initElements(driver, this);
        return this;
    }

    //Открыть страницу "О себе" в личном кабинете
    public  LkPersonalPage profile() {
        lk.click();
        myProfile.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITTLE_LK_PAGE)));
        PageFactory.initElements(driver, this);
        return this;
    }

    //Изменение ФИО и ДР пользователя
    public LkPersonalPage editAllName() {
        inputFirstName.clear();
        inputFirstName.sendKeys(FIRST_NAME);
        inputLastName.clear();
        inputLastName.sendKeys(LAST_NAME);
        inputEuFirstName.clear();
        inputEuFirstName.sendKeys(EU_FIRST_NAME);
        inputEuLastName.clear();
        inputEuLastName.sendKeys(EU_LAST_NAME);
        inputBlogName.clear();
        inputBlogName.sendKeys(BLOG_NAME);
        inputBirthDate.clear();
        inputBirthDate.sendKeys(DATE_BIRTH);
        PageFactory.initElements(driver, this);
        return this;
    }

    //Изменение Email пользователя
    public LkPersonalPage setEmail() {
        emailValue = inputEmail.getAttribute("value");
        try {
            inputEmail.clear();
            inputEmail.sendKeys(EMAIL);
        } catch (Exception e) {
            logger.info("Поле 'Email' содержит данные " + emailValue + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    //Изменение телефона пользователя
    public LkPersonalPage setPhone() {
        phoneValue = inputPhone.getAttribute("value");
        try {
            inputPhone.clear();
            inputPhone.sendKeys(PHONE);
        } catch (Exception e) {
            logger.info("Поле 'Email' содержит данные " + phoneValue + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    //Добавление нового контакта
    public LkPersonalPage addContact(Integer numberContact, String nameContact, String linkContact) {

        List<WebElement> inputContacts = communicationMethod;
        WebElement selectElement = inputContacts.get(numberContact);
        selectElement.click();

        List<WebElement> contact = driver.findElements(By.xpath("//button[contains(@title, '" + nameContact + "')]"));
        WebElement selectContact = contact.get(numberContact);
        selectContact.click();

        driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + numberContact + "-value')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + numberContact + "-value')]")).sendKeys(linkContact);

        PageFactory.initElements(driver, this);
        return this;
    }

    //Добавление нового поля для добавления контакта
    public LkPersonalPage addNewContact() {
        addCommunicationMethod.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_INPUT_COMMUNICATION_CONTACT)));
        PageFactory.initElements(driver, this);
        return this;
    }
    //Сохранение данных пользователя
    public LkPersonalPage submitPersonalForm() {
        submitPersonalForm.click();

        PageFactory.initElements(driver, this);
        return this;
    }
    //Проверка сохраненых данных
    public LkPersonalPage assertPesronalData() {
        String firstNameValue = inputFirstName.getAttribute("value");
        String lastNameValue = inputLastName.getAttribute("value");
        String euFirstNameValue = inputEuFirstName.getAttribute("value");
        String euLastNameValue = inputEuLastName.getAttribute("value");
        String blogNameValue = inputBlogName.getAttribute("value");
        String birthDateValue = inputBirthDate.getAttribute("value");

        try {
            Assert.assertEquals(firstNameValue, FIRST_NAME);
            Assert.assertEquals(lastNameValue, LAST_NAME);
            Assert.assertEquals(euFirstNameValue, EU_FIRST_NAME);
            Assert.assertEquals(euLastNameValue, EU_LAST_NAME);
            Assert.assertEquals(blogNameValue, BLOG_NAME);
            Assert.assertEquals(birthDateValue, DATE_BIRTH);
        } catch (AssertionError e) {
            logger.info("Введеные данные по пользователю не сохранились");
            Assert.fail(e.getMessage());
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    //Проверка сохранения контакта
    public LkPersonalPage assertContact(Integer numberContact, String linkContact) {
        String inputValue = driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + numberContact + "-value')]")).getAttribute("value");
        try {
            Assert.assertEquals(inputValue, linkContact);
        } catch (AssertionError e) {
            logger.info("Контакт с значением" + linkContact + " не сохранился");
            Assert.fail(e.getMessage());
        }
        PageFactory.initElements(driver, this);
        return this;
    }

}
