package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {
	private WebDriver driver; 
	
	public OrdersPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="input-date-start")
	private WebElement dateStart;
	
	@FindBy(id="input-date-end")
	private WebElement dateEnd;
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	@FindBy(id="input-group")
	private WebElement groupbyfilter;
	
	@FindBy(id="input-status")
	private WebElement status;
	
	public  void dateStart(String dateStart) {
		this.dateStart.clear();
		this.dateStart.sendKeys(dateStart);
	}
	
	public void dateEnd(String dateEnd) {
		this.dateEnd.clear();
		this.dateEnd.sendKeys(dateEnd);
	}
	
	public  void clickFilterBtn() {
		this.filterBtn.click(); 
	}
	
	public  void clickGroupby() {
		this.status.click(); 
		Select sel = new Select(status);
		sel.selectByVisibleText("Complete");
	}
	
	public  void clickOrderStatus() {
		this.groupbyfilter.click(); 
		Select sel = new Select(groupbyfilter);
		sel.selectByVisibleText("Years");
	}
	
}
