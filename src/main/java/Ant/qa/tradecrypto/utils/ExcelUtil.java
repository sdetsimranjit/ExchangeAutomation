package Ant.qa.tradecrypto.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    private   static final  String TEST_WORKBOOK_PATH = ".\\src\\main\\resources\\testdata\\testdata.xlsx";
    private static Workbook book;
    private static Sheet sheet;


    public  static Object[][] getSheetData (String sheetName) throws FileNotFoundException {
        System.out.println("Reading the data from sheet: " + sheetName);
        Object data[][] = null;
        try {
                FileInputStream fis = new FileInputStream(TEST_WORKBOOK_PATH);
                book =  WorkbookFactory.create(fis);
                sheet = book.getSheet(sheetName);

                data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

                for (int i=0; i<sheet.getLastRowNum();i++) {
                    for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
                        data[i][j] = sheet.getRow(i+1).getCell(j).toString();
                    }
                }
                } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;

    }




}
