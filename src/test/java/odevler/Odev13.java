package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Odev13 extends TestBase {
    @Test
    public void test01() {
        //Test01:
        //1 amazon gidin
        driver.get("https://www.amazon.com");
        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(ddm);
        List<WebElement>ddmList=select.getOptions();
        for (WebElement each:ddmList
             ) {
            System.out.println(each.getText());
        }
        //3 drop down menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals(28,ddmList.size());

    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        //Test02
        //1 dropdown menuden elektronik bölümü seç in
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");

        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
        String sonucYazisi=  driver.
                findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText();
        System.out.println(sonucYazisi.split("of")[1].replaceAll("\\D",""));

        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.contains("iphone"));
        //4 ikinci ürüne relative locater kullanarak tıklay in
        WebElement ilkSonucElementi=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
      WebElement ikinciUrunElementi=  driver.findElement(RelativeLocator.with(By.tagName("img")).below(ilkSonucElementi));
      ikinciUrunElementi.click();
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
String ikinciUrunTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(ikinciUrunTitle);
        driver.findElement(By.xpath("//a[@title='Add to List']")).click();

    }


}
