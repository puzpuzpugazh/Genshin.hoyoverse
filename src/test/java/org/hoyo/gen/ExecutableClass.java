package org.hoyo.gen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExecutableClass extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		chromeBrowser();
		browserUrl("https://genshin.hoyoverse.com/en/");
		iWait(5);
		// landing page
		LandingPage lp = new LandingPage();
		// nav-bar
		NavBar nb = new NavBar();
		// Redeem page
		RedeemCodePage rcp = new RedeemCodePage();

		int passCount = 0;
		int failCount = 0;
		// TO1
		System.out.println("\n"+"Test Scenario 1: ");
		// TC1
		try {
			if ((lp.getDownloadBtn() != null) && (lp.getScrollBtn() != null)) {
				a.click(lp.getDownloadBtn()).perform();
				a.click(lp.getScrollBtn()).perform();
				a.click(nb.getHomeBtn()).perform();
				System.out.println("Test Case 1.1: Failed ");
				failCount++;
				System.out.println("Failed to make a physical click on element. Due to cookie pop-up, which is preventing from physical click."); // In future implement DDF to write this statement in excel as remark for this failed case
			} else {
				System.out.println("Test Case 1.1: Failed ");
				failCount++;
				System.out.println("Element is null");
			}
		} catch (Exception e) {
			System.out.println("Test Case 1.1: Failed ");
			failCount++;
			System.out.println("Failed to click, due to cookie pop-up is preventing from physical click.");
		}
		// TC2
		acceptCookie();
		try {
			if ((lp.getDownloadBtn() != null) && (lp.getScrollBtn() != null)) {
				Thread.sleep(5000);
				a.click(lp.getDownloadBtn()).perform();
				a.click(lp.getScrollBtn()).perform();
				a.click(nb.getHomeBtn()).perform();
				System.out.println("Test Case 1.2: Passed ");
				passCount++;
			} else {
				System.out.println("Test Case 1.2: Failed ");
				failCount++;
				System.out.println("Element is null");
			}
		} catch (Exception e) {
			System.out.println("Test Case 1.2: Failed"+ "\n" + "Can't able to locate element");
		}

		
		// TO2
		// TC1
		Thread.sleep(5000);
		System.out.println("\n"+"Test Scenario 2: ");
		try {
			a.click(lp.getScrollBtn()).perform();
			System.out.println("Test Case 2.1: Passed ");
			passCount++;
			Thread.sleep(5000);
			// TC2
			try {
				a.click(lp.getScrollBtn()).perform();
				System.out.println("Test Case 2.2: Failed ");	
				failCount++;
				System.out.println("Scroll down button visible on pages other than landing page");
			} catch (Exception e) {
				System.out.println("Test Case 2.2: Passed ");
				passCount++;
			}
		} catch (Exception e) {
			failCount++;
			System.out.println("Test Case 2.1: Failed"+ "\n"+ "Test Case 2.2: Failed");
		}
		
		
		// TO3
		// TC1
		
		
		
		
		
		
		
		
		
		System.out.println("\nTotal Test Execution summary\nTotal Test Cases Executed: "+(passCount+failCount));
		System.out.println("Passed: "+passCount);
		System.out.println("Failed: "+failCount);
		
		driver.quit();
	}
}
