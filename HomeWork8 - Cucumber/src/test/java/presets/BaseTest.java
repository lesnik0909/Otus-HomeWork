package presets;

import configuration.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {
    final private Logger logger = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setupSuite() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    @BeforeClass
    public void setupClass() {

    }

    @BeforeMethod
    public void setupTest() {
        logger.info("Start test");
    }

    @AfterMethod
    public void teardown() {
        logger.info("Finish test");
    }

    @AfterSuite
    public void stopAllDrivers() {
        DriverManager.stopAllDrivers();
    }

}
