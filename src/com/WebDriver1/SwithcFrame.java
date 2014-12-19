package com.WebDriver1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SwithcFrame {

	public static void main(String[] args) {
		
		File file = new File("src/frame.html");
		String str = "file:///" + file.getAbsolutePath();
		
	    WebDriver wd = new FirefoxDriver();
		wd.get(str);
		
	
		//进入frame1 然后再到frame2
		wd.switchTo().frame("f1");
		wd.switchTo().frame("f2");
		
		//在frame2 中进行操作， frame2 中嵌入了百度主页
		wd.findElement(By.id("kw")).sendKeys("liangtao");
		wd.findElement(By.id("su")).click();
		
		
	new WebDriverWait(wd, 100).until(new ExpectedCondition<Boolean>() {
	
		public Boolean apply(WebDriver w){
			
			return w.findElement(By.className("nums")).isDisplayed();
		}
	
	});
		
	
	Actions actions = new Actions(wd);
	actions.keyDown(Keys.SHIFT).click(wd.findElement(By.className("nums")));
		//直接跳出所有的frame
		wd.switchTo().defaultContent();
		
		System.out.println("error pop up");
		
		//会报错, 已经退出frame2了 找不到百度首页的元素
    // 	wd.findElement(By.id("kw")).sendKeys("liangtao");
		
		wd.quit();
	}
}
