package testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectfiles.Usedcars;
import utility_methods.ExtentReportCreator;

@Listeners(ExtentReportCreator.class)
public class UsedcarsTests extends Basetest
{
	public Usedcars cars;
	
	@Test(priority= 1, groups= {"smoke","regression"})
	public void Menu() throws InterruptedException, IOException
	{
		cars = new Usedcars(driver);
		cars.usedcarsmenu();
		takeScreenshot("Usedcars");
		
	}
	
	@Test(priority = 2, groups = {"smoke","regression"}) 
	public void chennaiSubmenuOption() throws InterruptedException, IOException
	{
		cars.selectChennai();
		takeScreenshot("Chennai");
	}
	
	@Test(priority = 3, groups = {"regression"})
	public void models() throws IOException, InterruptedException
	{
		cars.popularmodels();
		takeScreenshot("PopularModels");
	}
	
	@Test (priority = 4, groups = {"smoke","regression"})
	public void navigateback() throws InterruptedException, IOException
	{
		cars.navigateTohomepage();
		takeScreenshot("navigateToHome");
		
	}
	

}
