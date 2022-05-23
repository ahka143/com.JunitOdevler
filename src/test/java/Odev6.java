import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev6 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // ...Exercise5...
        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Under the  ORIGINAL CONTENTS
        // click on Alerts
        driver.findElement(By.xpath("//a[@id='alerttest']")).click();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // navigate back
        driver.navigate().back();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // Click on Basic Ajax
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // enter value-> 20 and Enter
        driver.findElement(By.id("lteq30")).sendKeys("20",Keys.ENTER);
        // and then verify Submitted Values is displayed open page
        WebElement submittedValuesElementi= driver.findElement(By.xpath("//*[text()='Submitted Values']"));

        Assert.assertTrue(submittedValuesElementi.isDisplayed());
        // close driver
        Thread.sleep(4000);

    }
}
