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
	private com.gmail.pages.IndexPage gmailIndexPage;
	private com.gmail.pages.EmailPage gmailEmailPage;
	private com.gmail.pages.PasswordPage gmailPasswordPage;
	private com.gmail.pages.ExitPage gmailExitPage;
	
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
		gmailIndexPage = PageFactory.initElements(driver, com.gmail.pages.IndexPage.class);
		gmailEmailPage = PageFactory.initElements(driver, com.gmail.pages.EmailPage.class);
		gmailPasswordPage = PageFactory.initElements(driver, com.gmail.pages.PasswordPage.class);
		gmailExitPage = PageFactory.initElements(driver, com.gmail.pages.ExitPage.class);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
	
	@Test(groups = "tut.by")
	public void testIndexPage(){
		tutByIndexPage.get();
	}
	
	@Test(groups = "tut.by", dataProvider = "dataForAmount", dataProviderClass = by.tut.data.DataForSearch.class)
	public void testSearchAmount(String strForSearch, int amountAfterSearch){
		tutBySearchPage.search(strForSearch);
		tutBySearchPage.testAmount(strForSearch, amountAfterSearch);
	}
	
	@Test(groups = "tut.by", dataProvider = "dataForLinks", dataProviderClass = by.tut.data.DataForSearch.class)
	public void testSearchLinks(String strForSearch, String titleAfterSearch){
		tutBySearchPage.search(strForSearch);
		tutBySearchPage.testLink(strForSearch, titleAfterSearch);
	}
	
	@Test(groups = "gmail.com", dataProvider = "dataForAccounts", dataProviderClass = com.gmail.data.DataForAccounts.class)
	public void testGmailCom(String email, String password){
		gmailIndexPage.get();
		gmailEmailPage.enterEmail(email);
		gmailPasswordPage.enterPassword(email, password);
		gmailExitPage.exitMail();
	}
}
