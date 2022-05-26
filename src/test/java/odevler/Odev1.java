package odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Odev1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test() {
        //Class Work Amazon Search Test
        //1-https://www.amazon.com/ sayfasina gidelim

        driver.get("https://www.amazon.com/");
        //2-arama kutusunu locate edelim
        //3--“Samsung headphones” ile arama yapalim
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung headphones" + Keys.ENTER);
        //4-Bulunan sonuc sayisini yazdiralim
        WebElement bulunanSonucSayisielementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Bulunan sonuc sayisi: "+bulunanSonucSayisielementi.getText().split("of")[1].replaceAll("\\D",""));

                List<WebElement> filtrelemeBasliklariList = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@class='a-size-base a-color-base s-bold-weight-text']")));

        for (WebElement each : filtrelemeBasliklariList
        ) {
            System.out.println(each.getText());
        }
        //5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();
        //6-Sayfadaki tum basliklari yazdiralim


    }
}
