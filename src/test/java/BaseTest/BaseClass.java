package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import FrameworkAnnotations.FrameAnnotations;
import ObjectRepo.ObjectRepo;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static String destinationFileName;
	public static String excelFile=System.getProperty("user.dir")+"\\src\\test\\java\\ExternalFiles\\TestData.xlsx"; 

	public static Properties init() {

		if (prop == null) {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\ExternalFiles\\properties.properties");
				prop.load(fis);
			} catch (Exception e) {
				System.out.println("Caughtexception");
			}
		}
		return prop;
	}

	public static WebDriver OpenBrowser() {

		prop = init();
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		PageFactory.initElements(driver, ObjectRepo.class);
		return driver;
	}

	public static void GetUrl() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	public static WebElement ExpliciteWait(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement expliciteWaitElement = wait.until(ExpectedConditions.visibilityOf(element));
		return expliciteWaitElement;
	}

	public void ClickWebElement(WebElement element) {
		element.click();
		FrameAnnotations.test.log(LogStatus.INFO, element.toString()+"--> is clicked");
		element = null;
	}

	public static void takeScreenshot() throws IOException {

		Date Ds = new Date();
		String screenshot = Ds.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot Ts = (TakesScreenshot) driver;
		File source = Ts.getScreenshotAs(OutputType.FILE);
		destinationFileName = System.getProperty("user.dir") + "//Screenshots//" + screenshot + ".png";
		File destination = new File(destinationFileName);
		FileUtils.copyFile(source, destination);

	}

}