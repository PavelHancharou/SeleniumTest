package com.gmail.data;

import org.testng.annotations.DataProvider;

public class DataForAccounts {
	@DataProvider(name = "dataForAccounts")
	public static Object[][] dataForAccounts(){
		return new Object[][]{
			{"iwanttomakeatest@gmail.com", "A7674549"}
		};
	}
}
