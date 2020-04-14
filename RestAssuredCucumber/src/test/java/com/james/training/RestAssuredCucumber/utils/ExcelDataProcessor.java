package com.james.training.RestAssuredCucumber.utils;

import java.io.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProcessor {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C://Users//i350380//eclipse-workspace//RestAssuredCucumber//src//main//java//com//james//training//RestAssuredCucumber//testdata//data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetAt(i).equals("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				//identify Testcases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				//row is collection of cells
				Iterator<Cell> cell = firstRow.cellIterator();
				int k=0;
				int column =0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Data1")) {
						//desired column
						column = k;
						
					}
					k++;
				}
				System.out.println(column);
			}
		}
		
		workbook.close();
	}
	
}
