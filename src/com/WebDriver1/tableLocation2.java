
//获取表格的行数，得到表格中的内容


package com.WebDriver1;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tableLocation2 {

	public static void main(String[] args) {
		
		File file = new File("src/SimpleTable.html");
		String baseURL = "file:///"+file.getAbsolutePath();
		
		WebDriver wdDriver = new FirefoxDriver();
		wdDriver.get(baseURL);
		
		new WebDriverWait(wdDriver, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w1){
				
				return w1.findElement(By.id("myTable")).isDisplayed();
			}
		
		});
		
		List<WebElement> allCols = wdDriver.findElement(By.id("myTable")).findElements(By.tagName("tr"));
		
		System.out.println("the col number is:"+allCols.size());
		
		for(WebElement w2: allCols){
			
			List<WebElement> titleContentElements = w2.findElements(By.tagName("th"));
			for(WebElement w3: titleContentElements){
				
				System.out.println("the title contents are:\n"+w3.getText());
			}
		
			List<WebElement> tableContents = w2.findElements(By.tagName("td"));
			
			for(WebElement w4: tableContents){
				
				System.out.println("The table contents are:\n"+w4.getText());
			}
		}
		
		wdDriver.quit();
	}
	
}
