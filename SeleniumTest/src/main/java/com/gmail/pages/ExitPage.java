package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExitPage {
	private WebDriver driver;
	
	@FindBy(css = ".gb_8a.gbii")
	private WebElement findExitElement;
	private String expectedTitle = "Gmail";
	
	public ExitPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void exitMail(){
		findExitElement.click();
		WebElement buttonExit = driver.findElement(By.id("gb_71"));
		buttonExit.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
	}
}
