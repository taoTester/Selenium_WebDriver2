package com.selenium.winter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenWeb {
	
   public static void main(String[] args) {
	

	String baseURL = "http://shenzhen.gedu.org/zhuanti/2014/20141107/index.html";
	
	WebDriver wdURL = new FirefoxDriver();
    wdURL.get(baseURL);
    
    new WebDriverWait(wdURL, 10).until(new ExpectedCondition<Boolean>() {
	
    	public Boolean apply(WebDriver w){
    		
    		return w.findElement(By.id("looyu_dom_1")).isDisplayed();
    			
    	}
    
    });
    if(wdURL.getTitle().equals("冬季班")){
    	
    	System.out.println("the Web can be opend successfully"); 	
    	
    } else {
		
    	System.out.println("the Web open failed");
	}
	
    wdURL.quit();
	
   }

}
