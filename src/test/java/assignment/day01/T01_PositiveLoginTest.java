package assignment.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class T01_PositiveLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void positiveLoginTest() {
        //go to this link
        driver.get("https://claruswaysda.github.io/signIn.html");

        // 2. Enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("admin");

        // 3. Enter password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123");

        // 4. Click Sigin
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBtn.click();

        // 5. Hard Assertions
        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, " URL after login is NOT as expected!");

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Employee Table"), "'Employee Table' text was not found!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

       driver.quit();

    }

}
