package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.training.pom.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class UniformAdminProductDeleteUNF_014 {
	
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
	public void validLoginTest() throws InterruptedException {
		LoginPOM abc = new LoginPOM(driver);
		abc.sendUserName("admin");
		abc.sendPassword("admin@123");
		abc.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		WebElement img1 = driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"));
		Actions act = new Actions(driver);
		act.moveToElement(img1).build().perform();
		driver.findElement(By.xpath("//li[@id='catalog']//ul//li//a[contains(text(),'Products')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr[2]//td[1]//input[1]")).click();
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
