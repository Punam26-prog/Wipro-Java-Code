package stepdefinition;

public class ExcelUtils {
	
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	

	    // Read cell data
	    public String getCellData(String excelPath, String sheetName, int rowNum, int colNum) throws IOException {
	        FileInputStream fis = new FileInputStream(excelPath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        String value = cell.toString();
	        workbook.close();
	        fis.close();
	        return value;
	    }

	    // Overwrite data in a fixed row (always Row 1 for example)
	    public void overwriteData(String excelPath, String sheetName, String email, String password) throws IOException {
	        FileInputStream fis = new FileInputStream(excelPath);
	        Workbook workbook = new XSSFWorkbook(fis);
	        fis.close();

	        Sheet sheet = workbook.getSheet(sheetName);

	        // Always write in row 1 (row index 1 = 2nd row, since row 0 is usually header)
	        Row row = sheet.getRow(1);
	        if (row == null) {
	            row = sheet.createRow(1);
	        }

	        // Overwrite email & password
	        Cell emailCell = row.getCell(0);
	        if (emailCell == null) emailCell = row.createCell(0);
	        emailCell.setCellValue(email);

	        Cell passwordCell = row.getCell(1);
	        if (passwordCell == null) passwordCell = row.createCell(1);
	        passwordCell.setCellValue(password);

	        FileOutputStream fos = new FileOutputStream(excelPath);
	        workbook.write(fos);
	        workbook.close();
	        fos.close();
	    
	}

}
