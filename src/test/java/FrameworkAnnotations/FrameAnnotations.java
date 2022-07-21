package FrameworkAnnotations;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BaseTest.BaseClass;
import BaseTest.ExtentManager;
import BaseTest.ReusableUtil;

public class FrameAnnotations extends BaseClass {
	public static ExtentTest test; 
	public static 	ExtentReports rep;
	public static String testcasename;
public static Xls_reader xls; 
public static ITestListener context; 
public static List<String> testCaseNameList=new ArrayList<String>(); 
public static int globalTestCaseIndex;
public static int baseTestCaseIndex=0; 
public static Hashtable<String,String> testdata; 


	@BeforeSuite
	public static void beforeSuite() {
		if(driver!=null) {
			driver.quit();
			System.out.println();
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException  {
	super.driver=OpenBrowser();
		Thread.sleep(5000);
		GetUrl();
		
	
		//test=rep.startTest(getTestCaseName(testcasename)); 
	}
	
	public ExtentTest  StartTestcase(String testcaseName) throws InterruptedException {
		test=rep.startTest(testcaseName);
		ReusableUtil.LoginIntoApplication();
		
		return test;
	}
	
	
	
	@BeforeClass
	public void beforeClass(Method testCaseName) throws IOException {
		rep=ExtentManager.getInstance();
		
		//testdata= getTestMethod(); 
		
	}
	
	@AfterClass
	public static void afterClass() {
		driver.close();
		rep.endTest(test);
		rep.flush();
	}

	@DataProvider(name="getData")
	public static Hashtable<String, String> getTestMethod(Method testCaseName) throws IOException {
		testcasename=testCaseName.getName();
		xls=new Xls_reader();
		init();
		testdata= DataUtil.getTestData(xls, prop.getProperty("sheetName"), testcasename);
		return testdata; 
		
		
	
	}

	/*public static List<String> getTestCaseName() { 
		try   
		{  
		//creating a constructor of file class and parsing an XML file  
		File file = new File("F:\\eclipse\\wrkspace\\DataDriven\\testng.xml");  
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
		NodeList nodeList = doc.getElementsByTagName("class");  
		// nodeList is not iterable, so we are using for loop  
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
			globalTestCaseIndex=nodeList.getLength();
		Node node = nodeList.item(itr);  
		System.out.println("\nNode Name :" + node.getNodeName());  
		if (node.getNodeType() == Node.ELEMENT_NODE)   
		{  
			Element elementAttribute = (Element) nodeList.item(itr);
            String ranking = elementAttribute.getAttribute("name");
            System.out.println(ranking);
            testCaseNameList.add(ranking);
		}  
		}  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}
		return testCaseNameList;  
		} */ 
  
	}

	



