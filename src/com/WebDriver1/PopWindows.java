package com.WebDriver1;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopWindows {

	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("src/PopWindows.html");
		
		String filestr = "file:///" + file.getAbsolutePath();
		
		
		System.out.println(filestr);
		WebDriver wd = new FirefoxDriver();
		wd.get(filestr);
		System.out.println(wd.getCurrentUrl()+"\n");
		wd.findElement(By.id("baidu")).click();
		
//		String currentHandle = wd.getWindowHandle();
//		
//		Set<String> allHandle = wd.getWindowHandles();
//		
//		Iterator<String> singlHandle = allHandle.iterator();
//		
//	    while (singlHandle.hasNext()){
//			
//			String handleString = singlHandle.next();
//			
//			WebDriver w = wd.switchTo().window(handleString);
//			
//			if(w.equals(currentHandle)) continue;
//			Thread.sleep(100);
//			
//			new WebDriverWait(w, 100).until(new ExpectedCondition<Boolean>() {
//			
//				public Boolean apply(WebDriver wd){
//					
//					return wd.findElement(By.id("su")).isDisplayed();
//				}
//			
//				
//			
//			});
//			
//			System.out.println("current title"+ w.getTitle());
//			System.out.println("current url:"+ w.getCurrentUrl());
//			
//		System.out.println(w.findElement(By.id("su")));	
//		
//		w.findElement(By.id("kw")).sendKeys("test");
//			
//			
//			
//		}
		
		
		
		
		
		//得到当前窗口的句柄
		String currentWindow = wd.getWindowHandle();
		
		System.out.println("The handle of current window:"+currentWindow.toString());
		
		//获得所有窗口的句柄
		Set<String> handleSets = wd.getWindowHandles();
		
		Iterator<String> iterator = handleSets.iterator();
		
	    while(iterator.hasNext()){
	    	
	    	String handleString = iterator.next();
	    	if(currentWindow.equals(handleString)) continue;
	    		
	    		WebDriver windowDriver = wd.switchTo().window(handleString);
	    		System.out.println("title and url"+windowDriver.getTitle()+","+windowDriver.getCurrentUrl());
	    	
	    		windowDriver.findElement(By.id("kw")).sendKeys("liangtao");
	    		windowDriver.findElement(By.id("su")).click();
	    		
	    		new WebDriverWait(windowDriver, 10).until(new ExpectedCondition<Boolean>() {
	    			
	    			public Boolean apply(WebDriver w){
	    				
	    				return w.findElement(By.className("nums")).isDisplayed();
	    			}
				});
	    	}
	    	
	    
		
		wd.quit();
	}
}
