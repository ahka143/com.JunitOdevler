package ElifHocaSeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Q03_CssLocator_MethodCreation extends TestBase {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    1.method : createButtons(100)
    2.deleteButtonsAndValidate()
 */

    @Test
    public void createButtons() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        }
       int silinenDeleteButtonsayisi= deleteButtonsAndValidate(99);

        List<WebElement> deleteButtonsList=driver.findElements(By.xpath("(//*[text()='Delete'])"));
        int expectedSonuc=100-deleteButtonsList.size();
        Assert.assertEquals(expectedSonuc,silinenDeleteButtonsayisi);
    }

    public int deleteButtonsAndValidate(int tiklamaSayisi) {
        int silinenDeleteButonSayisi = 0;
        for (int i = 1; i <=tiklamaSayisi ; i++) {
            driver.findElement(By.xpath("(//*[text()='Delete'])[1]")).click();
            silinenDeleteButonSayisi++;
        }
return  silinenDeleteButonSayisi;
    }
}
