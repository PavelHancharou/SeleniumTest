package by.tut.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IndexPage {
	private WebDriver driver;
	public static final String PAGE_URL="http://tut.by/";
	public static final String PAGE_TITLE="Белорусский портал TUT.BY";
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void get() {
		driver.get(PAGE_URL);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
	}
}
