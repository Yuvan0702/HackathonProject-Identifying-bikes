package pageObjectfiles;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import org.openqa.selenium.JavascriptExecutor;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Upcomingbikes {
	
	WebDriver driver;
	public String filePath = null;
	
	
	
	//constructor to initialize webelements
	public Upcomingbikes(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	//page objects
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a")
	WebElement newbike;
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement upcomingbikes_option;
	
	@FindBy(id="makeId")
	WebElement manufacturer;
	
	@FindBy(xpath="//span[contains(text(),'View More Bikes ')]")
	WebElement view;
	
	//@FindBy(xpath = "//*[@id='carModels']/ul")
	//WebElement hondabikes;
	
	@FindBy (xpath = "//*[@class='b fnt-15']")
	List<WebElement> hondaclass;
	
	@FindBy (xpath= "//*[@class= 'clr-try fnt-14']")
	List<WebElement> launchclass;
	
	//page object methods
	public void newbikesmenu() throws Exception
	{
        //move to the  new bike menu
		
		Actions action = new Actions(driver);
        action.moveToElement(newbike).perform();
        Thread.sleep(3000);
        
        
	}
	
	public void upcomingbikesoption() throws Exception 
	{
        //click the find new bikes option
		upcomingbikes_option.click();
        Thread.sleep(5000);
        
        
	}
	
	
	public void manufacturerselection() throws Exception
	{
        //Selecting honda as the manufacturer
		Select select = new Select(manufacturer);
        select.selectByVisibleText("Honda");
        Thread.sleep(3000);
        
        
	}
	
	public void viewallmodels() throws Exception
	{
        //Scrolling down to view more bikes
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1400)");
        Thread.sleep(3000);
        
        //clicking on view more bikes
        js.executeScript("arguments[0].click();",view);
        Thread.sleep(3000);
	}
	
	public void bikemodels() throws Exception
	{  
     
		int bikecount=hondaclass.size();
		ArrayList<String> priceList = new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();
		
		String[] arr = null;
		
		//Storing bike model name and price in separate lists
        for (int i=0;i<bikecount;i++)
        {
        
		String bikeModels = hondaclass.get(i).getAttribute("title");
        
        String bikePrice = hondaclass.get(i).getText();
        
        
        if (bikeModels.contains("Honda"))
        {
			nameList.add(bikeModels);
		}
		if (bikePrice.contains("Rs. "))
		{
			arr = bikePrice.split(" ");
			priceList.add(arr[1]);
		}
        
        }
        
        //Storing the launch dates in separate list
        ArrayList<String> dateList = new ArrayList<String>();
        for(int i =0; i<launchclass.size();i++)
        {
        	String launch = launchclass.get(i).getText();
			dateList.add(launch);
			
			
        	
        }
        		
		
		// Wait for page elements to load
		try {
			Thread.sleep(3000);
				}
		catch (InterruptedException e) {
					e.printStackTrace();
				}
		        
		// Initialize an ArrayList to store upcoming bikes with price less than 4 Lakhs
		ArrayList<String> upcomingBikes = new ArrayList<String>();
		if(nameList.size()>0)
		{
			for (int j = 0; j <nameList.size(); j++)
			{
				String temp = nameList.get(j);
				
		
					
		// Convert bike price to a double value
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE); // parse numbers in French-style format
				Number number = format.parse(priceList.get(j));
				
				double price = number.doubleValue();
				
					
		// Combine bike name, price and launch date to a single string
				String info = temp + "  " + priceList.get(j) + " Lakh  " + dateList.get(j);
				
					
		// Check if bike name is present in the string and price is less than 4 Lakhs
				if (info.contains(temp)) {
					if (Double.compare(price, 4d) < 0) {
						upcomingBikes.add(info);
						}
					}
			}
		}
				
				// Print the list of upcoming bikes to the console
				System.out.println("Upcoming Honda Bikes Below 4 Lakhs are as follows:");
				
				for (int z = 0; z < upcomingBikes.size(); z++) {
					System.out.println(upcomingBikes.get(z));
				}
				Thread.sleep(5000);
		} 
		public void navigateTohomepage() throws InterruptedException 
	{
		driver.navigate().to("https:www.zigwheels.com");
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Navigated back to: "+ title);
		
	}


}


