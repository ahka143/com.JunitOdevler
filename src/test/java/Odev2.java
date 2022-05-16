import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2 {
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
        //8-Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void odev2Test1() {


        //2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3-cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

     Assert.assertTrue("Title Google icermiyor",actualTitle.contains(expectedTitle));



    }
    @Test
    public void odev2Test2() {


        //2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //5-Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella" + Keys.ENTER);
        //6-Bulunan sonuc sayisini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ")[1]);


        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int bulunanSonucSayisi = Integer.parseInt(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ")[1].replaceAll("\\D",""));
        Assert.assertTrue("Sonuc 10000000 az",bulunanSonucSayisi > 10000000);

    }
}

