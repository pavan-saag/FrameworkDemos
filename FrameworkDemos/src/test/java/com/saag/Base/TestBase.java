package com.saag.Base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class TestBase
{
	public static WebDriver driver;
	public static Properties pConfig=new Properties();
	public static Properties pOR=new Properties();
	public static FileInputStream fis;
	
  @BeforeSuite
  public void startUp() throws Exception
  {
	  if(driver==null)
	  {
		  fis=new FileInputStream(".\\src\\test\\resources\\Properties\\config.properties");
		  pConfig.load(fis);
		  
		  fis=new FileInputStream(".\\src\\test\\resources\\Properties\\OR.properties");
		  pOR.load(fis);
		  
		  if(pConfig.getProperty("browser").equalsIgnoreCase("Chrome"))
				  driver=new ChromeDriver();
		  else if(pConfig.getProperty("browser").equalsIgnoreCase("Firefox"))
			  driver=new FirefoxDriver();
		  else  if(pConfig.getProperty("browser").equalsIgnoreCase("Edge"))
			  driver=new EdgeDriver();
		  
		  driver.manage().window().maximize();
		  driver.get(pConfig.getProperty("siteUrl"));
		  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(pConfig.getProperty("timeOut"))));
	  }
  }

  @AfterSuite
  public void shutDown() 
  {
	  //driver.quit();
  }

}
