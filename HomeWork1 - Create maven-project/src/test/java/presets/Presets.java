package presets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverPool;
import configuration.Configuration.*;
import java.util.concurrent.TimeUnit;

public class Presets {
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(Presets.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setupSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.operadriver().setup();
    }

    @BeforeClass
    public void setupClass() {

    }

    @BeforeMethod
    public void setupTest() {
        String browserPatameter = getParament();
        String browserName = browserPatameter.toLowerCase();
        logger.info("Start browser: " + browserName);

        switch (browserName) {
            case "chrome":
                driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
                break;
            case "firefox":
                driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
                break;
            case "ie":
                driver = WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions());
                break;
            case "opera":
                driver = WebDriverPool.DEFAULT.getDriver(new OperaOptions());
                break;
        }

        driver.manage().window().maximize();
        //Ожидание открытия страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Неявленые ожидание
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

    @AfterSuite
    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    private String getParament() {
        String value = System.getProperty("browser");
        if (value == null) {
            return cfg.browserNameProperty();
        } else if (value.isEmpty()) {
            return cfg.browserNameProperty();
        } else {
            return value;
        }
    }
}
