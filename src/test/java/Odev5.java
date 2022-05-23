import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev5 extends TestBase {



    @Test
    public void test() throws InterruptedException {
        // ...Exercise4...
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculate under Micro Apps




        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(5000);
        driver.findElement(By.id("calculatetest")).click();
        //    Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("5");
        //    Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("6");
        // Click on Calculate
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // Get the result
        WebElement resultElement= driver.findElement(By.xpath("//span[@id='answer']"));
        // Print the result
        System.out.println(resultElement.getText());
       Thread.sleep(3000);

    }
}
