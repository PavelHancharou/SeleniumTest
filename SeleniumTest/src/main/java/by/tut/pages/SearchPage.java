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
	private String PAGE_TITLE="TUT.BY | ПОИСК - Интернет -";

	@FindBy(id = "search_from_str") 
	private WebElement inputSearch;
	@FindBy(css=".button.big")
	private WebElement submitSearch;
	@FindAll(value = { @FindBy (css=".search-i h3") })
	private List<WebElement> linkList;
	
	private void testPageIsSearch(){
		String title = driver.getTitle();
		Assert.assertTrue(title.startsWith(PAGE_TITLE));
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
	
	public void testAmount(int amountAfterSearch) {
		int amount = linkList.size();
		System.out.println(amount + " links was found during search");
		Assert.assertEquals(amountAfterSearch, amount);
	}

	public void testLink(String titleAfterSearch) {
		if(linkList !=null){
			linkList.get(0).click();
		}else{
			throw new WebDriverException("References - "+ titleAfterSearch +" - is not found!");
		}
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(titleAfterSearch));
	}
}
