package com.Trvel.qa.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.Travel.qa.Base.TestBase;

public class TestListners extends TestBase implements ITestListener
{
	public static String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss").format(new Date());
	
	public void onTestStart(ITestResult result) {  
        System.out.println("Execution Started...");    
  }  

  public void onTestSuccess(ITestResult result) {  
 
      System.out.println("Test Case Passed : "+result.getName());  
      
      File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      try {
			FileUtils.copyFile(src,new File("./ScreenShots\\PassLog\\"+ timeStamp +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }  

  public void onTestFailure(ITestResult result) {  
       
      System.out.println("Test Case Failed : "+result.getName()); 
      
      File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      try {
			FileUtils.copyFile(src,new File("./ScreenShots\\FailLog\\"+ timeStamp +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }  

}
