package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseTest.ReusableUtil;
import FrameworkAnnotations.FrameAnnotations;
import ObjectRepo.ObjectRepo;

public class CheckAddNewEmailbutton extends ReusableUtil {
	
	@Test(priority = 1)
	public void checkAddNewEmailbutton() throws InterruptedException {
		System.out.println("CheckAddNewEmailbutton test case execution");
		//Hashtable<String,String> testData=FrameAnnotations.testdata;
		StartTestcase(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Started test case execution");
		CheckUserIsLoggedIn();
		OpenSideMenu();
		ObjectRepo.ContactLink.click();
		driver.findElement(By.linkText("Create")).click();
		// driver.navigate().refresh();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[@class='add icon']")).isDisplayed();
System.out.println("CheckAddNewEmailbutton execution ended");
	}
	
}
