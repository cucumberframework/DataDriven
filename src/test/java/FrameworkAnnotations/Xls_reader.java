package FrameworkAnnotations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_reader extends FrameAnnotations {

	
	public FileInputStream fis=null; 
	private XSSFWorkbook workbook=null; 
	private XSSFSheet sheet=null; 
	private XSSFRow row=null; 
	private XSSFCell cell=null; 
	public static int getRowNumber; 
	
	
	public XSSFWorkbook getWorkbook() throws IOException {
		if(workbook==null) {
			fis=new FileInputStream(System.getProperty("user.dir"+"\\src\\test\\java\\ExternalFiles\\TestData.xlsx"));
			workbook=new XSSFWorkbook(fis);
			//workbook.getActiveSheetIndex();
		}
		return workbook;
		
	}
	public XSSFSheet getSheet(String sheetName) throws IOException { 
		if(workbook==null) {
			workbook=getWorkbook();
			sheet=workbook.getSheet(sheetName);
		}
		
		return sheet;
	}
	
	
	public int getRowData(String TestCaseName) throws IOException { 
		
		if(sheet==null) {
			sheet=getSheet(prop.getProperty("sheetName"));
			for(int i=0;i<sheet.getLastRowNum();i++) {
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
					getRowNumber=i; 
					break; 
				}
			}
		}
		return getRowNumber;
		
	}
	
	public  int columnLastCellNumber(int KeyStartRowNumber) {
		int columnlastcellNumber= sheet.getRow(KeyStartRowNumber).getLastCellNum(); 
		return columnlastcellNumber; 
		
		
	}
	
	public String getCellData(String sheetname,int rownumber,int cellnumber) {
		String cellData= sheet.getRow(rownumber).getCell(cellnumber).getStringCellValue().trim();
		return cellData;
		
	}
	
	}
