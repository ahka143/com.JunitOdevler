import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Odev7 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//input[@name='accept']")).click();
        //2. Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13 512"+ Keys.ENTER);
       // driver.findElement(By.xpath("//*[text()=' için arama yap']")).click();
        //                                             a-size-base a-color-base s-underline-text
        //3. Check that the results are listed
       WebElement sonucElemti=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String expectedSonuc="iphone 13 512";
       String actualSonuc=sonucElemti.getText();
       System.out.println("expectedSonuc = " + expectedSonuc);
       System.out.println("actualSonuc = " + actualSonuc);
       Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        //4. Click iPhone13 at the top of the list


     driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]")).click();
        //5. Log the following values for each size
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> valuesList=driver.findElements(By.xpath("//input[@class='a-button-input']"));

        for (int i =0; i <valuesList.size() ; i++) {
            System.out.println(valuesList.get(i).getText());
        }
        //.Size information .Price .Color .Stock status

       // Thread.sleep(5000);
    }
}
