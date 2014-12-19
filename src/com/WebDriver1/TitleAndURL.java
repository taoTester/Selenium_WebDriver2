package com.WebDriver1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TitleAndURL {
	
	WebDriver wd;
	private String string = "http://www.baidu.com";
	
	@Before
	public void setUp(){
		
		wd = new FirefoxDriver();
		
		wd.get(string);
		
	}
	
	@Test
	
	public void testGetTitle() throws InterruptedException{
		
		Thread.sleep(3000);
		wd.findElement(By.id("kw"));
		wd.findElement(By.id("su"));	
		System.out.println("Title is:" + wd.getTitle());
		System.out.println("URL is:" + wd.getCurrentUrl());
		
	}

	@After
	public void tearDown(){
		
		wd.quit();
	}
}
