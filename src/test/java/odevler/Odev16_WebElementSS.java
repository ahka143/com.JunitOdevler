package odevler;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Odev16_WebElementSS extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
     WebElement sonucYazisiElementi=
             driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File temp=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);
        File sonucEkranGoruntusu=new File("target/ekranGoruntuleri/sonuc.jpeg");
        FileUtils.copyFile(temp,sonucEkranGoruntusu);

    }
}
