package presets;

import configuration.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private final Logger logger = Logger.getLogger(BaseTest.class);
    DriverManager driverManager = new DriverManager();
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setupSuite() {
        driver = driverManager.getDriver();
        wait = driverManager.getDriverWait();
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
        driverManager.stopAllDrivers();
    }

}
