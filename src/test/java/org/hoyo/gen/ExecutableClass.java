package org.hoyo.gen;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ExecutableClass extends BaseClass{
	// JUnit
	static LandingPage lp;
	static NavBar nb;
	static RedeemCodePage rcp;
	int passCount = 0;
	int failCount = 0;
	
	@BeforeClass
	public static void initiateBrowser() {
		chromeBrowser();
		browserUrl("https://genshin.hoyoverse.com/en/");
		iWait(5);
		// landing page
		lp = new LandingPage();
		// nav-bar
		nb = new NavBar();
		// Redeem page
		rcp = new RedeemCodePage();
	}
	
	
	@Test
	public void TO1TC1() {
//		 TO1
		System.out.println("\n"+"Test Scenario 1: ");
//		 TC1
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
	}
	
	@Test
	public void TO1TC2() {
		// TO1
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
	}
	
	@AfterClass
	public static void terminateBrowser() {
		killDriver();
	}
}
