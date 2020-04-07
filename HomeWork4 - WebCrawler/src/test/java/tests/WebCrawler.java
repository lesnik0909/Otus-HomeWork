package tests;

import presets.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.*;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import static elements.Elements.*;


public class WebCrawler extends BaseTest {

    final private Logger logger = Logger.getLogger(WebCrawler.class);

    @Test
    public void testWebCrawler() throws InterruptedException, IOException {

        driver.get(SYSTEM_URL);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        WebElement element = driver.findElement(By.xpath(BUTTON_LOADER));

        //Прогрузить все элементы на странице, получить список
        while (true) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -5)");

            List<WebElement> books = driver.findElements(By.cssSelector(BOOK));
            logger.info("Count books - " + books.size());

            try {
                wait = new WebDriverWait(driver, 3);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_LOADER)));
            } catch (TimeoutException ex) {
                logger.info("All books loaded");
                break;
            }
        }

        //Определить общее количество элементов
        List<WebElement> books = driver.findElements(By.cssSelector(BOOK));
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

        //Инициализировать поток по созданию файла
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Books.csv"), "cp1251"));
        //Добавить заголовки в CSV
        bw.write("Ссылка на книгу; Название; Автор; Цена; Ссылка на ознакомительный фрагмент\n");

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
            bw.write(urlBooks.get(counter) + ";" + title + ";" + author + ";" + price + ";" + linkDownloadTrialFragment + ";\n");

            logger.info("Checked book " + (counter + 1) + " of " + books.size());
        }

        //Закрыть поток по созданию файла
        bw.close();
    }
}

