package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {



    @Test
    public void checkCorrectLogin() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productPage.isPageLoaded(), "Error message does not appear");
    }

    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
