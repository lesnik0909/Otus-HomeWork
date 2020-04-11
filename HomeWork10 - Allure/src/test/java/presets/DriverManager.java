package presets;

import configuration.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final public static Logger logger = Logger.getLogger(BaseTest.class);
    public static WebDriver driver;

    public static WebDriver getDriver() {
        String browserName = getParameter().toLowerCase();
        logger.info("Start browser: " + browserName);

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions());
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new OperaOptions());
                break;
        }

        driver.manage().window().maximize();
        //Ожидание открытия страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Неявленые ожидания
        driver.manage().timeouts().implicitlyWait(cfg.testsImplicitlyWaitingTime(), TimeUnit.SECONDS);

        return driver;
    }

    //Явные ожидания
    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), cfg.testsWaitingTime());
    }

    public static void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public static void deleteCookie() {
        driver.manage().deleteAllCookies();
    }

    public static String getParameter() {
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
