package org.task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	static WebDriver driver;
	static long startTime;
	
	@BeforeClass
	public static void launch() {
		System.out.println("Before class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Before
	public void beforeMethod() {
		
		System.out.println("Before Method");	
	    startTime = System.currentTimeMillis();

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
	
	@Test
	public void m1() throws Throwable {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);
		
		Thread.sleep(2000);

	}

}
