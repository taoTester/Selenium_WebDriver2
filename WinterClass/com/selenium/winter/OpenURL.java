package com.selenium.winter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenURL {
	
	WebDriver wdDriver;
	
	public void openLink(String str){
		
		wdDriver = new FirefoxDriver();
		wdDriver.get(str);
		
	}

}
