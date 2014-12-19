package com.WebDriver1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS_Location4 {
	
	public static void main(String[] args) {
		
		String baseURL = "http://www.baidu.com";
		
		WebDriver wd = new FirefoxDriver();
		
		wd.get(baseURL);
		

		
	  WebElement  element = wd.findElement(By.cssSelector(".mnav[name='tj_trnews']"));
	  System.out.println(element.getAttribute("href"));
	  
	  System.out.println(element.getText());
	  
	  wd.quit();
		
//		List<WebElement> allElements = wd.findElements(By.cssSelector("#u1 a"));
//		
//		for(WebElement w1: allElements){
//			
//			w1.findElement(By.cssSelector(".mnav[name='tj_trnews']")).click();
//			
//		}
	
		
		
	}

}
