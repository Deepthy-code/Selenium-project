package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.HomePage;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformAdminEditQuantityUNF_043 {
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
	public void productEdit() throws InterruptedException {
		LoginPOM l = new LoginPOM(driver);
		  ProductPage p = new ProductPage(driver);
		  HomePage h = new HomePage(driver);
			l.sendUserName("admin");
			l.sendPassword("admin@123");
			l.clickLoginBtn(); 
			Thread.sleep(1000);
			h.mouseHoverCatalog();
			h.clickProducts();
			p.clickProductEditIcon();
			p.clickdataTab();
			p.enterQuantity("100");
			p.clickSaveButton();
			
	}
	
	@AfterMethod
	  public void afterMethod() throws Exception {
		  Thread.sleep(2000);
			driver.quit();
	}
	
}
