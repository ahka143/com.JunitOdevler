import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev9 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1.“http://webdriveruniversity. IFrame /index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2.“Our Products” butonuna basin
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement);

        driver.findElement(By.linkText("Our Products")).click();
        //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();
        //4.Popup mesajini yazdirin
        System.out.println(driver.findElement(By.className("modal-body")).getText());
        //5.“close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        //6."WebdriverUniversity.com IFrame )" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();
        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
String expectedUrl="http://webdriveruniversity.com/index.html";
String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(3000);
    }
}
