package Day_25;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	 @DataProvider(name = "getdata")   // 👈 DataProvider name is getdata
	    public String[][] getdata() throws IOException {

	        // Path to your Excel file
	        File s = new File("E:\\testng.xlsx");
	        System.out.println("File exists: " + s.exists());

	        FileInputStream fis = new FileInputStream(s);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheetAt(0); // First sheet

	        int noOfRows = sheet.getPhysicalNumberOfRows();
	        int noOfCols = sheet.getRow(0).getLastCellNum();

	        String[][] data = new String[noOfRows - 1][noOfCols]; // excluding header

	        DataFormatter df = new DataFormatter();
	        for (int i = 0; i < noOfRows - 1; i++) {
	            for (int j = 0; j < noOfCols; j++) {
	                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
	            }
	        }

	        workbook.close();
	        fis.close();

	        return data;
	    }
}
