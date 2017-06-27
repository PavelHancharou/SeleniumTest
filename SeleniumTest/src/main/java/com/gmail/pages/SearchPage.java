package com.gmail.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gmail.attributes.FindAttributes;
import com.gmail.links.LinkEnam;
import com.gmail.links.LinkHandler;

public class SearchPage {
	private WebDriver driver;
	private String replaceEmail = "email";
	private String expectedTitle = "Результаты поиска - " + replaceEmail + " - Gmail";
	private List<WebElement> readedLinkList;
	private List<WebElement> notReadedLinkList;
	private int foundLinks=0;
	private List<String> resultList = new ArrayList<String>();

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	private List<WebElement> removeEmptyLinks(List<WebElement> listE){
		List<WebElement> resultList = new ArrayList<WebElement>();
		for(WebElement e:listE){
			if(e.isDisplayed()){
				resultList.add(e);
			}
		}
		return resultList;
	}
	
	private void addToReturnText(List<WebElement> listE){
		for(WebElement e : listE){
			resultList.add(e.getText());
		}
	} 
	
	public void testSearch(String textForSearch, LinkEnam link, int expectedResult) {
		if(!driver.getTitle().contains(link.getLinkName())){
			new LinkHandler(driver).followLink(link, FindAttributes.findEmail(driver));
		}
		driver.findElement(By.cssSelector("#gbqfq")).sendKeys(textForSearch);
		driver.findElement(By.cssSelector("#gbqfb")).click();
		expectedTitle = expectedTitle.replace(replaceEmail, FindAttributes.findEmail(driver));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		readedLinkList = driver.findElements(By.cssSelector(".yP"));
		readedLinkList = removeEmptyLinks(readedLinkList);
		notReadedLinkList = driver.findElements(By.cssSelector(".zF"));
		notReadedLinkList = removeEmptyLinks(notReadedLinkList);
		foundLinks = readedLinkList.size() + notReadedLinkList.size();
		Assert.assertEquals(foundLinks, expectedResult);
		addToReturnText(readedLinkList);
		addToReturnText(notReadedLinkList);
		System.out.println("The links was found:");
		for(String str : resultList){
			System.out.println(str);
		}
	}
}
