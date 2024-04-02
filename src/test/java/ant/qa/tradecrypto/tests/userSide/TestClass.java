package ant.qa.tradecrypto.tests.userSide;

import Ant.qa.tradecrypto.utils.ExcelUtil;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) throws FileNotFoundException {
        Object data [][] = ExcelUtil.getSheetData("register");
        System.out.println(data[2][2]);
    }
}
