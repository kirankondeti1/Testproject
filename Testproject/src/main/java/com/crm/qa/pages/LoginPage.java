package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class LoginPage extends TestBase {
	// PageFactory
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath = "//button[contains(text(),'signup')]")
	WebElement signonBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateloginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String Usr, String Pwd) {
		username.sendKeys(Usr);
		password.sendKeys(Pwd);
		loginBtn.click();
		return new HomePage();
	}
}
