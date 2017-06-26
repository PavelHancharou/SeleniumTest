package com.gmail.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gmail.links.LinkEnam;

public class SearchPage {
	private WebDriver driver;
	private List<WebElement> linkListFromPage;
	private WebElement inputSearch;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void testSearch(String email, LinkEnam link, int numLinks) {
		linkListFromPage = driver.findElements(By.cssSelector(".J-Ke.n0"));
		String expectedTitle = link.getLinkName() + " - " + email + " - Gmail";
		if (driver.getTitle().equals(expectedTitle)) {
			inputSearch = driver.findElement(By.id("#gs_taif50"));
		} else {
			for (int i = 0; i < linkListFromPage.size(); i++) {
				if (linkListFromPage.get(i).getText().equals(link.getLinkName())) {
					linkListFromPage.get(i).click();
					(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
					Assert.assertEquals(expectedTitle, driver.getTitle());
				}	
			}
		}
	}
}
