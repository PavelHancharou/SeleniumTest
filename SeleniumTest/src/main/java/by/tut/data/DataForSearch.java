package by.tut.data;

import org.testng.annotations.DataProvider;

public class DataForSearch {
	
	@DataProvider(name = "dataForAmount")
	public static Object[][] dataForAmount(){
		return new Object[][]{
			{"automated testing", 15}
		};
	}
	
	@DataProvider(name = "dataForLinks")
	public static Object[][] dataForLinks(){
		return new Object[][]{
			{"Minsk Automated Testing Community", "Minsk Automated Testing Community"}
		};
	}
}
