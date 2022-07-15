package TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testcasePractice_cbd {

	public static void main(String[] args) throws InterruptedException {

		String username="admin";	
	String password="admin"; 
		String url="https://www.naukri.com";
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(url);
		Set<String> allwin= driver.getWindowHandles(); 
		Iterator<String> it= allwin.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	WebElement elem=driver.findElement(By.xpath("//*[@name='Rahul']")); 
	
		while(!elem.isDisplayed()) {
			Thread.sleep(5000);
		}
		
	
	
}
}