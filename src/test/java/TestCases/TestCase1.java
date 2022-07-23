package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.Open;

import BaseTest.BaseClass;
import BaseTest.ExtentManager;
import BaseTest.ReusableUtil;
import FrameworkAnnotations.FrameAnnotations;
import ObjectRepo.ObjectRepo;

public class TestCase1 extends ReusableUtil {

	@Test(priority = 1,dataProvider="getData",dataProviderClass=FrameAnnotations.class)
//			
	public void CreateContact(HashMap<String,String> testData) throws InterruptedException, IOException {
//System.out.println(DataForTestCase);
		testData.get("Firstname"); 
		test.log(LogStatus.INFO, "Started test case execution");
		CheckUserIsLoggedIn();
		OpenSideMenu();
		ClickWebElement(ObjectRepo.ContactLink);
		ClickWebElement(ExpliciteWait(driver, driver.findElement(By.linkText("Create")), 20));

		//ClickWebElement(ObjectRepo.CreateContact);
		//driver.findElement(By.linkText("Create")).click();
		// driver.navigate().refresh();
		driver.switchTo().defaultContent();
	/*	ObjectRepo.FirstName.sendKeys(testData.get("Firstname"));
		ObjectRepo.Middlename.sendKeys(testData.get("MiddleName"));
		ObjectRepo.LastName.sendKeys(testData.get("LastName"));*/
		ClickWebElement(ObjectRepo.SaveButton);
		ClickWebElement(ExpliciteWait(driver, ObjectRepo.ThrashIcon, 10));
		Thread.sleep(2000);
		ClickWebElement(ExpliciteWait(driver, ObjectRepo.RemoveButton, 10));
		
		
	}

}
