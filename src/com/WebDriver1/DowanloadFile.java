package com.WebDriver1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DowanloadFile {

	public static void main(String[] args) {
		
		String baseURL = "https://github.com/junit-team/junit/downloads";
		
		WebDriver wd = new FirefoxDriver();
		
		wd.get(baseURL);
		
		wd.findElement(By.linkText("junit-dep-4.11.jar")).click();
		
		Alert alert = wd.switchTo().alert();
		alert.accept();
		
	}
	
}
