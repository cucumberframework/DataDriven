package BaseTest;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static Date d=new Date(); 
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			
			String newD=d.toString().replace(":", "_").replace(" ", "_")+".html"; 
			System.out.println("F:\\eclipse\\wrkspace\\DataDriven\\FinalReports\\"+newD);
			extent=new ExtentReports("F:\\eclipse\\wrkspace\\DataDriven\\FinalReports\\"+newD,true,DisplayOrder.NEWEST_FIRST); 
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		}
		
		return extent;
		
	}
	
	

}
