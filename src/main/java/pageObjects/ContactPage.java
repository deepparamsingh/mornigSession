package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class ContactPage {

	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	By headerMessage = By.xpath("//div[@id='header-message']");

	By submitBTN = By.xpath("//a[normalize-space()='Submit']");

	By errorMessage = By.xpath("//div[@class='alert alert-error ng-scope']");

	By name_err_msg = By.xpath("//span[@id='forename-err']");

	By email_err_msg = By.xpath("//span[@id='email-err']");

	By message_err_msg = By.xpath("//span[@id='message-err']");

	By nameInput = By.xpath("//input[@id='forename']");
	By surnameInput = By.xpath("//input[@id='surname']");
	By emailInput = By.xpath("//input[@id='email']");
	By phoneInput = By.xpath("//input[@id='telephone']");
	By messageInput = By.xpath("//textarea[@id='message']");

	By loadModule = By.xpath("//div[@class='popup modal hide ng-scope in']");

	By successMsg = By.xpath("//div[@class='alert alert-success']");

	public void clickSubmitBTN() {
		Utility.clickOnElement(driver, submitBTN);
		Utility.waitForSeconds(2);
	}

	public String verifyErrorMessagHeader() {
		if (driver.findElement(headerMessage).isDisplayed()) {

			return driver.findElement(headerMessage).getText();
		}
		return null;

	}

	public boolean nameValidation() {
		Utility.waitForElementToBeVisible(driver, name_err_msg, Duration.ofSeconds(2));
		if (driver.findElement(name_err_msg).isDisplayed()) {

			return true;
		}
		return false;
	}

	public boolean emailValidation() {
		Utility.waitForElementToBeVisible(driver, email_err_msg, Duration.ofSeconds(2));
		if (driver.findElement(email_err_msg).isDisplayed()) {

			return true;
		}
		return false;
	}

	public boolean messageValidation() {
		Utility.waitForElementToBeVisible(driver, message_err_msg, Duration.ofSeconds(2));
		if (driver.findElement(message_err_msg).isDisplayed()) {

			return true;
		}
		return false;
	}

	public void fillForm() {
		Utility.waitForElementToBeVisible(driver, headerMessage, Duration.ofSeconds(2));
		Utility.type(driver, nameInput, "Jhansi");
		Utility.type(driver, surnameInput, "Nandini");
		Utility.type(driver, emailInput, "Jhansi112@yopmail.com");
		Utility.type(driver, phoneInput, "416676399");
		Utility.type(driver, messageInput, "This is small framework testing project");

	}

	public String submitForm() {
		Utility.clickOnElement(driver, submitBTN);

		Utility.waitForElementToBeInvisibile(driver, loadModule, Duration.ofSeconds(30));

		return driver.findElement(successMsg).getText();

	}

}
