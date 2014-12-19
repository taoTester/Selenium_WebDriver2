package com.summary.selenium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class testQuNaR {
	
	WebDriver driver;
	WebElement element;
	Date fDate;
	SimpleDateFormat sdFormat;
	testQuNaR TQR;
	
	@Before
	public void setUp(){
		BasicConfigurator.configure();
		driver=new FirefoxDriver();
	    driver.manage().window().maximize();
		
		
	}
	
	@After
	public void tearDown(){
		
		driver.close();
		driver.quit();
		
	}

	public void selectMode(){
		
		element=driver.findElement(By.name("searchType"));
		if(!element.isSelected()){
			
			element.click();
		}
		
	}
	
	public String setDate(){
		
		Calendar calendar = Calendar.getInstance();
		
		fDate = new Date();
		calendar.setTime(fDate);
		
		calendar.add(Calendar.DAY_OF_MONTH, +7);
		
		sdFormat = new SimpleDateFormat("yyyy-MM-dd");

		return sdFormat.format(calendar.getTime());	
		
	}

	public void waitPage(){
		
		element = driver.findElement(By.cssSelector("div.crl_sp_action span.btn_ser_w button.btn_txt"));
		element.click();
	
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver w1){
				
				return w1.findElement(By.cssSelector("div#js-sbtn_list span span#btn_ser_w button.btn_txt")).isDisplayed();
			}
		});
		
	}
	
	
	public WebElement getElementWait(final By by){
		
		WebElement element2 = null;
		boolean flag = new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w2){
				
				return w2.findElement(by).isDisplayed();
			}
		
		});
		if(flag){
			
			element2=driver.findElement(by);
		}
		
		return element2;	
}
	
	
	public WebElement getElementNotWait(final By by){
		
		WebElement element3=null;
		try {
			
			element3=driver.findElement(by);
			
		} catch (Exception e) {
			
			element3=null;
		}
		return element3;
}
	
	
public void clickOrder(){
	
	int index = this.getRandom(5);
	
	List<WebElement> allExtraFee;
	try {
		
		allExtraFee = driver.findElement(By.className("e_fly_lst")).findElements(By.cssSelector("p:contains('每段航班均需缴纳税费')"));
		
		if(!allExtraFee.isEmpty()&&allExtraFee.size()!=0){
			
			allExtraFee.get(index).findElement(By.cssSelector("div.b_avt_lst+div+div+div+div.c8 div.a_booking a.btn_book span b")).click();
		
		}else {
			
			allExtraFee = driver.findElement(By.className("e_fly_lst")).findElements(By.className("avt_column"));
			allExtraFee.get(index).findElement(By.cssSelector("a.btn_book span b")).click();
			
		}
		
	} catch (Exception e) {
		return;
	}


}
	
	public int getRandom(int count){
		
		return (int) Math.round(Math.random()*(count-1));
		
	}
	
	@Test
	
	public void testQNR(){
		
		
		
		
		driver.get("http://flight.qunar.com/");
		this.selectMode();
		driver.findElement(By.name("fromCity")).clear();
		driver.findElement(By.name("fromCity")).sendKeys("北京");
		driver.findElement(By.name("toCity")).clear();
		driver.findElement(By.name("toCity")).sendKeys("武汉");
		driver.findElement(By.name("fromDate")).sendKeys(this.setDate());
		this.getElementWait(By.cssSelector("div.crl_sp_action span.btn_ser_w button.btn_txt")).click();
		driver.findElement(By.cssSelector("#openwrapperbtnXI231 > span > b")).click();
		this.clickOrder();
		//this.waitPage();
		
	}
	
//public static void main(String[] args) {
//	WebDriver wdDriver = new FirefoxDriver();
//	wdDriver.get("http://flight.qunar.com/");
//	wdDriver.findElement(By.name("searchType")).click();
//	wdDriver.findElement(By.name("fromCity")).clear();
//	wdDriver.findElement(By.name("toCity")).clear();
//	wdDriver.findElement(By.className("btn_txt")).click();
//	wdDriver.findElement(By.id("research_id")).click();
//}	
	

}
