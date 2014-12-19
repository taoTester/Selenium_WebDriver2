package com.WebDriver1;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


//定位一组对象，主要应用在下面的场景中：
//1. 批量操作对象，比如勾选一组checkbox
//2. 先获取一组对象，再在这组对象中过滤出具体需要的对象。比如定位出页面上所有的checkbox，然后选择最后一个

public class SimpleLocation3 {

	public static void main(String[] args) throws Exception {
		
		File file = new File("src/checkbox.html");
		String string = "file:///" + file.getAbsolutePath();
		
		WebDriver wd = new FirefoxDriver();
		
		wd.get(string);
		
		Thread.sleep(100);
		
		//找到所有的checkbox，并勾上所有的checkbox
		List<WebElement> checkBoxes = wd.findElements(By.cssSelector("input[type=checkbox]")); 
		
		
		for(WebElement checkbox:checkBoxes){
			
			checkbox.click();
		}
		
		//打印出checkbox的数量
		System.out.println("The total checkbox number is:" + checkBoxes.size());
		
		
		List<WebElement> inputs = wd.findElements(By.tagName("input"));
		
		for(WebElement input:inputs){
		
			if(input.getAttribute("type").equals("checkbox")){
				
				input.click();
				
			}
			
		}
		
		System.out.println("the number of inputs is:"+inputs.size());
		
		
		List<WebElement> allCheckBoxes = wd.findElements(By.cssSelector("input[typer=checkbox]"));
		allCheckBoxes.get(allCheckBoxes.size()-1).click();
		
		wd.quit();
		
		
		
		
		
		
		
		
		
		
	}
}
