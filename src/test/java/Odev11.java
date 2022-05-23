import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev11 extends TestBase {

      /*
    // ...Exercise6...
    1.  https://id.heroku.com/login sayfasina gidin
    2.  Bir mail adersi giriniz
    3.  Bir password giriniz
    4.  Login butonuna tiklayiniz
    5.  "There was a problem with your login." texti gorunur ise
    6.  "kayit yapilamadi" yazdiriniz
    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    9.  Tum sayfalari kapatiniz
*/

    @Test
    public void test01() throws InterruptedException {
        //  1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //    2.  Bir mail adersi giriniz
        //    3.  Bir password giriniz
        //    4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("asdf@sdf.com", Keys.TAB,"123456",Keys.ENTER);

        //    5.  "There was a problem with your login." texti gorunur ise
        WebElement thereWasAProblemYazisiElemti= driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if (thereWasAProblemYazisiElemti.isDisplayed()){
            System.out.println("kayit yapilamadi");
        }else{
            System.out.println("Kayit yapildi");
        }

        Thread.sleep(4000);
        //    6.  "kayit yapilamadi" yazdiriniz
        //    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //    9.  Tum sayfalari kapatiniz


    }
}
