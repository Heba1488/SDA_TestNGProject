package assignment.day01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class T02_NegativeLoginTest extends TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


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

        SoftAssert softAssert = new SoftAssert();
        try {
            Alert alert = driver.switchTo().alert();

            softAssert.assertNotNull(alert, "Alert should be displayed for invalid credentials " );

            String alertText = alert.getText();
            softAssert.assertEquals(alertText, "Incorrect username or password",
                    " Incorrect username or password" );

            alert.accept();
        } catch (Exception e) {

        }
        softAssert.assertAll();

        }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();

    }
}
