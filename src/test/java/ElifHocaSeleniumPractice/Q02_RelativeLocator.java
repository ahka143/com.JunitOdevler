package ElifHocaSeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import java.time.Duration;

public class Q02_RelativeLocator extends TestBase {
    /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
 */

    @Test
    public void test01() {
        driver.get("https://www.bestbuy.com");
        String expectedTitle = "Best";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        WebElement bestBuylogoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestBuylogoElementi.isDisplayed());
        WebElement abdBayrakElementi=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoBayrakElemnti=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(abdBayrakElementi));
        Assert.assertTrue(mexicoBayrakElemnti.isDisplayed());
    }
}
