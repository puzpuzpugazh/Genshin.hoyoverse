package org.hoyo.gen;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NavBar extends BaseClass{

	public NavBar() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='pz-button'])[58]")
	private WebElement homeBtn;
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
}
