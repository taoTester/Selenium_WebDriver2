package com.summary.selenium;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class LocationSummary {
	
	WebDriver driver;
	
	static Logger logger = Logger.getLogger(LocationSummary.class);
	
	
	
	
	public void testGetURL(String string){
	
		PropertyConfigurator.configure((new File("src/log4j_test.properties")).getAbsolutePath());
		System.out.println("testGetURL");
		
		logger.info("---------------URLinfo------------------------");
		logger.debug("------------------debug-------------");
		logger.error("--------------URLError---------------");
		
		driver = new FirefoxDriver();
		driver.get(string);
		driver.manage().window().maximize();
		
	}
	
	public void testDown(){
		
		System.out.println("testDown");
		
		driver.quit();
		
	}
	
	//测试Table表格的行数以及内容
	public void testTable(){
		
		System.out.println("testTable");
		
		logger.info("---------------Tableinfo------------------------");
		logger.debug("------------------debug-------------");
		logger.error("--------------TableError---------------");
		
	List<WebElement> allTR= driver.findElements(By.cssSelector("tr"));
	System.out.println("The table Rows Number is:"+allTR.size());
	for(WebElement allTH:allTR){
		
		List<WebElement> thContent = allTH.findElements(By.cssSelector("th"));
		
		for(WebElement allTHContent:thContent){
			
			System.out.println("the Content is:"+allTHContent.getText());
			
		}
		
	}
	System.out.println("testTable OVER");
	}
	
	//测试输入框,打出输入的内容
	
	public void testInput(String string){
		
		System.out.println("testInput");
		
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.cssSelector("input#user")).sendKeys(string);
		System.out.println(driver.findElement(By.cssSelector("input[type='text']")).getAttribute("value"));
	
	}
	

	//测试外部链接,并获取新窗口的元素
	
	public void testLink(){
		
		System.out.println("testLink");
		
		driver.findElement(By.className("baidu")).click();
		driver.navigate().back();
		System.out.println(driver.findElement(By.cssSelector("div#link a.baidu")).getAttribute("href"));
		
//		driver.findElement(By.className("baidu")).click();
		
//		String currentHandle = driver.getWindowHandle();
//		Set<String> allHandleSet = driver.getWindowHandles();
//		Iterator<String> iterator = allHandleSet.iterator();
//		
//		while(iterator.hasNext()){
//			String newHandle = iterator.next();
//			if(newHandle.equals(currentHandle)) continue;
//			driver.switchTo().window(newHandle);
//			driver.findElement(By.id("kw")).sendKeys("Liangtao New Window");
//			System.out.println(driver.getTitle());
//		    testDown();
//			driver.switchTo().window(currentHandle);
//			System.out.println(driver.getTitle());
//			System.out.println(driver.findElement(By.cssSelector("div#link a.baidu")).getAttribute("href"));
//			
//		}
		
	
		System.out.println("testLink Over");
	}
	
	
	//测试下拉框 Select
	
	public void testSelectDialog(){
		
		System.out.println("testSelect");
		
		WebElement selectElement=driver.findElement(By.name("select"));
		Select select = new Select(selectElement);
		select.selectByIndex(0);
		select.selectByValue("saab");
		select.selectByVisibleText("Opel");
		select.selectByIndex(3);
		System.out.println(select.isMultiple());
		
		System.out.println("testSelect OVER");
	}
	
	
	// 测试单选框 RadioBox
	
	public void testRadioBox(int index){
		
		System.out.println("testRadio");
		
		List<WebElement> allRadios = driver.findElements(By.name("identity"));
		
		allRadios.get(index).click();
		String selectString=allRadios.get(index).getText();
		boolean select=allRadios.get(index).isSelected();
		
		System.out.println(selectString+"and"+select);
		
		System.out.println("testRadio OVER");
	}
	
	
	//测试复选框 checkbox
	public void testCheckBox(int index){
		
		System.out.println("testCheck");
		
		List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		allCheckBoxes.get(index).click();
		boolean select = allCheckBoxes.get(index).isSelected();
		
		System.out.println(select);
		
		System.out.println("testCheck OVER");
		
	}

	//测试按钮 button
	
	public void testButton(){
		
		System.out.println("testButton");
		
		WebElement element = driver.findElement(By.className("button"));
		element.click();
		System.out.println(element.isEnabled());	
	
		System.out.println("testButton OVER");
	
	}

	//测试Alert对话框
	
	public void testAlert(){
		
		System.out.println("testAlert");
		
		WebElement element = driver.findElement(By.className("alert"));
		System.out.println(element.getAttribute("value"));
		element.click();
		Alert alert = driver.switchTo().alert();
		String alertString = alert.getText();
		alert.accept();
		System.out.println(alertString);
		
		System.out.println("testAlert OVER");
		
	}

	//上传文件
	
	public void testUploadFile(String path){
		
		System.out.println("testUpload");
		
		WebElement element = driver.findElement(By.id("load"));
		element.sendKeys(path);
		System.out.println("UoloadFile IS Successful?????");
		System.out.println(element.getAttribute("value"));
		
		System.out.println("testUpload OVER");
		
	}
	
	//打开新的窗口
	
	public void testNewWindow(){
		
		System.out.println("testNewWindow");
		
		WebElement element = driver.findElement(By.className("open"));
		
		element.click();
		String currentHandleString = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		Iterator<String> iterator = allHandles.iterator();
		
		while(iterator.hasNext()){	
			String newHandle = iterator.next();
			if(currentHandleString.equals(newHandle)) continue;
			driver.switchTo().window(newHandle);
			driver.findElement(By.id("kw")).sendKeys("testNewWIndow");
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(currentHandleString);
			System.out.println(driver.getTitle());
			
		}		
		System.out.println("testNewWindow OVER");
	}
	
	
	//测试操作动作 Action
	
	public void testAction(){
		
		System.out.println("Test Action");
		
	}
	
	//测试等待的时间
	
	public void testWait(){
		
		System.out.println("testWait");
		
		WebElement element = driver.findElement(By.className("wait"));
		element.click();
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
		
			public Boolean apply(WebDriver w1){
				
				return w1.findElement(By.className("red")).isDisplayed(); 
				
			}
		
		});
		
		
		System.out.println("testWait OVER");
		
	}
	
	public static void main(String[] args) {
		
		
		logger = Logger.getLogger(Log.class);
		logger.info("---------------info------------------------");
		logger.debug("------------------debug-------------");
		logger.error("--------------Error---------------");
		LocationSummary ls=new LocationSummary();
		File file = new File("src/demo.html");
		String baseURL = "file:///"+file.getAbsolutePath();
		ls.testGetURL(baseURL);
		ls.testTable();
		ls.testInput("Liangtao Input");
	ls.testLink();
		ls.testSelectDialog();
		ls.testRadioBox(2);
		ls.testCheckBox(0);
		ls.testCheckBox(2);
		ls.testButton();
		ls.testAlert();
		ls.testUploadFile("D:\\Junit\\BMITestData1.csv");
		ls.testNewWindow();
		ls.testAction();
		ls.testWait();
		ls.testDown();
		
		
	}
	
}
