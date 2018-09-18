package SeleniumTests;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling{
	
	File file ; 
	FileInputStream fis;
	Workbook workbook ;
	Sheet worksheet;
	
	FileHandling(String filePath) throws IOException{
		file = new File(filePath);
		fis =  new FileInputStream(file);
		this.workbook = new XSSFWorkbook(fis);						
	}
	
	void getSheet(String SheetName){
		this.worksheet = workbook.getSheet(SheetName);	
	}
	
	int getRowCount(){
		return worksheet.getLastRowNum();
	}
	
	String getValue(int rowNum,int colNum){
		return worksheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	String getValue(int rowNum){
		Row row = worksheet.getRow(rowNum);
		String values="";
		for(int i=0;i<row.getLastCellNum();i++){
			values=row.getCell(i).getStringCellValue()+"||";			
		}
		
		int lastIndex = values.lastIndexOf("||");
		if(lastIndex>0){
			values =  new StringBuilder(values).replace(lastIndex, lastIndex+2, "").toString();
		}
		return values;	
	
	}
	
	public static void main (String args[]) throws IOException{
		FileHandling files = new FileHandling("D:/Files/Data.xlsx");
		files.getSheet("testdata");
		System.out.print("row number");
		System.out.println(files.getRowCount());
		System.out.println(files.getValue(1,2));
		
		System.out.println(files.getValue(1));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}