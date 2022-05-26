package odevler;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class Odev14 {
    @Test
    public void writeExcelTest() throws IOException {

        FileInputStream fis=new FileInputStream("src/main/resources/deneme.xlsx");

        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sheet1")
                .createRow(0)
                .createCell(0)
                .setCellValue("Adi:");
       workbook.getSheet("Sheet1").getRow(0).createCell(1).setCellValue("SoyAdi : ");
       workbook.getSheet("Sheet1").createRow(1).createCell(0).setCellValue("Ahmet : ");
       workbook.getSheet("Sheet1").getRow(1).createCell(1).setCellValue("Kaya : ");

        FileOutputStream fos=new FileOutputStream("src/main/resources/deneme.xlsx");
        workbook.write(fos);
        fis.close();
        fos.close();


    }
}
