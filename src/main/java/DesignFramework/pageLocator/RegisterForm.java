package DesignFramework.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DesginFramwork.abstractAction.AbstractAction;

public class RegisterForm extends AbstractAction {

	WebDriver driver;
	
	public RegisterForm(WebDriver driver) {
		
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//p[text()='An internal error has occurred and has been logged.']")
	WebElement errorMessage;
	
	@FindBy(xpath= "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(name= "customer.firstName")
	WebElement firstname;
	
	@FindBy(name= "customer.lastName")
	WebElement lastname;
	
	
	@FindBy(name= "customer.address.street")
	WebElement address;
	
	@FindBy(name= "customer.address.city")
	WebElement city;
	
	@FindBy(name= "customer.address.state")
	WebElement state;
	
	@FindBy(name= "customer.address.zipCode")
	WebElement zipcode;
	
	@FindBy(name= "customer.phoneNumber")
	WebElement phonenumber;
	
	@FindBy(name= "customer.ssn")
	WebElement ssn;
	
	@FindBy(name= "customer.username")
	WebElement username;
	
	@FindBy(name= "customer.password")
	WebElement password;
	
	@FindBy(name= "repeatedPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath= "//input[@class='button']")
	WebElement signIn;
	
	
	public boolean errorMessageIsDisplayed() throws InterruptedException {
		Thread.sleep(2000);
	 boolean flag= elementIsDisplayed(errorMessage);
		return flag;	
	}
	
	
	
	public void registrationForm() {
		registerLink.click();
		firstname.sendKeys("test");
		lastname.sendKeys("test");
		address.sendKeys("test");
		city.sendKeys("dewas");
		state.sendKeys("MP");
		zipcode.sendKeys("455001");
		phonenumber.sendKeys("8962373782");
		ssn.sendKeys("test");
		username.sendKeys("test");
		password.sendKeys("test");
		confirmPassword.sendKeys("test");
		signIn.click();
		
	}
	

	
}
