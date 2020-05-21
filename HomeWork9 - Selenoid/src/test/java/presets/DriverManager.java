package presets;

import configuration.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public static final Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            getDriverUnit();
        }
        return driver;
    }

    public WebDriver getDriverUnit() {
        String browserName = getParameter().toLowerCase();
        logger.info("Start browser: " + browserName);

/*        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
                break;
        }*/

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browserName);
            capabilities.setCapability("enableVNC", true);
            driver = new RemoteWebDriver(new URL("http://172.18.37.35:4444/wd/hub/"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        //Ожидание открытия страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Неявленые ожидания
        driver.manage().timeouts().implicitlyWait(cfg.testsImplicitlyWaitingTime(), TimeUnit.SECONDS);

        return driver;
    }

    //Явные ожидания
    public WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), cfg.testsWaitingTime());
    }

    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public void deleteCookie() {
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
