package com.gmail.data;

import org.testng.annotations.DataProvider;

import com.gmail.links.LinkEnam;

public class DataForSearch {
	@DataProvider(name = "dataForSearch")
	public static Object[][] dataForAccounts(){
		return new Object[][]{
			{"a", LinkEnam.Inbox, 4},
			{"I", LinkEnam.Inbox, 7}
		};
	}
}
