package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CareerPage;
import pages.MainPage;

import static configuration.Url.*;

public class MainSteps {
    final public static Logger logger = Logger.getLogger(CareerPage.class);

    WebDriver driver;
    WebDriverWait wait;

    //Открытие ресурса
    public MainSteps openResourse() {
        driver.get(URL_SYSTEM);
        return this;
    }

}
