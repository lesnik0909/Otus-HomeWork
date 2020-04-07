package tests;

import pages.LkPersonalPage;
import pages.LoginPage;
import presets.BaseTest;
import org.testng.annotations.*;
import presets.DriverManager;
import static configuration.ConfigProperties.*;


public class Otus extends BaseTest {

    LoginPage loginPage;
    LkPersonalPage lkPersonalPage;

    @Test
    public void OtusAccount() throws InterruptedException {
        lkPersonalPage = new LkPersonalPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        lkPersonalPage.open();
        loginPage.toAuth();
        lkPersonalPage
                .profile()
                .editAllName()
                .setEmail()
                .setPhone()
                .addContact(0, MESSENGER_ONE, MESSENGER_ONE_LINK)
                .addNewContact()
                .addContact(1, MESSENGER_TWO, MESSENGER_TWO_LINK)
                .submitPersonalForm();
        DriverManager.deleteCookie();
        lkPersonalPage.open();
        loginPage.toAuth();
        lkPersonalPage
                .profile()
                .assertPesronalData()
                .assertContact(0, MESSENGER_ONE_LINK)
                .assertContact(1, MESSENGER_TWO_LINK);
    }
}
