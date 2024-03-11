package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;



import pageObjectfiles.Googlesignin;
import utility_methods.ExtentReportCreator;
@Listeners(ExtentReportCreator.class)
public class GooglesigninTests extends Basetest
{
	
	 public Googlesignin signin;
	 
	 
	 
	
	@Test(priority=1,groups= {"smoke","regression"})
	public void clickSignIn() throws InterruptedException, IOException 
	{
		
		signin = new Googlesignin(driver);
		signin.clickSignin();
		takeScreenshot("signin" );
		
	}
	
	@Test(priority=2, groups= {"smoke","regression"})
	public void clickGoogle() throws InterruptedException, IOException
	{
		
		signin.googlebutton();
		takeScreenshot("Google");
	}
	
	@Test(priority=3, groups = {"regression"})
	public void eMail() throws InterruptedException, IOException 
	{
		
		//String input email= "abc@abc";
		signin.emailInput("abc@abc");
		takeScreenshot("Email");
	}
	
	@Test(priority=4, groups= {"regression"})
	public void nextButton() throws IOException, InterruptedException
	{
		
		signin.emailNext();
		takeScreenshot("next");
	}
	
	@Test(priority=5, groups= {"regression"})
	public void printErrorMesssage() throws InterruptedException, IOException
	{
		
		signin.errormessage();
		takeScreenshot("Error"); 
	}

}


