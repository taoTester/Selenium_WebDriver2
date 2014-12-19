package com.WebDriver1;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Button_Group {

	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("src/button_group.html");
		String fileString = "file:///"+file.getAbsolutePath();
		
		System.out.println("the html file located in:\n"+fileString);
		
		WebDriver wd = new FirefoxDriver();
		
		wd.get(fileString);
		List<WebElement> butns = wd.findElements(By.className("btn"));
		
		for(WebElement btn: butns){
			try {
				
			
			if(btn.getText().equals("third1")){
				
				btn.click();
				break;
			}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("no the button");

			}
			
		}
		
		Thread.sleep(100);
		
		wd.quit();
	}
}
