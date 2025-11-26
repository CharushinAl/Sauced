package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // объявление драйвера
    WebDriver driver;

    // объявление локаторов
    By userField = By.xpath("//input[@name='user-name']");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(final String userName, final String passwordName) {
        driver.findElement(userField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(passwordName);
        driver.findElement(loginBtn).click();
    }

    public String errorMessageText() {
        return driver.findElement(error).getText();
    }
}
