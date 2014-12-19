package com.WebDriver1;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		
		String baseURL = "http://www.baidu.com";
		
		WebDriver wd = new FirefoxDriver();
		wd.get(baseURL);
		
		new WebDriverWait(wd, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w){
				
			return	w.findElement(By.id("su")).isDisplayed();
			}
		
		});
		
		File scrrenShotFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrrenShotFile, new File("D:/junit/screen_selenium.jpg"));
		
//		TakesScreenshot tScreenshot = new TakesScreenshot() {
//			
//			@Override
//			public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
	
		wd.quit();
		
	}
}
