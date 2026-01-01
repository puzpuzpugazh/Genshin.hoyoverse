package org.hoyo.gen;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static Actions a;
	static JavascriptExecutor jse;
	
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		a = new Actions(driver);
		jse= (JavascriptExecutor)driver;
	}
	
	public static void iWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void browserUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.getTitle();
		
	}
	
	public static void acceptCookie() {
		driver.findElement(By.xpath("//div/button")).click();
	}
	
	public static void scrollDown() {
		a.click(driver.findElement(By.xpath("//div[@id='pz_w4YUDp9Hahpz-l7sEnSHUj3']"))).perform(); // scroll down button element 
	}
	public static void killDriver() {
		driver.quit();
	}
		
}
