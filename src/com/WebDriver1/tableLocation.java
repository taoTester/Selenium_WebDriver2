package com.WebDriver1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tableLocation {
	
	
	public static void main(String[] args) {
		
		String baseURL = "http://www.w3school.com.cn/html/html_tables.asp";
		
		WebDriver wdDriver = new FirefoxDriver();
		wdDriver.get(baseURL);
		
		new WebDriverWait(wdDriver, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w1){
				
				return w1.findElement(By.id("wrapper")).isDisplayed();
				
			}
		
		});
		
		List<WebElement> allColums = wdDriver.findElement(By.className("dataintable")).findElements(By.tagName("tr"));
		
		System.out.println("The table colum number is :"+ allColums.size());
		
		for(WebElement w1:allColums){
			
			List<WebElement> allContextElements = w1.findElements(By.tagName("td"));
			System.out.println("the number of TD:"+ allContextElements.size());
			
			for(WebElement w2:allContextElements){
				
				System.out.println(w2.getText());
			}
			
			
		}
		
		wdDriver.quit();
		
	}

}
