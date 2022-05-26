package odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev17_JsExecuter extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));


        js.executeScript("arguments[0].scrollIntoView(true);", signInButonu);
        js.executeScript("arguments[0].click();", signInButonu);

Thread.sleep(3000);
    }
}
