package by.tut.data;

import org.testng.annotations.DataProvider;

public class PagesWithTitles {

	@DataProvider(name="pages")
	public static Object[][] pagesWithTitles(){
		return new Object[][]{
			{"http://tut.by/","Белорусский портал TUT.BY"}
		};
	}
}
