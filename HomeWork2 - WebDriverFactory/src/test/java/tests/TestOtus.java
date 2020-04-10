package tests;

import presets.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import static elements.Elements.*;


public class TestOtus extends BaseTest {
    @Test
    public void OtusOpen() throws InterruptedException {

        driver.get(SYSTEM_URL);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        try {
            driver.findElement(By.cssSelector(BANNER)).click();

        } catch (Exception e) {
        }
        driver.findElement(By.cssSelector("div.button.button_white.button_white-inverse-transparent.button_md-3.button_radius-md")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://otus.ru/categories/programming/"));

        Thread.sleep(1000);
    }
}

