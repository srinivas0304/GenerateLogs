package com.tests;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	WebDriver driver;
	public static Logger log=Logger.getLogger(LoginTest.class.getName());
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@Test
	public void validateTitle()
	{
		log.info("---------------------------------This is validateTest--------------------------");
		
		
		String actualTitle=driver.getTitle();
		String expectedTitle="actiTIME - Login";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void validateLogo()
	{
		boolean b=driver.findElement(By.id("whiteBoxWithLogo")).isDisplayed();
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
