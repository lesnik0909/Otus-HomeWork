package tests;

import presets.BaseTest;
import org.testng.annotations.*;
import steps.MainSteps;


public class Habr extends BaseTest {

    MainSteps mainSteps;

    @BeforeTest
    public void serUpTests() {
        mainSteps = new MainSteps(driver, wait);
    }

    @Test
    public void OpenOtus() {
        mainSteps
                .open()
                .camperTitle();
    }

}