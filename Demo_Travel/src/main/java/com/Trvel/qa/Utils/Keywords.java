package com.Trvel.qa.Utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Travel.qa.Base.TestBase;

public class Keywords extends TestBase{
	
	public static void KeywordExecution(String Action, WebElement element, String TestData) throws InterruptedException
	{
		if(Action.equalsIgnoreCase("inputtext"))
		{
			element.clear();
			element.sendKeys(TestData);
			TestUtils.smallWait();
		}
		
		else if(Action.equalsIgnoreCase("buttonclick"))
		{
			try 
			{
				element.click();
				TestUtils.smallWait();
			}
			catch(NoSuchElementException e)
			{
				js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", element);
				TestUtils.smallWait();
			}
		}
		
		else if(Action.equalsIgnoreCase("verifytext"))
		{
			String ActualMessage = element.getText().trim();
			String ExepctedMsg = TestData;
			
			if(ActualMessage.contains(ExepctedMsg))
				System.out.println("Verified Successfully");
			else
				System.out.println("Oops! verify failed");
			
			TestUtils.smallWait();
		}
	}	

}
