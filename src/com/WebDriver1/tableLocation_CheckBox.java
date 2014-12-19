package com.WebDriver1;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class tableLocation_CheckBox {

	public static void main(String[] args) {
		
		File file = new File("src/Table2.html");
		
		String baseURL = "file:///"+file.getAbsolutePath();
		
		WebDriver wDriver = new FirefoxDriver();
		wDriver.get(baseURL);
		
		
		List<WebElement> allTableElements = wDriver.findElement(By.id("myTable")).findElements(By.tagName("tr"));
		
		System.out.println("The col of number is:"+allTableElements.size());
		
		for(WebElement w1:allTableElements){
			
			List<WebElement> contentOfElements = w1.findElements(By.tagName("td"));
			
			for(WebElement w2: contentOfElements){
				
				System.out.println(w2.getText());
				
				if(w2.getText().equals("Nash")){
					
					w2.findElement(By.id("user128_cm")).click();   
					w2.findElement(By.id("user128_browser")).click();
					
				}
				
				if(w2.getText().equals("John")){
					
					w2.findElement(By.id("user128_admin")).click();
					w2.findElement(By.id("user128_browser")).click();
				}
			}	
			
		}
		
		
		System.out.println(wDriver.findElement(By.tagName("td")).getText());
		
		
		if(wDriver.findElement(By.tagName("td")).getText().equals("Nash")){
			
			System.out.println("nash");
			
		}
	
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
