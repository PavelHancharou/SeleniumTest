package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmailPage {
	private WebDriver driver;
	private String ariaLabelText = "Телефон или адрес электронной почты";
	
	@FindBy(id = "identifierId") 
	private WebElement inputEmail;
	@FindBy(css = ".RveJvd.snByac")
	private WebElement buttonNext;
	
	public EmailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterEmail(String email){
		Assert.assertEquals(ariaLabelText, inputEmail.getAttribute("aria-label"));
		WebElement expectedText = driver.findElement(By.cssSelector("#headingText"));
		inputEmail.clear();
		inputEmail.sendKeys(email);
		buttonNext.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(expectedText));
	}
}
