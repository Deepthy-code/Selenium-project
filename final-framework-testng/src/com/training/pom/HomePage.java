package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fa-fw']")
	private WebElement salesReportIcon; 
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement salesIcon;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Orders')]")
	private WebElement ordersIcon;
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalogIcon;
	
	@FindBy(xpath="//li[@id='catalog']//ul//li//a[contains(text(),'Products')]")
	private WebElement productsIcon;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement cartIcon;
	
	//@FindBy(xpath="//li[@id='sale']//li[@class='active open']//a[contains(text(),'Orders')]")
	//@FindBy(xpath="//li[@id='sale']//li[@class='active open']//a[contains(text(),'Orders')]")
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]")
	private WebElement orders;
	
	public void mouseHoverCatalog() {
		Actions act = new Actions(driver);
		act.moveToElement(catalogIcon).build().perform();
	}
	
	public void clickProducts() {
		this.productsIcon.click();
	}
	
	public  void mouseHoverSalesReport() {
		Actions act = new Actions(driver);
		act.moveToElement(salesReportIcon).build().perform();
	}
	
	public  void clickSales() {
		this.salesIcon.click(); 
	}
	
	public  void clickOrders() {
		this.ordersIcon.click(); 
	}
	
	public void mouseHoverCart() {
		Actions act = new Actions(driver);
		act.moveToElement(cartIcon).build().perform();
	}
	public  void clickCartOrders() {
		this.orders.click(); 
	}
}
