package com.WebDriver1;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WaitAction {

	public static void main(String[] args) {
		
		File file = new File("src/wait.html");
		String strFile = "file:///" + file.getAbsolutePath();
		
		WebDriver wDriver = new FirefoxDriver();
		
		wDriver.get(strFile);
		
		wDriver.findElement(By.id("btn"));
		
	new WebDriverWait(wDriver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("label")));
		
		new WebDriverWait(wDriver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d){
				return d.findElement(By.className("label")).isDisplayed();
			}
		});
		
		new WebDriverWait(wDriver, 10).until(new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver w){
				return w.findElement(By.className("label")).isDisplayed();
			}
			
		});
		wDriver.quit();
		
	}
}
