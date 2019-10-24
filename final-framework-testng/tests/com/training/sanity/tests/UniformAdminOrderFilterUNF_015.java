package com.training.sanity.tests;

import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class UniformAdminOrderFilterUNF_015 {
	private WebDriver driver;
	private String baseUrl;
	
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	  public void setUp() {
	
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		}
	
  @Test
  public void productFilter() throws InterruptedException {
	  LoginPOM abc = new LoginPOM(driver);
	  OrdersPage o = new OrdersPage(driver);
	  HomePage h = new HomePage(driver);
		abc.sendUserName("admin");
		abc.sendPassword("admin@123");
		abc.clickLoginBtn(); 
		//WebElement salesicon = driver.findElement(By.xpath("//i[@class='fa fa-bar-chart-o fa-fw']"));
		//Actions act = new Actions(driver);
		//act.moveToElement(salesicon).build().perform();
		//driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		//driver.findElement(By.xpath("//ul[@class='collapse in']//a[contains(text(),'Orders')]")).click();
		Thread.sleep(1000);
		h.mouseHoverSalesReport();
		h.clickSales();
		h.clickOrders();
		o.dateStart("2019-10-01");
		o.dateEnd("2019-10-23)");
		o.clickFilterBtn();
		o.clickGroupby();
		o.clickOrderStatus();
		o.clickFilterBtn();
  }
  
  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(2000);
		driver.quit();
}
}

