package com.gmail.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LinkPage {
	private WebDriver driver;
	private List<WebElement> linkListFromPage;
	private LinkNames[] linkNames = LinkNames.values();
	private int linkNum = 0;
	
	public LinkPage(WebDriver driver){
		this.driver = driver;
	}

	public void testLinks(String email) {
		for(LinkNames link : linkNames){
			linkListFromPage = driver.findElements(By.cssSelector(".J-Ke.n0"));
			for(int i=0; i<linkListFromPage.size(); i++){
				if(linkListFromPage.get(i).getText().equals(link.getLinkName())){
					String expectedTitle = link.getLinkName() + " - " + email + " - Gmail";
					linkListFromPage.get(i).click();
					(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
					Assert.assertEquals(expectedTitle, driver.getTitle());
				}
			}
			linkNum++;
		}
		System.out.println(linkNum + " links was tested in gmail.com page");
	}
}
