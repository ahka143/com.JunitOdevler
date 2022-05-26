package odevler;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Odev15_TamEkranScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.facebook.com");
      TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyHHmmss");
        String tarih=date.format(dtf).toString();

      File ekranGoruntusu=new File("target/ekranGruntuleri/ekranGoruntusu"+tarih+".jpeg");
      File temp=ts.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(temp,ekranGoruntusu);
    }
}
