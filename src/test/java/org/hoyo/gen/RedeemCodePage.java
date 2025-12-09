package org.hoyo.gen;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedeemCodePage extends BaseClass {
	
	// redirect to the redeem page on official site 
	public void redemPageRedirection() {
		a.click(driver.findElement(By.xpath("(//div[@class=\"pz-button\"])[2]"))).perform();
		Set<String> windowsList = driver.getWindowHandles();
		for(String win: windowsList) {
			if(!driver.getWindowHandle().equals(win)) {
				driver.switchTo().window(win);
			}
		}
	}
	
	// constructor to reduce the object creation and to access the methods inside this class
	public RedeemCodePage() {
		PageFactory.initElements(driver, this);
	}
	
	// redeem code text field
	// find element by using @findby instead of driver.findelement (feature of POM)
	@FindBy(id = "cdkey__code")
	// Encapsulation
	private WebElement redemCodeText;
	// getter method to pass the element to other class 
	public WebElement getRedemCodeText() {
		return redemCodeText;
	}
	
}
