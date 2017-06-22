package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoPage {
	private WebDriver driver;
	private String email = "iwanttomakeatest@gmail.com";
	private String password = "A7674549";
	@FindBy(id = "identifierId") 
	private WebElement inputEmail;
	@FindBy(css = ".RveJvd.snByac")
	private WebElement buttonNext;
	@FindBy(css = "#password .whsOnd.zHQkBf")
	private WebElement inputPassword;
	
	public void enterEmail(){
		inputEmail.clear();
		inputEmail.sendKeys(email);
		buttonNext.click();
		// In next pages
//		inputPassword.clear();
//		inputPassword.sendKeys(password);
//		buttonNext.click();
	}
}
