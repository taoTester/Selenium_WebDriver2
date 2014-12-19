package com.WebDriver1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;



public class MaximizeWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wDriver = new FirefoxDriver();
		
		String urlString = "http://www.baidu.com";
		
		wDriver.get(urlString);
		
		//è®¿é—®é¡µé�¢å�Žï¼Œå�¯ä»¥é€šè¿‡navigationå®žçŽ°å‰�è¿›å’Œå�Žé€€çš„åŠŸèƒ½
		Navigation ng= wDriver.navigate();
		ng.forward();
		ng.back();
		
		Thread.sleep(3000);
		System.out.println("Maximize Browser Window");
		
		wDriver.manage().window().maximize();
		
		//èŽ·å�–å½“å‰�é¡µé�¢çš„titleå’Œurlæ�¥éªŒè¯�æ˜¯å�¦å¾—åˆ°é¢„æœŸçš„ç»“æžœ
		
		wDriver.getTitle();
		wDriver.getCurrentUrl();
		
		wDriver.quit();
		System.out.println("The Browser will be closed");
	
		
	}
}
