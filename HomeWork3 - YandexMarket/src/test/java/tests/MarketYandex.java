package tests;

import presets.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import static elements.Elements.*;


public class MarketYandex extends BaseTest {

    final private Logger logger = Logger.getLogger(MarketYandex.class);

    @Test
    public void mobilePhone() throws InterruptedException {
        String item1 = "Xiaomi"; //Производитель 1
        String item2 = "Honor"; //Производитель 2

        //Получить куки с ya.ru
        driver.get("https://ya.ru/");
        Cookie cookie1 = driver.manage().getCookieNamed("yandex_gid");
        Cookie cookie2 = driver.manage().getCookieNamed("yandexuid");

        //Перейти в Маркет и добавить куки
        driver.get(YANDEX_MARKET_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CATEGORIES)));
        driver.manage().addCookie(new Cookie("yandex_gid", cookie1.getValue()));
        driver.manage().addCookie(new Cookie("yandexuid", cookie2.getValue()));

        //Перейти в раздел "Мобильные телефоны"
        driver.findElement(By.xpath(CATEGORIES)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ELECTRONICS)));
        driver.findElement(By.xpath(ELECTRONICS)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SMARTPHONES)));
        driver.findElement(By.xpath(SMARTPHONES)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRISE)));

        //Отсортировать по цене
        driver.findElement(By.xpath(PRISE)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOADER)));

        //Нажать на фильтр "Показать все"
        driver.findElement(By.xpath(SHOW_ALL)).click();

        //Найти и выбрать первого производителя
        driver.findElement(By.xpath(SEARCH)).click();
        driver.findElement(By.xpath(SEARCH)).clear();
        driver.findElement(By.xpath(SEARCH)).sendKeys(item1);
        driver.findElement(By.xpath("//span[contains(text(),'" + item1 + "')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOADER)));

        //Найти и выбрать второго производителя
        driver.findElement(By.xpath(SEARCH)).click();
        driver.findElement(By.xpath(SEARCH)).clear();
        driver.findElement(By.xpath(SEARCH)).sendKeys(item2);
        driver.findElement(By.xpath("//span[contains(text(),'" + item2 + "')]")).click();
        driver.findElement(By.xpath(SEARCH)).clear();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOADER)));

        //Прокрутить страницу вверх
        ((JavascriptExecutor) driver).executeScript("scroll(0,0)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_ITEM + item1 + "')]]")));

        //Добавить первый товар в сравнение
        driver.findElement(By.xpath(TITLE_ITEM + item1 + "')]]" + ADD_COMPARE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUR_INFORMER)));
        //Проверить всплывающее уведомление при добавлении товара в сравнение
        try {
            driver.findElement(By.xpath(POPUR_INFORMER));
            driver.findElement(By.xpath(POPUR_INFORMER_TITLE + item1 + "')]"));
        } catch (Exception e) {
            logger.error(e);
            Assert.fail("Всплывающее сообщение при добавлении товара отсутствует");
        }

        //Добавить второй товар в сравнение
        ((JavascriptExecutor) driver).executeScript("scroll(0,0)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_ITEM + item1 + "')]]")));
        driver.findElement(By.xpath(TITLE_ITEM + item2 + "')]]" + ADD_COMPARE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POPUR_INFORMER)));
        //Проверить всплывающее уведомление при добавлении товара в сравнение
        try {
            driver.findElement(By.xpath(POPUR_INFORMER));
            driver.findElement(By.xpath(POPUR_INFORMER_TITLE + item2 + "')]"));
        } catch (Exception e) {
            logger.error(e);
            Assert.fail("Всплывающее сообщение при добавлении товара отсутствует");
        }

        //Перейти на страницу сравнения товаров
        ((JavascriptExecutor) driver).executeScript("scroll(0,0)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPARE)));
        driver.findElement(By.xpath(COMPARE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ITEMS_COMPARE)));

        //Проверить количество товаров в списке сравнения
        List<WebElement> itemsList = driver.findElements(By.xpath(ITEMS_COMPARE));
        if (itemsList.size() == 2) {
        } else {
            Assert.fail("Ожидается 2 товара в списке сравнение, по факту " + itemsList.size());
        }

        //Нажать на кнопку "Все характеристики"
        driver.findElement(By.xpath(ALL_CHARACTERISTICS)).click();
        //Проверить присутствие характеристики "Операционная система"
        driver.findElement(By.xpath(OPERATIONG_SYSTEM)).click();

        //Нажать на кнопку "Все характеристики"
        driver.findElement(By.xpath(DEFFERENT_CHARACTERISTICS)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOADER)));

        //Проверить отсутствие параметра "Операционная система"
        try {
            driver.findElement(By.xpath(OPERATIONG_SYSTEM));
            logger.info("Параметр 'Операционная система' отсутствует на вкладке 'Различающиеся характеристики'");
        } catch (Exception e) {
            logger.info(e);
            Assert.fail("Параметр 'Операционная система' присутствует на вкладке 'Различающиеся характеристики'");
        }

    }
}
