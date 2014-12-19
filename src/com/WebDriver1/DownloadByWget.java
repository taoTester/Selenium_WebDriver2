package com.WebDriver1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


//WebDriver not support the Download file, so we can via Wget to download file

public class DownloadByWget {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wd = new FirefoxDriver();
		wd.manage().window().maximize();
		
		wd.get("http://users.ugent.be/~bpuype/wget/");
		
		WebElement element = wd.findElement(By.linkText("wget.exe"));
		WebElement moveToElement = wd.findElement(By.linkText("wget.exe"));
		Actions builderActions = new Actions(wd);
		Action action = builderActions.moveToElement(moveToElement).build();
		
		String sourceURL = element.getAttribute("href");
		
		System.out.println(sourceURL);
		Thread.sleep(1000);
		action.perform();
		System.out.println("perform the action");
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		String wget_command = "cmd /c wget -P D:\\test --no-check-certificate " + sourceURL;
		 
		try {
		Process exec = Runtime.getRuntime().exec(wget_command);
		int exitVal = exec.waitFor();
		System.out.println("Exit value: " + exitVal);
		} catch (Exception ex) {
		System.out.println(ex.toString());
		}
		wd.quit();
		}

}


