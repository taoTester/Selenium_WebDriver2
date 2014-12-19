package com.WebDriver1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//参数化数据存放在编码中
@RunWith(Parameterized.class)
public class testParameterSelenium1 {
	
	String height;
	String weight;
	String BMI;
	String category;
	WebDriver wDriver;
	String baseURL;
	
	
	public testParameterSelenium1(String height, String weight, String BMI, String category) {
	
		this.height = height;
		this.weight = weight;
		this.BMI = BMI;
		this.category = category;
	}



	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection testData(){
		
		
		Object[][] obData={{"180","50","15.4","Underweight"},{"160","90","35.2","Obesity"},{"168","70","24.8","Normal"},{"150","100","44.4","Obesity"}};
		return Arrays.asList(obData);
		
	}
	
	@Before
	public void setUp(){
		
		
		baseURL="https://dl.dropboxusercontent.com/u/55228056/bmicalculator.html";
		wDriver=new FirefoxDriver();
		wDriver.get(baseURL);
		
	}
	
	@Test
	public void testBMI(){
		
		wDriver.findElement(By.id("heightCMS")).sendKeys(height);
		wDriver.findElement(By.id("weightKg")).sendKeys(weight);
		wDriver.findElement(By.cssSelector("#Calculate")).click();
		
		assertEquals(BMI,wDriver.findElement(By.id("bmi")).getAttribute("value"));
		
		System.out.println(wDriver.findElement(By.id("bmi")).getText());
		System.out.println(wDriver.findElement(By.id("bmi")).getAttribute("value"));
		
		assertEquals(category, wDriver.findElement(By.id("bmi_category")).getAttribute("value"));
		
		
	}

	@After
	public void tearDown(){
		
		wDriver.quit();
	}
		
	}
	
	
	

