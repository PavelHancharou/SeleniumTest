package com.gmail.attributes;

import org.openqa.selenium.WebDriver;

public class FindAttributes {
	private static String textForFindEmail = " - ";
	
	private FindAttributes(){
	}
	
	public static String findEmail(WebDriver driver){
		String[] splittedTitle = driver.getTitle().split(textForFindEmail);
		return splittedTitle[1];
	}
	
}
