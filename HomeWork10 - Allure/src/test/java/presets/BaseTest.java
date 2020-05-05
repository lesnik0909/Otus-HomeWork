package presets;

import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class BaseTest {
    final static private Logger logger = Logger.getLogger(BaseTest.class);
    protected static WebDriver driver = DriverManager.getDriver();
    protected static WebDriverWait wait = DriverManager.getDriverWait();

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeSuite
    public void setupSuite() {
//        driver = DriverManager.getDriver();
//        wait = DriverManager.getDriverWait();
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

    @AfterMethod
    public void TestFailure(ITestResult result) {
        if (! result.isSuccess()) {
            saveScreenshot();
        }
    }

    @AfterSuite
    public void stopAllDrivers() {
        DriverManager.stopAllDrivers();
    }

}
