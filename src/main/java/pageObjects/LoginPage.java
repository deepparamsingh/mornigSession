package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Utility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By Contact = By.xpath("//a[normalize-space()='Contact']");

	public boolean loginToApplication() {
		if (driver.getCurrentUrl().equals("https://jupiter.cloud.planittesting.com/#/")) {
			return true;
		}
		return false;

	}

	public boolean clickOnContactPage() {
		Utility.clickOnElement(driver, Contact);
		Utility.waitForSeconds(2);
		if (driver.getCurrentUrl().contains("contact")) {
			return true;
		}
		return false;

	}

}
