package Day_29;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
	 public static Object[][] getSheetData(String fileName, String sheetName) throws IOException {
	        // Load file from resources (classpath)
	        InputStream fis = ExcelUtils.class.getClassLoader().getResourceAsStream(fileName);
	        if (fis == null) {
	            throw new IOException("File not found in resources: " + fileName);
	        }

	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount];
	        for (int i = 1; i < rowCount; i++) {
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
	            }
	        }

	        workbook.close();
	        fis.close();
	        return data;
	    }
}
