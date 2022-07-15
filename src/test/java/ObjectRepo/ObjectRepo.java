package ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ObjectRepo {

	@FindBy(xpath = "//input[@name='email']")
	public static WebElement emailAddress;

	@FindBy(xpath = "//input[@name='password']")
	public static WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	public static WebElement LoginButton;

	@FindBy(linkText = "Free account")
	public static WebElement freeAccount;

	@FindBy(xpath = "//a[@href='/home']")
	public static WebElement Homebutton;

	@FindBy(linkText = "Contacts")
	public static WebElement ContactLink;

	@FindBy(xpath = "//*[@id='main-content']/div/div[2]/form/div[1]/div[1]/div/div/input")
	//*[@id="main-content"]/div/div[2]/form/div[1]/div[1]/div/div/input
	public static WebElement FirstName;

	@FindBy(xpath = "//*[@id='main-content']/div/div[2]/form/div[1]/div[2]/div/div/input")
	public static WebElement Middlename;

	@FindBy(xpath = "//*[@id='main-content']/div/div[2]/form/div[2]/div[1]/div/div/input")
	public static WebElement LastName;
	
	@FindBy(xpath = "//*[contains(text(),'Save')]")
	public static WebElement SaveButton;
	
	@FindBy(xpath="//i[@class='trash icon']")
	public static WebElement ThrashIcon;
	
	@FindBy(xpath="//i[@class='remove icon']")
	public static WebElement RemoveButton; 
	
	@FindBy(linkText="Create")
	public static WebElement CreateContact; 
	
	@FindAll({@FindBy(xpath="//a[@name='rahul']")})
	public static List<WebElement> allelem;

}
