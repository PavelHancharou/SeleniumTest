package com.gmail.links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LinkHandler {
	private WebDriver driver;
	private List<WebElement> linkListFromPage;
	private LinkEnam[] linkNames = LinkEnam.values();

	public LinkHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void followLink(LinkEnam link, String email) {
		linkListFromPage = driver.findElements(By.cssSelector(".J-Ke.n0"));
		for (int i = 0; i < linkListFromPage.size(); i++) {
			WebElement openAllLinks = driver.findElement(By.cssSelector(".CJ"));
			if (i == 4 && openAllLinks.getText().equals("Ещё")) {driver.findElement(By.cssSelector(".CJ")).click();}
			if (linkListFromPage.get(i).getText().contains(link.getLinkName())) {
				String expectedTitle = linkListFromPage.get(i).getText() + " - " + email + " - Gmail";
				linkListFromPage.get(i).click();
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
				Assert.assertEquals(expectedTitle, driver.getTitle());
				break;
			}
		}
	}

	public void testLinks(String email) {
		for (LinkEnam link : linkNames) {
			if (!driver.getTitle().contains(link.getLinkName())) {
				followLink(link, email);
			}
		}
	}
}
