package tests;

import presets.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;

import org.testng.annotations.*;
import presets.BufferedWriterUtils;

import java.util.ArrayList;
import java.util.List;

import static elements.Elements.*;


public class WebCrawler extends BaseTest {

    final private Logger logger = Logger.getLogger(WebCrawler.class);
    public BufferedWriter bw;

    @Test
    public void testWebCrawler() throws IOException {

        driver.get(SYSTEM_URL);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebElement element = driver.findElement(By.xpath(BUTTON_LOADER));

        List<WebElement> books = new ArrayList<>();
        int currentSize = -1;

        //Прогрузить все элементы на странице, получить список
        while (currentSize < books.size()) {
            currentSize = books.size();

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -5)");

            books = driver.findElements(By.cssSelector(BOOK));
            logger.info("Count books - " + books.size());

            try {
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.invisibilityOfElementLocated(By.xpath(BUTTON_LOADER)),
                        ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(BOOK), currentSize)
                ));
            } catch (TimeoutException ex) {
            }
        }
        logger.info("All books loaded");

        //Определить общее количество элементов
        books = driver.findElements(By.cssSelector(BOOK));
        logger.info("Total count books - " + books.size());

        //Получить ссылки на элементы
        ArrayList<String> urlBooks = new ArrayList<>();
        for (int counter = 0; counter < books.size(); counter++) {
            urlBooks.add(books.get(counter).getAttribute("href"));
            logger.info("Get url book " + (counter + 1) + " of " + books.size());
            logger.info("Value - " + urlBooks.get(counter));
        }
        logger.info("Total link books - " + urlBooks.size());

        //Получить дополнительную информацию по элементу и записать в CSV
        String title;
        String author;
        String price;
        String linkDownloadTrialFragment;

        //Записать данные в файл
        String header = ("Ссылка на книгу; Название; Автор; Цена; Ссылка на ознакомительный фрагмент\n");
        bw = BufferedWriterUtils.getWriter(header);

        //Получить дополнительную информацию по элементам
        for (int counter = 0; counter < books.size(); counter++) {
            title = "-";
            author = "-";
            price = "-";
            linkDownloadTrialFragment = "-";

            driver.get(urlBooks.get(counter));

            try {
                title = driver.findElement(By.xpath(TITLE_BOOK)).getText();
            } catch (Exception e) {
            }

            try {
                author = driver.findElement(By.xpath(AUTHOR_BOOK)).getText();
            } catch (Exception e) {
            }

            try {
                price = driver.findElement(By.xpath(PRICE_EBOOK)).getAttribute("data-price");
            } catch (Exception e) {
            }

            try {
                linkDownloadTrialFragment = driver.findElement(By.xpath(LINK_DOWNLOAD_TRIAL_FRAGMENT)).getAttribute("href");
            } catch (Exception e) {
            }

            //Записать данные в файл CSV
            BufferedWriterUtils.writeDataFile(urlBooks.get(counter), title, author, price, linkDownloadTrialFragment);

            logger.info("Checked book " + (counter + 1) + " of " + books.size());
        }

//        //Закрыть поток по созданию файла
        BufferedWriterUtils.closeBw();
    }
}

