package com.Yaml.method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class YamlFileLocated {
	
	File file;
	public By by=null;
	public WebDriver driver;
	
	public HashMap<String, HashMap<String, String>> m1;
	
	public YamlFileLocated(){
		//driver = new FirefoxDriver();
		this.getFile();
	}
	
	@SuppressWarnings("unchecked")
	public void getFile(){
		
		file = new File("ElementLocationFrame/BaiDuElement.yaml");
		
		try {
			m1 = Yaml.loadType(new FileInputStream(file.getAbsoluteFile()), HashMap.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	//	m1.values();
		System.out.println(m1.values());
		
		
	}

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
		
		
		String type = m1.get(key).get("type");
		String value = m1.get(key).get("value");
		return driver.findElement(this.getBy(type, value));
			
	}
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		YamlFileLocated yfl = new YamlFileLocated();
		WebElement element = yfl.getElement("baidu_input");
		element.sendKeys("");
		
	}

	
	
}
