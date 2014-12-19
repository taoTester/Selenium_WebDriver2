package com.WebDriver1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sendKeys {

	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("src/Send_Key.html");
		String fileString = "file:///" + file.getAbsolutePath();
		System.out.println("the html file located:\n"+fileString);
		
		
		WebDriver wd = new FirefoxDriver();
		wd.get(fileString);
	    Thread.sleep(100);
	    //向A框中输入信息
		wd.findElement(By.id("A")).sendKeys("Ltao Test A1");
		Thread.sleep(100);
		//全选A框里面的信息
		wd.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL+"a"));
		Thread.sleep(1000);
		//剪切A框里面的信息
		wd.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL+"x"));
		//将A框里面的信息复制到B框中
		wd.findElement(By.id("B")).sendKeys(Keys.CONTROL+"v");
		Thread.sleep(1000);
		//再次向A框中输入信息
		wd.findElement(By.id("A")).sendKeys(Keys.chord("Ltao Test A3"));
		Thread.sleep(1000);
		
		wd.quit();
	}
}
