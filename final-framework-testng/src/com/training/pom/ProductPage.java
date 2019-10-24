package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	private WebDriver driver; 
	
	public ProductPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name")
	private WebElement productName; 
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	
	
	public  void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	public  void clickFilterBtn() {
		this.filterBtn.click(); 
	}
}
