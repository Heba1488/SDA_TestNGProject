package assignment.day03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class T01_NegativeTestingwithDatatProvider extends TestBase {
    @DataProvider
    public Object[][] NegativeTestingwithDatatProvider() {
        return new Object[][] {
                {"",""},//both is Empty
                {"","123"}, //uesernme is empty
                {"admin",""}, //password is empty
                {"Heba","123"},// username incoorect
                {"admin","678"},//password incoorect
                {"Heba","678"} // both incorrect
        };
    }


    @Test(dataProvider = "NegativeTestingwithDatatProvider")
    public void Testing(String username, String password) {
        driver.navigate().to("https://claruswaysda.github.io/signIn.html");
        String url = driver.getCurrentUrl();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        try {

            Alert alert = driver.switchTo().alert();

            alert.accept();
        } catch (Exception e) {

            System.out.println("NO Alert");
        }


        Assert.assertEquals(driver.getCurrentUrl(), url);



    }
}
