package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Travel.qa.Base.TestBase;
import com.Travel.qa.Pages.SignUpPage;
import com.Travel.qa.Pages.VerifyEmail;

public class TestLaunching extends TestBase{
	
	SignUpPage signuppage;
	VerifyEmail verifyemail;
	
	
	public TestLaunching()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		Installation();
		signuppage = new SignUpPage();
		verifyemail = new VerifyEmail();
		
	}
	
	@Test
	@Parameters({"Name","Organization","EmailID"})
	public void SignUp(String Name, String Organization, String EmailID) throws InterruptedException
	{
		signuppage.verifySignUp(Name,Organization,EmailID);
		verifyemail.verifyEmailSubject(EmailID);
		
	}
	@AfterMethod
	public void tearOff()
	{
		driver.close();
	}
	
}
