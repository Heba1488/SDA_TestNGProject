package assignment.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;


public class T01_SearchTeat   {
    /*
Navigate to: https://www.amazon.com/
Search for different keywords: Java, Selenium
Assert that result text contains the searched word
Run tests from XML file using parameters
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Parameters("Searchkeyword")
    void searchTest(String searchKeyword){
       // Navigate to: https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        WebElement contiueButton = driver.findElement(By.xpath("//[@type='submit']"));
        contiueButton.click();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchBox.sendKeys(searchKeyword);
        searchButton.click();

        WebElement resultSearch = driver.findElement(By.xpath("//span[contains(@class,'a-color-state')]"));

        Assert.assertTrue(resultSearch.getText().toLowerCase().contains(searchKeyword.toLowerCase()),
                "Search Result  does not contain searched keyword");




        }
    @AfterMethod
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    }

