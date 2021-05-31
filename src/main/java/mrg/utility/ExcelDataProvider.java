package mrg.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;


public class ExcelDataProvider {
	private File file;
	private FileInputStream fis;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;

	public ExcelDataProvider(){
		file = new File("D:\\Selenium_Tutorial_IntelliJ\\Hybrid_Framework\\TestData\\TestData.xlsx");
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String readStringData(String sheetName, int rowNum, int cellNum){
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	public String readStringData(int sheetIndex, int rowNum, int cellNum){
		sheet = workbook.getSheetAt(sheetIndex);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	public double readNumericData(String sheetName, int rowNum, int cellNum){
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getNumericCellValue();
	}
	public String readNumericData(int sheetIndex, int rowNum, int cellNum){
		sheet = workbook.getSheetAt(sheetIndex);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	@Test
	public void showData(){
		System.out.println(readStringData(0, 0, 0));
	}

}
