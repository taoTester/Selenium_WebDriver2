package com.WebDriver1;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;





public class Form2ActionAndAlert {

	public static void main(String[] args) throws InterruptedException {
		
		File flies = new File("src/Form2.html");
		String urlString = "file:///" +flies.getAbsolutePath();
		
		WebDriver wbDriver = new FirefoxDriver();
		
		wbDriver.get(urlString);
		
		System.out.println(urlString);

		wbDriver.findElement(By.className("checkbox")).click();
		System.out.println("checkIt");
		wbDriver.findElement(By.className("checkbox")).click();
		System.out.println("uncheck");
		
		Thread.sleep(100);
		
		List<WebElement> select = wbDriver.findElement(By.className("select")).findElements(By.tagName("option"));
		select.get(select.size()-1).click();
		System.out.println("select the option is:" + select.size());
		select.get(select.size()-2).click();
		
		Thread.sleep(100);
		
		wbDriver.findElement(By.className("btn")).click();
		
		Alert alert = wbDriver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		
		
		
		Thread.sleep(3000);
		
		wbDriver.quit();
		
		
		
	}
}
