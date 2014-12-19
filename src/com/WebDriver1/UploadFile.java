package com.WebDriver1;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFile {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		File file = new File("src/upload_file.html");
		String str = "file:///"+file.getAbsolutePath();
		
		WebDriver wdDriver = new FirefoxDriver();
		wdDriver.get(str);
		
		wdDriver.findElement(By.className("file")).sendKeys("src/Form2.html");
		
		new WebDriverWait(wdDriver, 10).until(new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver w){
				
				return true;
			}
		});
		
		wdDriver.quit();
		
	}
}
