package com.WebDriver1;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;

public class SelectOperation {
	
	public static void main(String[] args) throws InterruptedException {
		
//		File file = new File("src/Select.html");
//		String fileString = "file///" + file.getAbsolutePath();
		
	//	String fileString = "http://data.ielts.cn/Default.aspx?name=20140417";
		
		String fileString = "http://data.ielts.cn/Default.aspx?name=20140417";
		
		System.out.println(fileString);
		
		WebDriver wdDriver = new FirefoxDriver();
		
		wdDriver.get(fileString);
		
		WebElement element = wdDriver.findElement(By.id("FL140417000004"));
		
		wdDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WindowsUtils.readStringRegistryValue("HKLM");
		
		element.isSelected();
		System.out.println(wdDriver.getCurrentUrl());
			
		Select singleSlect =new Select(wdDriver.findElement(By.id("FL140417000004")) );
		singleSlect.selectByIndex(1);
		
		
		
	    Thread.sleep(100);
	    
	    singleSlect.selectByValue("7348");
	    
	    for(WebElement we:singleSlect.getOptions()){
	    	
	    	System.out.println(we.getText());
	    }
		
		wdDriver.quit();
		
	}

}
