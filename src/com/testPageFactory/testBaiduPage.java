package com.testPageFactory;

import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pageFactory.baiduPage;

public class testBaiduPage {
	
	WebDriver wdDriver;
	
	String baseURL;
	
	@Before
	public void setUp(){
		
		wdDriver = new FirefoxDriver();

		
		
	}
	
	@Test
	public void testSearch(){
		
		baseURL ="http://www.baidu.com";	
		wdDriver.get(baseURL);
		baiduPage bPage = new baiduPage(wdDriver);
		bPage.inputDialog.sendKeys("test");
		bPage.button.click();
		
		assertEquals("test_百度搜索", wdDriver.getTitle());
//		System.out.println(wdDriver.getTitle());
		
		
	}

	@After
	
	public void tearDown(){
		wdDriver.quit();
		
	}
}
