package com.WebDriver1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAndCloseBrowser {
	
	public static void main(String[] args) {
		
		WebDriver wDriver = new ChromeDriver();
		System.out.println("The Browser has been open");
		
//å…³é—­æµ�è§ˆå™¨çš„ä¸¤ç§�æ–¹æ³•
		wDriver.close(); //å…³é—­å½“å‰�çš„çª—å�£
		wDriver.quit();  //ä¸�ä»…å…³é—­çª—å�£ï¼Œè¿˜ä¼šå½»åº•çš„é€€å‡ºWebDriverï¼Œé‡Šæ�?¾ä¸Ždriver serverä¹‹é—´çš„è¿žæŽ¥
		System.out.println("The Browser has been closed");
		
	}

}
