package Reading;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel_Reading {
    public  String Username;
    public  String Password;

    public void readCells() throws IOException {
        String excelPath = ".\\Details_login.xlsx";
        FileInputStream inputStream = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();


        for (int i = 1; i <= rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                if (j == 0) {
                    Username = cell.getStringCellValue();
                    System.out.println(Username);
                }
                if (j == 1) {
                    Password = cell.getStringCellValue();
                    System.out.println(Password);
                }

            }

        }
    }
    public String getName(){
        return Username;

    }
    public String getPass(){
        return Password;
    }


}