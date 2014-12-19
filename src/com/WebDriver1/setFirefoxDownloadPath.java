package com.WebDriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

//WebDriver 设置firefox自动下载，可以通过使用autoit,这个比较麻烦， 下面是通过提供一种profile来解决的办法

public class setFirefoxDownloadPath {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("browser.download.folderList", 2); //browser.download.folderList设置Firefox的默认下载文件夹， “0”是桌面， “1” 是我的下载， “2”是自定义
		profile.setPreference("browser.download.downloadDir","D:\\Junit");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vhd.ms-excal, text/csv, application/zip");
		
		WebDriver driver = new FirefoxDriver(profile);
		
		String baseURL = "http://vdisk.weibo.com/s/yYtqVCRv4gMkZ";
		
		driver.get(baseURL);
		
		driver.findElement(By.id("download_big_btn")).click();
		
		Thread.sleep(100);
		
		driver.findElement(By.cssSelector(".later_link")).click();
		
		Thread.sleep(200);
		
		
		
		
	}
	

}
