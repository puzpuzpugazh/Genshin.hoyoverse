package org.hoyo.gen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass{

	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="pz_w4YUDp9Hahpz-l7sEnSHUj3")
	private WebElement scrollBtn;
	public WebElement getScrollBtn() {
		return scrollBtn;
	}
	@FindBy(xpath = "(//div[@class='pz-button'])[10]")
	private WebElement downloadBtn;
	public WebElement getDownloadBtn() {
		return downloadBtn;
	}
	
	
}
