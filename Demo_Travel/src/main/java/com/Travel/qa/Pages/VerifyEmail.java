package com.Travel.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Travel.qa.Base.TestBase;
import com.Trvel.qa.Utils.Keywords;

public class VerifyEmail extends TestBase{
	
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody/tr[2]/td[4]")
	WebElement FirstMailSubject;
	
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody/tr[2]/td[5]/small")
	WebElement FirstMailTime;
	
	public VerifyEmail()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyEmailSubject(String Email) throws InterruptedException
	{
		String URL = "https://mailsac.com/inbox/" + Email;
		
		driver.navigate().to(URL);
		
		Keywords.KeywordExecution("verifytext", FirstMailSubject, "Please Complete JabaTalks Account");
		Keywords.KeywordExecution("verifytext", FirstMailTime, "a few seconds ago");
	}
}
