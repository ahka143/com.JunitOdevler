package odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Odev10 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
String birinciSayfaWindowshandle= driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        Set<String> windowhandlesSet=driver.getWindowHandles();
        String ikinciSayfaWindowsHandle="";
        for (String each:windowhandlesSet
             ) {
            if (!windowhandlesSet.equals(each)){
                ikinciSayfaWindowsHandle=each;
            }
        }

        driver.switchTo().window(ikinciSayfaWindowsHandle);
        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Ahka143");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("241143");

        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedAlertYazisi="validation failed";
        String actualAleryazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAleryazisi);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(birinciSayfaWindowshandle);
        //10.Ilk sayfaya donuldugunu test edin
String expectedUrl="http://webdriveruniversity.com/";
String actualurl= driver.getCurrentUrl();
Assert.assertEquals(expectedUrl,actualurl);
        Thread.sleep(4000);
    }
}
