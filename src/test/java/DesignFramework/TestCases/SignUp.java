package DesignFramework.TestCases;

import org.testng.annotations.Test;

import DesginFramework.TestComponent.Baseclass;
import DesignFramework.pageLocator.RegisterForm;

public class SignUp extends Baseclass {

	RegisterForm form;

	@Test
	public void resgistrationForm() {
		form = new RegisterForm(driver);
		form.registrationForm();
	}
}
