package assignment.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class T02_NegativeLoginTest extends TestBase {

    @Test
    public void NegativeLoginTest() throws InterruptedException {

        //go to this link
        driver.get("https://claruswaysda.github.io/signIn.html");

        // 2. Enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("wrongUser");

        // 3. Enter password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("wrongPassword");

        // 4. Click Sigin
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBtn.click();
    }
}
