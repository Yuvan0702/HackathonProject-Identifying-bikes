package testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjectfiles.Upcomingbikes;
import utility_methods.ExtentReportCreator;


@Listeners(ExtentReportCreator.class)
public class UpcomingbikesTests extends Basetest
{
	public Upcomingbikes hondaupcoming;
	
	
	@Test(priority=1,groups= {"smoke","regression"})
	public void newBikes() throws Exception
	{
		
		hondaupcoming = new Upcomingbikes(driver);
		hondaupcoming.newbikesmenu();
		takeScreenshot("NewBikes");
		
	}
	
	@Test(priority=2,groups= {"smoke","regression"})
	public void upcomingbikes() throws Exception
	{
		
		hondaupcoming.upcomingbikesoption();
		takeScreenshot("Upcoming");
		
	}
	
	@Test(priority=3, groups = {"regression"})
	public void manufacturer() throws Exception
	{
		
		hondaupcoming.manufacturerselection();
		takeScreenshot("Manufacturer");
	}
	
	@Test(priority=4,groups = {"regression"})
	public void viewmore() throws Exception
	{
		
		hondaupcoming.viewallmodels();
		takeScreenshot("view");
		
	}
	
	@Test(priority=5, groups = {"regression"})
	public void hondabikemodels() throws Exception 
	{
		
		hondaupcoming.bikemodels();
		takeScreenshot("hondabikes");
	}
	
	@Test(priority=6, groups = {"smoke","regression"})
	public void backhome() throws Exception
	{
		hondaupcoming.navigateTohomepage();
		takeScreenshot("Backhome");
	}

}
