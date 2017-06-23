package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage {
	private WebDriver driver;
	@FindBy(id = "identifierId") 
	private WebElement inputEmail;
	@FindBy(css = ".RveJvd.snByac")
	private WebElement buttonNext;
	@FindBy(css = "#password .whsOnd.zHQkBf")
	private WebElement inputPassword;
	
	public EmailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterEmail(String email){
		inputEmail.clear();
		inputEmail.sendKeys(email);
		buttonNext.click();
		// In next pages
//		inputPassword.clear();
//		inputPassword.sendKeys(password);
//		buttonNext.click();
	}
}
