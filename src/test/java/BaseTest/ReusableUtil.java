package BaseTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import FrameworkAnnotations.FrameAnnotations;
import ObjectRepo.ObjectRepo;

public class ReusableUtil extends FrameAnnotations {
	public static WebElement elem=null; 

	public static void LoginIntoApplication() throws InterruptedException {
		Thread.sleep(5000);
		ObjectRepo.emailAddress.sendKeys(prop.getProperty("username"));
		ObjectRepo.password.sendKeys(prop.getProperty("password"));
		ObjectRepo.LoginButton.click();
		Thread.sleep(5000);
		
	}
	
	
	public static void CheckUserIsLoggedIn() {
		if(ObjectRepo.freeAccount.isDisplayed()) {
			System.out.println("User is logged in into the application successfully");
			
		}
	}
	
	public static void OpenSideMenu() {		
		if(ObjectRepo.Homebutton.isDisplayed()) {
			ObjectRepo.Homebutton.click();
		}
	}
	
	/*public static WebElement FindElementsFromList(String attributeKey,String attributeValue) {
		List<WebElement> allElem=driver.findElements(By.tagName("input")); 
		for(WebElement elem1:allElem) {
			if(elem1.getAttribute(attributeKey).equalsIgnoreCase(attributeValue)) {
				elem=elem1;
				break;
			}
		}
		
		return elem; 
	}*/
}
