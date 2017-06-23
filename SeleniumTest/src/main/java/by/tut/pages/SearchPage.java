package by.tut.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;

public class SearchPage {
	private WebDriver driver;
	private String pageUrl = "http://search.tut.by";
	private String pageTitle = "TUT.BY | ПОИСК - Интернет -";

	@FindBy(id = "search_from_str") 
	private WebElement inputSearch;
	@FindBy(css=".button.big")
	private WebElement submitSearch;
	@FindAll(value = { @FindBy (css=".search-i h3") })
	private List<WebElement> linkList;
	
	private void testPageIsSearch(){
		String title = driver.getTitle();
		Assert.assertTrue(title.startsWith(pageTitle));
	}
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}

	public void search(String strForSearch) {
		inputSearch.clear();
		inputSearch.sendKeys(strForSearch);
		submitSearch.click();
		testPageIsSearch();
	}
	
	public void testAmount(String str, int amountAfterSearch) {
		int amount = linkList.size();
		System.out.println("In your request \"" + str + "\" was found - " + amount + " links!");
		Assert.assertEquals(amountAfterSearch, amount);
	}

	public void testLink(String strForSearch, String titleAfterSearch) {
		String currentHandler = driver.getWindowHandle();
		if(linkList !=null){
			linkList.get(0).click();
		}else{
			throw new WebDriverException("References - "+ titleAfterSearch +" - is not found!");
		}
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(titleAfterSearch));
		System.out.println("Link on request \"" + strForSearch + "\" is exist!");
		driver.switchTo().window(currentHandler);
	}
}
