package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadFromFile {
        private static String testData = System.getProperty("user.dir")+"/src/test/java/TestData/TestData_080426.xlsx";

    public static DataFormatter dataFormatter = new DataFormatter();

    static FileInputStream fs;

    //fs = new FileInputStream(testData);

    static {
        try {
            fs = new FileInputStream(testData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //static XSSFSheet sheet = workbook.getSheet("LoginCredentials");
    static XSSFSheet sheet = workbook.getSheet("LoginCredentials");

    // Login
    public static String email = dataFormatter.formatCellValue(sheet.getRow(1).getCell(0));
    public static String password = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));

    // Inventory
    public static String deviceType = dataFormatter.formatCellValue(sheet.getRow(1).getCell(2));
    public static String brand = dataFormatter.formatCellValue(sheet.getRow(1).getCell(3));
    public static String storage = dataFormatter.formatCellValue(sheet.getRow(1).getCell(4));
    public static String color = dataFormatter.formatCellValue(sheet.getRow(1).getCell(5));
    public static String quantity = dataFormatter.formatCellValue(sheet.getRow(1).getCell(6));
    public static String address = dataFormatter.formatCellValue(sheet.getRow(1).getCell(7));
    public static String shipping = dataFormatter.formatCellValue(sheet.getRow(1).getCell(8));
    public static String warranty = dataFormatter.formatCellValue(sheet.getRow(1).getCell(9));
    public static String discount = dataFormatter.formatCellValue(sheet.getRow(1).getCell(10));
}
