package com.WebDriver1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Location_GetAllLinks {
	
	
	public static void main(String[] args) {
		
		String baseURL ="http://www.baidu.com";
		
		WebDriver wd = new FirefoxDriver();
		wd.get(baseURL);
		
	
		
		
	//	List<WebElement> elements = wd.findElements(By.id("u1"));
		
		List<WebElement> elements =wd.findElement(By.id("u1")).findElements(By.tagName("a"));
		
		System.out.println(elements.size());
	//	List<WebElement> elements = wd.findElements(By.id("u1"));
		
//		for(int i = 0; i<=elements.size();i++){
//			
//			System.out.println(elements.get(i).getAttribute("href"));
//		}
		for(WebElement w:elements){
			
			
			
		System.out.println(w.getAttribute("href"));
			
			
		}
		
		wd.quit();
		
	}
	

}
