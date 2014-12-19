package com.selenium.winter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreePhoneCall {
	
	 

	public static void main(String[] args) throws InterruptedException {
		
		String baseURL = "http://shenzhen.gedu.org/zhuanti/2014/20141107/index.html";
		
		WebDriver wdURL = new FirefoxDriver();
	    wdURL.get(baseURL);
	    
	    new WebDriverWait(wdURL, 10).until(new ExpectedCondition<Boolean>() {
		
	    	public Boolean apply(WebDriver w){
	    		
	    		return w.findElement(By.id("looyu_dom_1")).isDisplayed();
	    			
	    	}
	    
	    });
	    
	    wdURL.findElement(By.className("lxb-cb-input")).click();
	    
	    Thread.sleep(100);
	    
	    System.out.println(wdURL.findElement(By.className("lxb-cb-input-tip-em")).getText());
	    
//	    if(wdURL.findElement(By.className("lxb-cb-input-tip-em")).getText().equals("输入您的电话号码，点击通话，稍后您将接到我们的电话，该通话对您")){
//	    	
//	    	System.out.println("the output information is right");
//	    }else {
//			
//	    	System.out.println("the output information is wrong");
//		}
		
	    wdURL.findElement(By.className("lxb-cb-input")).clear();
	    wdURL.findElement(By.className("lxb-cb-input-btn")).click();
	    
	    Thread.sleep(100);
	    
	    System.out.println(wdURL.findElement(By.className("lxb-cb-info-tip")).getText());
	    
//	    if(wdURL.findElement(By.className("lxb-cb-input-tip-em")).getText().equals("请您输入正确的号码，手机号码请直接输入，座机请加区号")){
//	    	
//	    	System.out.println("the pop information of correct phone is right");
//	    	
//	    }else {
//	    	System.out.println("the pop information of correct phone is wrong");
//		}
	    
	    wdURL.quit();
	    
		
	}
}
