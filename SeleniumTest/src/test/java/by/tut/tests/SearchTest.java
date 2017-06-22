package by.tut.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
	
	private WebDriver driver;
	private by.tut.pages.IndexPage tutByIndexPage;
	private by.tut.pages.SearchPage tutBySearchPage;
	
	@BeforeClass
	public void setUp(){
		System.setProperty(
				"webdriver.gecko.driver",
				(new java.io.File("").getAbsolutePath()).toString()+
				"/src/test/resources/geckodriver/geckodriver.exe");
		this.driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tutByIndexPage = PageFactory.initElements(driver, by.tut.pages.IndexPage.class);
		tutBySearchPage = PageFactory.initElements(driver, by.tut.pages.SearchPage.class);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testTutBy(){
		tutByIndexPage.get();
		tutBySearchPage.search(tutBySearchPage.TEXT_FOR_AMOUNT);
		tutBySearchPage.testAmount();
		tutBySearchPage.search(tutBySearchPage.TEXT_FOR_LINK);
		tutBySearchPage.testLink();
	}
}
