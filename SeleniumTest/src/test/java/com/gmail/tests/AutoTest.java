package com.gmail.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoTest {
	private WebDriver driver;
	private String gmailSite="http://gmail.com/";
	private String gmailTitle = "Gmail";
	
	@BeforeClass
	public void setUp(){
		System.setProperty(
				"webdriver.gecko.driver",
				"d:/program files/soft/geckodriver.exe");
		this.driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testLoadFirstPage() {
		driver.get(gmailSite);
		Assert.assertEquals(driver.getTitle(), gmailTitle);
	}
}
