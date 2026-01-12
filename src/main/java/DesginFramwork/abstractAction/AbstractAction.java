package DesginFramwork.abstractAction;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class AbstractAction {

	WebDriver driver;

	// checking element is displaying

	public AbstractAction(WebDriver driver) {

		this.driver = driver;
	}

	/*
	 * method is use for displaying element
	 */

	public boolean elementIsDisplayed(WebElement ele) {

		return ele.isDisplayed();

	}
	
	
	public boolean verifyErrorMessage(String actual, String expected) {
		
		WebElement ele = driver.findElement(By.xpath("//p[text()='"+actual+"']"));
		
		return ele.getText().equals(expected);
	
	}
	
	
	

	/*
	 * method is use to visible element
	 */
	public void waitForElementVisible(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/*
	 * method is use to invisible element
	 */

	public void waitForElementInvisible(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
