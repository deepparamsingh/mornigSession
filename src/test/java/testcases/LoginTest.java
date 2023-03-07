package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage login;

	@Test(priority = 1)
	public void verifyTitle() {
		login = new LoginPage(driver);
		System.out.println("User login into application");
		Assert.assertTrue(login.loginToApplication());
	}

	@Test(priority = 2)
	public void clickOnContactPage() {
		login = new LoginPage(driver);
		System.out.println("User Click on Contact Page");
		Assert.assertTrue(login.clickOnContactPage());
	}

}
