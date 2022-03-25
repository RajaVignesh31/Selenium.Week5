package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelGeneric 
{
	public static String[][] getData(String excelPath) throws IOException 
	{
		// To open excel file
		XSSFWorkbook book = new XSSFWorkbook(excelPath);
		
		// To open a sheet from excel file
		XSSFSheet sheet = book.getSheetAt(0);
		
		// To find the active rows in sheet
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		
		// To find the active columns in sheet
		short columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);
		
		// Create 2D Array for Rows and Colums
		String data[][] = new String [rowCount][columnCount];
		
		// Iterate the rows using loop
		for(int i=1;i<=rowCount;i++) 
		{
			XSSFRow eachRow = sheet.getRow(i);
			System.out.println("Row Number:" +i);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell eachCell = eachRow.getCell(j);
				String value = eachCell.getStringCellValue();
				data[i-1][j]= value;
				System.out.print(value + " ");
			}
			
			System.out.println();
		}
		
		book.close();	
			
		// Return Array
		return data;
	}
}
