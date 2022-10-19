package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public static Workbook book;
	public static Sheet sheet;
	 
	public static Object[][] readData(String sheetname){
		
	FileInputStream file=null;
	try {
		file = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\src\\test\\java\\testData\\Book3.xlsx");
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	}
	catch(IOException a) {
		a.printStackTrace();
	}
	sheet = book.getSheet(sheetname);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0; i<sheet.getLastRowNum(); i++) {
		for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
			data[i][j]= (sheet.getRow(i+1).getCell(j)).toString();
		}
	}
	
	return data;
}
}
