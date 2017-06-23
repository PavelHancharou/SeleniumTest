package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndexPage {
	private WebDriver driver;
	private String pageUrl = "http://gmail.com/";
	private String pageTitle = "Gmail";

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	public void get() {
		driver.get(pageUrl);
		Assert.assertEquals(pageTitle, driver.getTitle());
	}
}
