package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class UniformAdminDeletemultipleProductUNF_44 {
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
			driver.findElement(By.xpath("//tr[2]//td[1]//input[1]")).click();
			driver.findElement(By.xpath("//tr[3]//td[1]//input[1]")).click();
			driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
	}
	
	@AfterMethod
	  public void afterMethod() throws Exception {
		  Thread.sleep(2000);
			driver.quit();
	}
	
}

