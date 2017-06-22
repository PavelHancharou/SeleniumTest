package by.tut.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
	
	private WebDriver driver;
	private String tutSearch1 = "automated testing";
	private String tutSearch2 = "Minsk Automated Testing Community";
	private int valueAfterSearh = 15;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(
				"webdriver.gecko.driver",
				(new java.io.File("").getAbsolutePath()).toString()+
				"/src/test/resources/geckodriver/geckodriver.exe");
		this.driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(dataProvider="pagesWithTitles", dataProviderClass=by.tut.data.PagesWithTitles.class)
	public void testLoadFirstPage(String url, String title) {
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@Test(dependsOnMethods="testLoadFirstPage")
	public void testSearchAmount(){
		performSearch(tutSearch1);
		int value = driver.findElements(By.cssSelector(".search-i h3")).size();
		Assert.assertEquals(value, valueAfterSearh);
		System.out.println(value + " links was found during search");
	}
	
	@Test(dependsOnMethods="testSearchAmount")
	public void testSearchLink(){
		performSearch(tutSearch2);
		WebElement link = driver.findElement(By.cssSelector(".b-results__li>h3>a"));
		if(link !=null){
			link.click();
		}else{
			throw new WebDriverException("References - "+ tutSearch2 +" - is not found!");
		}
	}
	
	private void performSearch(String str){
		WebElement inputSearch = driver.findElement(By.id("search_from_str"));
		inputSearch.clear();
		inputSearch.sendKeys(str);
		WebElement sendButton = driver.findElement(By.cssSelector(".button.big"));
		sendButton.click();
	}
}
