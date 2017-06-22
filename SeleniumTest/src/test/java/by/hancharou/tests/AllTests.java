package by.hancharou.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllTests {
	
	private WebDriver driver;
	private by.tut.pages.IndexPage tutByIndexPage;
	private by.tut.pages.SearchPage tutBySearchPage;
	private com.gmail.pages.IndexPage gmailComIndexPage;
	private com.gmail.pages.AutoPage gmailAutoPage;
	
	@BeforeClass(alwaysRun = true)
	public void setUp(){
		System.setProperty(
				"webdriver.gecko.driver",
				(new java.io.File("").getAbsolutePath()).toString()+
				"/src/test/resources/geckodriver/geckodriver.exe");
		this.driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tutByIndexPage = PageFactory.initElements(driver, by.tut.pages.IndexPage.class);
		tutBySearchPage = PageFactory.initElements(driver, by.tut.pages.SearchPage.class);
		gmailComIndexPage = PageFactory.initElements(driver, com.gmail.pages.IndexPage.class);
		gmailAutoPage = PageFactory.initElements(driver, com.gmail.pages.AutoPage.class);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
	
	@Test(groups="tut.by")
	public void testTutBy(){
		tutByIndexPage.get();
		tutBySearchPage.search(by.tut.pages.SearchPage.TEXT_FOR_AMOUNT);
		tutBySearchPage.testAmount();
		tutBySearchPage.search(by.tut.pages.SearchPage.TEXT_FOR_LINK);
		tutBySearchPage.testLink();
	}
	
	@Test(groups="gmail.com")
	public void testGmailCom(){
		gmailComIndexPage.get();
		gmailAutoPage.enterEmail();
	}
}
