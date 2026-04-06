package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadFromFile {
    private static String testData = System.getProperty("user.dir")+"/src/test/java/TestData/TestData_040526.xlsx";

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

    static XSSFSheet sheet = workbook.getSheet("LoginCredentials");
    public static String email = sheet.getRow(1).getCell(0).getStringCellValue();
    //public static String password = dataFormatter.formatCellValue(sheet.getRow(1).getCell(1));
    public static String password = sheet.getRow(1).getCell(1).getStringCellValue();
}
