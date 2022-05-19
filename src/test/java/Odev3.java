import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev3 {

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
        //driver.close();
    }


    @Test
    public void odev2Test1() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
WebElement testElementi=driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]"));
Assert.assertTrue(testElementi.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserYaziElementi=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserYaziElementi.isDisplayed());

        //6. Enter name and email address
driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ahmet");
driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("ahka3@gmail.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
WebElement enterElementi=driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
Assert.assertTrue(enterElementi.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");

        WebElement dayDDM=driver.findElement(By.xpath("//select[@id='days']"));

        Select select1=new Select(dayDDM);
        select1.selectByVisibleText("10");
        WebElement monthsDDM=driver.findElement(By.xpath("//select[@id='months']"));
        Select select2=new Select(monthsDDM);
        select2.selectByVisibleText("October");
        WebElement yearsDDM=driver.findElement(By.xpath("//select[@id='years']"));
        Select select3=new Select(yearsDDM);
        select3.selectByVisibleText("1978");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Ahmet");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Kaya");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ERCOME");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("ELAZIG");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("MERKEZ");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("MERKEZ");
        WebElement countryDDM=driver.findElement(By.xpath("//select[@id='country']"));

        Select select4=new Select(countryDDM);
        select4.selectByVisibleText("New Zealand");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("NEWYORK");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("MANHATTEN");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("23270");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1232342134");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
       WebElement accontElementi= driver.findElement(By.xpath("//*[text()='Account Created!']"));
       Assert.assertTrue(accontElementi.isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement loggedElementi=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(loggedElementi.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();


    }
}
