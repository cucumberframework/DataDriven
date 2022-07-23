package FrameworkAnnotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.testng.ITestContext;

public class DataUtil {
	private static int TestCaseStartnumber; 
	private static int KeyStartRowNumber; 
	private static int ValueStartRowNumber; 
	private static int rows =0; 
	private static Map<String, String> table=null;
	private static Object[][] data; 
	private static String keys; 
	private static String values; 
	public static int  cellnumber;
	public static Object[][] getTestData(Xls_reader xls, String sheetName, String testName) throws IOException {
		//FrameAnnotations.baseTestCaseIndex++;
		//String name = ctx.getCurrentXmlTest().getSuite().getName();
		 TestCaseStartnumber= xls.getRowData(testName); 
		 KeyStartRowNumber=TestCaseStartnumber+1; 
		 ValueStartRowNumber=TestCaseStartnumber+2;
		 int totalKeysColumn= xls.columnLastCellNumber(KeyStartRowNumber);
		
			data=new Object[1][0];
			table=new HashMap<String,String>();
			for( cellnumber=0;cellnumber<totalKeysColumn;cellnumber++) {
				 keys=xls.getCellData(sheetName,KeyStartRowNumber,cellnumber);
				 values=xls.getCellData(sheetName, ValueStartRowNumber, cellnumber);
				 table.put(keys, values);
			}
			
	
		
		
 		return  new Object[][]{
 	          {table}
 	      };  
		
	}

	
}
