package com.automation.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

	public String dirPath = System.getProperty("user.dir");
	public String filePath = dirPath+"\\TestData\\TestData.xlsx";
	public File file;
	public FileInputStream fis;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;

	public ExcelDataProvider(){
		file = new File("D:\\Selenium_Tutorial_IntelliJ\\Hybrid_Framework\\TestData\\TestData.xlsx");
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			System.out.println("Unable to read Excel File: " + e.getMessage());
		}
	}

	public String getStringData(String sheetName, int rowNum, int cellNum){
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}

	public String getStringData(int sheetNum, int rowNum, int cellNum){
		sheet = workbook.getSheetAt(sheetNum);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}

	public double getNumericData(String sheetName, int rowNum, int cellNum){
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getNumericCellValue();
	}
	public double getNumericData(int sheetNum, int rowNum, int cellNum){
		sheet = workbook.getSheetAt(sheetNum);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		return cell.getNumericCellValue();
	}

}
