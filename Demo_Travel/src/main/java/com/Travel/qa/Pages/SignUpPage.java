package com.Travel.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Travel.qa.Base.TestBase;
import com.Trvel.qa.Utils.Keywords;
import com.Trvel.qa.Utils.TestUtils;

public class SignUpPage extends TestBase{

	@FindBy(id = "name")
	WebElement fullName;
	
	@FindBy(id= "orgName")
	WebElement orgName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(),'I agree to the')]")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[contains(text(),'Get Started')]")
	WebElement getStart;
	
	@FindBy(xpath = "//h2[text()='Create Your Account']/parent::div/following-sibling::form/div/span")
	WebElement SuccessMsg;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifySignUp(String Name, String Organization, String Email) throws InterruptedException
	{
		Keywords.KeywordExecution("inputtext", fullName, Name);
		
		Keywords.KeywordExecution("inputtext", orgName, Organization);
		
		Keywords.KeywordExecution("inputtext", email, Email);
		
		Keywords.KeywordExecution("buttonclick", checkBox, "x");
		
		Keywords.KeywordExecution("buttonclick", getStart, "x");
		
		TestUtils.largeWait();
		
		Keywords.KeywordExecution("verifytext", SuccessMsg, "A welcome email has been sent. Please check your email.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
