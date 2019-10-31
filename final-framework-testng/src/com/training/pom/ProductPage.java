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
	
	@FindBy(xpath="//tr[1]//td[8]//a[1]//i[1]")
	private WebElement editIcon;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	private WebElement saveButton;
	
	
	
	public  void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	public  void clickFilterBtn() {
		this.filterBtn.click(); 
	}
	
	public void clickProductEditIcon() {
		this.editIcon.click();
	}
	
	public void clickdataTab() {
		this.dataTab.click();
	}
	
	public void enterQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	public void clickSaveButton() {
		this.saveButton.click();
	}
	
}
