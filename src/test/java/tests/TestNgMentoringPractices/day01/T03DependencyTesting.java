package tests.TestNgMentoringPractices.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T03DependencyTesting {
    /*
    Objective: Create interdependent test methods using dependsOnMethods
Requirements:
//Create a class called DependencyTest
//Create a @BeforeClass method to set up WebDriver
Create the following dependent test chain:
openYahoo() - Navigate to Yahoo
openBing() - Navigate to Bing (depends on Yahoo test)
openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)  https://duckduckgo.com/
Add intentional failure in Yahoo test and observe behavior
Create @AfterClass method to close driver
     */
    WebDriver driver;
  @BeforeClass
   void setUp(){
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    System.out.println("@BeforeClass");
  }

  @Test()
    void yahooTest()
    {
     driver.get("https://mail.yahoo.com/");
    }

    @Test(dependsOnMethods = "yahooTest")
    void  bingTest()
    {
        driver.get("https://www.bing.com/");
    }

    @Test(dependsOnMethods = "bingTest")
    void duckDuckGoTest()
    {
        driver.get("https://duckduckgo.com/");
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }

}
