package com.WebDriver1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;




/*
定位对象的目的：
1. 为了操作对象
2. 获得对象的属性，如获得测试对象的class属性，name属性等等
3. 获得对象的text
4. 获得对象的数量
*/

public class SimpleLocation {
	
	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("src/form.html");
		String filePath = "file:///" + file.getAbsolutePath();
		System.out.println("The file located on \n" + filePath);
		
		WebDriver wd = new FirefoxDriver();
		wd.get(filePath);
		wd.manage().window().maximize();
		Thread.sleep(300);
		WebElement emailElement = wd.findElement(By.cssSelector("div.controls input[name=\"email\"]"));
		WebElement inputeElement = wd.findElement(By.cssSelector("div.controls input[name=\"password\"]"));
		
		WebElement emailLabelElement = wd.findElement(By.cssSelector("div.control-group label[for=\"inputEmail\"]"));
		WebElement passwordElement = wd.findElement(By.cssSelector("div.control-group label[for=\"inputPassword\"]"));
		
		Actions builderActions = new Actions(wd);
		Action action1 = builderActions.moveToElement(inputeElement).build();
		System.out.println(emailElement.getCssValue("type"));
		action1.perform();
		System.out.println(emailElement.getCssValue("name"));
		
		Action action2 = builderActions.dragAndDrop(emailLabelElement, passwordElement).build();
		action2.perform();
	
		
//By id
		wd.findElement(By.id("inputEmail")).click();
		Thread.sleep(100);
		
//By name
		wd.findElement(By.name("password"));
		Thread.sleep(100);
		
//By tagname
		String classOfForm = wd.findElement(By.tagName("div")).getAttribute("class");
		System.out.println("The form is:\n"+ classOfForm);
		System.out.println("the title is:\n"+wd.getTitle());
		System.out.println("The current URL is:"+wd.getCurrentUrl());
		
		wd.quit();
		
	}

}
