package org.task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	
	static WebDriver driver;
	static long startTime;
	
	@BeforeClass
	public static void launch() {
		System.out.println("Before class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Before
	public void beforeMethod() {
		
		System.out.println("Before Method");	
	    startTime = System.currentTimeMillis();

	}
	
	@Test
	public void mobile1() {
		
		 try {
			   
			   WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			   button.isDisplayed();
			   button.click();
			
	    	} catch (Exception e) {
			System.out.println("pop up is not displayed");
	    	}
		   
		   
		   WebElement search = driver.findElement(By.name("q"));
		   search.sendKeys("realme",Keys.ENTER);
		   
		   WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));   
		   mobileName.click();

	}
	
	
	@Test
	public void mobile2() {
		

		   String parentURL = driver.getWindowHandle();
		   
		   Set<String> childURL = driver.getWindowHandles();
		   for (String child : childURL) {
			   
			   if(!parentURL.equals(child)) {
				   
				   driver.switchTo().window(child);
				   
			   }
			
		
		   }

	}
	
	@Test
	public void mobile3() {
		
	    	WebElement mobileName2 = driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
		   String name = mobileName2.getText();
		   System.out.println(name);
		   
		   Assert.assertTrue(mobileName2.isDisplayed());
		   
		   Assert.assertEquals("realme Narzo 50A (Oxygen Blue, 128 GB)  (4 GB RAM)", name);
		   

		
	}
	
	@Ignore
	@Test
	public void mobile4() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}
	
	
	@After
	public void afterMethod() {
		
		long endTime = System.currentTimeMillis();
		
	    long tt = endTime - startTime;
		
	    System.out.println("After Method");
		System.out.println("Time taken is :"+ tt);

	}
	
	@AfterClass
	public static void closeBrowser() throws IOException {
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");  
		   LocalDateTime now = LocalDateTime.now();  
		   String format = dtf.format(now);
		   System.out.println(format);
		      
		
		System.out.println("After class");
        TakesScreenshot tk = (TakesScreenshot)driver;	
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//target//report"+format+".png");		
		FileUtils.copyFile(source, dest);
		
		
		driver.quit();

	}
	
	
	
	
	

}
