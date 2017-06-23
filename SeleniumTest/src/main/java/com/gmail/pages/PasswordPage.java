package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PasswordPage {
	private WebDriver driver;
	private String ariaLabelText = "Введите пароль";
	
	@FindBy(css = "#password .whsOnd.zHQkBf")
	private WebElement inputPassword;
	@FindBy(css = ".RveJvd.snByac")
	private WebElement buttonNext;

	public PasswordPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterPassword(String email, String password){
		Assert.assertEquals(ariaLabelText, inputPassword.getAttribute("aria-label"));
		WebElement expectedText = driver.findElement(By.cssSelector(".IMH1vc.lUHSR"));
		inputPassword.clear();
		inputPassword.sendKeys(password);
		buttonNext.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(expectedText));
	}
}
