package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import helper.Utility;
import pageObjects.ContactPage;
import pageObjects.LoginPage;

public class ContactPageTest extends BaseClass {

	LoginPage login;
	ContactPage contactPage;

	@Test(priority = 1)
	public void VerifyErrorMessages() {
		login = new LoginPage(driver);
		
		System.out.println("User Click on Contact Page");
		Assert.assertTrue(login.clickOnContactPage());
		
		contactPage = new ContactPage(driver);
		
		System.out.println("Now user is on contact page");
		assertEquals(contactPage.verifyErrorMessagHeader(), "We welcome your feedback - tell it how it is.");
		
		Utility.waitForSeconds(2);
		
		System.out.println("Click on submit button");
		contactPage.clickSubmitBTN();
		
		System.out.println("Forename is required");
		assertTrue(contactPage.nameValidation());
		
		System.out.println("Email is required");
		assertTrue(contactPage.emailValidation());
		
		System.out.println("Message is required");
		assertTrue(contactPage.messageValidation());
		
		System.out.println("All required fields messages are displayed");
		assertEquals(contactPage.verifyErrorMessagHeader(), "We welcome your feedback - but we won't get it unless you complete the form correctly.");

		
		
	}
	
	@Test(priority = 2)
	public void VerifyUserAbleToFillForm() {
		login = new LoginPage(driver);
		
		System.out.println("User Click on Contact Page");
		Assert.assertTrue(login.clickOnContactPage());
		
		contactPage = new ContactPage(driver);
		
		System.out.println("Now user is on contact page");
		contactPage.verifyErrorMessagHeader();
		
		//Utility.waitForSeconds(1);
		
		System.out.println("Click on submit button");
		contactPage.clickSubmitBTN();
		
		System.out.println("Fill form");
		contactPage.fillForm();
		
		System.out.println("All validation messages are Removed now");
		assertEquals(contactPage.verifyErrorMessagHeader(), "We welcome your feedback - tell it how it is.");
		
		System.out.println("Form Submitted Successfully !!!!");
		System.out.println(contactPage.submitForm());
				
	
	}

}
