package com.WebDriver1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("src/button_dropdown.html");
		String fileString = "file:///"+file.getAbsolutePath();
		
		System.out.println("the html file located in:\n"+fileString);
		
		WebDriver wd = new FirefoxDriver();
		
		wd.get(fileString);
		
		wd.findElement(By.linkText("Info")).click();
		Thread.sleep(100);
		
		wd.findElement(By.className("dropdown-menu")).findElement(By.linkText("watir-webdriver")).click();
		Thread.sleep(100);
	
	
		wd.quit();
	}
	
}
