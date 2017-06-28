package com.gmail.data;

import org.testng.annotations.DataProvider;

public class DataForSendingLetter {
	@DataProvider(name = "dataForSendingLetter")
	public static Object[][] dataForSendingLetter(){
		return new Object[][]{
			{"iwanttomakeatest@gmail.com", "Letter from ME", "Here can be any text"},
		};
	}
}
