package DesignFramework.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DesginFramework.TestComponent.Baseclass;
import DesignFramework.pageLocator.LoginPage;
import DesignFramework.pageLocator.RegisterForm;

public class LoginTest extends Baseclass {
	LoginPage login;
	RegisterForm register;

	
	  @Test (dataProvider = "getData")
	  public void loginWithInvalidCred(HashMap<String, String>  data) throws InterruptedException {
	  
	  login = new LoginPage(driver);
	  
	  register = login.loginApplication(data.get("username"), data.get("password"));
	  
		/*
		 * if (register.
		 * verifyErrorMessage("An internal error has occurred and has been logged.",
		 * "An internal error has occurred and has been logged.")) {
		 * 
		 * register.registrationForm();
		 * 
		 * }
		 */
	  
	  }
	 

	@Test
	public void loginWithUserName() {
		login = new LoginPage(driver);
		register = login.loginApplication("test", "tt");
		register.verifyErrorMessage("The username and password could not be verified.", "The username and password could not be verified.");
	}

	@Test

	public void noUserNameAndPassword() {
		login = new LoginPage(driver);
		register = login.loginApplication("", "");
		register.verifyErrorMessage("Please enter a username and password.", "Please enter a username and password.");
	}

	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		//List<HashMap<String ,String>> data= getJsonData(System.getProperty("user.dir") +"\\src\\test\\java\\DesginFramework\\TestData\\data.json");
		List<HashMap<String ,String>> data= getJsonData(System.getProperty("user.dir") + File.separator + "data.json");
		
		 //return new Object[][] {{"test","test"},{"test1","test1"}};
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

}
