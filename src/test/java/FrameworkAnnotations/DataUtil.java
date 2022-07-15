package FrameworkAnnotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.ITestContext;

public class DataUtil {
	private static int TestCaseStartnumber; 
	private static int KeyStartRowNumber; 
	private static int ValueStartRowNumber; 
	private static int rows =0; 
	private static Hashtable<String,String> table=null;

	public static Hashtable<String,String> getTestData(Xls_reader xls, String sheetName, String testName) throws IOException {
		FrameAnnotations.baseTestCaseIndex++;
		//String name = ctx.getCurrentXmlTest().getSuite().getName();
		 TestCaseStartnumber= xls.getRowData(testName); 
		 KeyStartRowNumber=TestCaseStartnumber+1; 
		 ValueStartRowNumber=TestCaseStartnumber+2;
		 int totalKeysColumn= xls.columnLastCellNumber(KeyStartRowNumber);
		
			//Object[][] data=new Object[2][1];
			table=new Hashtable<String,String>();
			for(int cellnumber=0;cellnumber<totalKeysColumn;cellnumber++) {
				String keys=xls.getCellData(sheetName,KeyStartRowNumber,cellnumber);
				String values=xls.getCellData(sheetName, ValueStartRowNumber, cellnumber);
				table.put(keys, values);
			}
			
	
		
		//System.out.println(data[0][0]);
 		return  table ;
		
	}

	
}
