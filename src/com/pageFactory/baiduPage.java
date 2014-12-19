package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class baiduPage {
	
	
	@FindBy(css="#su")
	@CacheLookup
	public WebElement button;
	
	@FindBy(css="#kw")
	@CacheLookup
	public WebElement inputDialog;
	
	public baiduPage(WebDriver w1){
		
		
		PageFactory.initElements(w1, this);
		
	}
	

}
