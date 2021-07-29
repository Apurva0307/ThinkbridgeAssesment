package com.Travel.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Trvel.qa.Utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    
	public static Properties pro;
	public static  WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	
	public TestBase()
	{
		// Loads config.properties file
		try 
		{	
			pro= new Properties();
			FileInputStream file= new FileInputStream("./src\\main\\java\\com\\Travel\\qa\\Config\\config.properties");   
			
			try 
			{
				pro.load(file);
			} 	
			catch (IOException e) 
			{
			e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	//Opening browser according to the browser passed from properties file
	public void Installation()
	{
		if(pro.getProperty("Browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();   // ChromeDriver class extends to RemoteWebDriver class which implements WebDriver and javaScriptsExecuter Interface
			
		}
		else if(pro.getProperty("Browser").equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			
		}
		
		else if(pro.getProperty("Browser").equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtils.implicitlywait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
	}
}
