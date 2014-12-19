package com.Yaml.method;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class findElement {
	
	By by = null;
	public HashMap<String, HashMap<String, String>> m2;
	YamlFileLocated yfl = new YamlFileLocated();
	public WebDriver driver=null;
	
	public By getBy(String type, String value){
		
		if(type.equals("id")){
			
			by =By.id(value);
		}
		
		if(type.equals("name")){
			
			by=By.name(value);
			
		}
		
		if(type.equals("className")){
			
			by=By.className(value);
		}
		
		if(type.equals("cssSelector")){
			
			by=By.cssSelector(value);
		}
		
		if(type.equals("linkText")){
			
			by=By.linkText(value);
		}
		
		if(type.equals("tagName")){
			
			by=By.tagName(value);
		}
		
		if(type.equals("xpath")){
			
			by=By.xpath(value);
			
		}
		
		if(type.equals("partialLinkText")){
			
			by=By.partialLinkText(value);
		}		
		return by;
	}
	
	public WebElement getElement(String key){
		
		yfl.getFile();
		String type = m2.get(key).get("type");
		String value = m2.get(key).get("value");
		return driver.findElement(this.getBy(type, value));
			
	}
	

	public static void main(String[] args) {
		
		
		findElement fElement = new findElement();
		WebElement element = fElement.getElement("baidu_input");
		element.sendKeys("1111");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
