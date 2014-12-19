package com.WebDriver1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class testParameterSelenium2_CSV {
	
	String height;
	String weight;
	String BMI;
	String category;
	WebDriver wDriver;
	String baseURL;
	
	
	public testParameterSelenium2_CSV(String height, String weight, String BMI,String category) {

		this.height = height;
		this.weight = weight;
		this.BMI = BMI;
		this.category = category;
	}

	@Parameters
	public static Collection<String[]> getData() throws Exception{
		
		return getCSVData("D:\\Junit\\BMITestData1.csv");
	}
	
	public static Collection<String[]> getCSVData(String filepath) throws Exception{
		
		List<String[]> list =new ArrayList<String[]>();
		BufferedReader fileReader = new BufferedReader(new FileReader(filepath));
		String rowFile;
		while((rowFile=fileReader.readLine())!=null){
			String fileds[] = rowFile.split(",");
			list.add(fileds);
			
		}
		fileReader.close();	
		return list;
		
		
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
