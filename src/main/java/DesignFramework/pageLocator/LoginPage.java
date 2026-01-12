package DesignFramework.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DesginFramwork.abstractAction.AbstractAction;

public class LoginPage extends AbstractAction {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name= "username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//input[@class='button']")
	WebElement signIn;
	
	
	public RegisterForm loginApplication(String user , String pass) {
		
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
		RegisterForm register = new RegisterForm(driver);
		return register;
	}
	

	
}
