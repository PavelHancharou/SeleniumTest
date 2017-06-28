package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WriteLetter {
	private WebDriver driver;
	private String exceptedLetterTitle = "Новое сообщение";
	private String expectedMessadgeText = "Просмотреть сообщение";
	
	@FindBy(css=".T-I.J-J5-Ji.T-I-KE.L3")
	WebElement buttonWriteLetter;
	
	public WriteLetter(WebDriver driver){
		this.driver = driver;
	}
	
	public void send(String adress, String title, String text){
		buttonWriteLetter.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".aYF")));
		WebElement letterWindow = driver.findElement(By.cssSelector(".aYF"));
		Assert.assertEquals(driver.findElement(By.cssSelector(".aYF")).getText(), exceptedLetterTitle);
		driver.findElement(By.name("to")).sendKeys(adress);
		driver.findElement(By.name("subjectbox")).sendKeys(title);
		driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys(text);
		driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(letterWindow));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("link_vsm")));
		Assert.assertEquals(driver.findElement(By.id("link_vsm")).getText(), expectedMessadgeText);
	}
}
