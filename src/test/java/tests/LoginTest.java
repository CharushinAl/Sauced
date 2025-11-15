package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    // open browser
    // input web site//
    @Test
    public void incorrectLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String errorText = driver.findElement(By.cssSelector("*[data-test='error']")).getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.", "Неверное");
        driver.quit();
    }
}