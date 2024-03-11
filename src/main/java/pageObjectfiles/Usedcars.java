package pageObjectfiles;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;



import java.io.IOException;
import java.util.List;

public class Usedcars 
{
	WebDriver driver;
	public String filePath = null;
	
	
	
	public Usedcars(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement used_cars;
	
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement chennai;
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> popular_models;
	
	public void usedcarsmenu() throws InterruptedException 
	{
        //Mouse hovering action over used cars
        Actions action = new Actions(driver);
        action.moveToElement(used_cars).perform();
        Thread.sleep(3000);
       
        
	}
	
	public void selectChennai() throws InterruptedException
	{   
        //Selecting chennai in the used cars menu
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", chennai);
        Thread.sleep(3000);
        

	}
	
	public void popularmodels() throws IOException, InterruptedException
	{   
        //scrolling to view the popular models
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,600)");
        Thread.sleep(3000); 
        System.out.println("The popular car models used in Chennai are:");
        
        //Printing the elements(brand names) in the consoles
        for (int i=0;i<popular_models.size();i++)
        {
        	System.out.println(popular_models.get(i).getText());
        	
        }
        
	}
	
	public void navigateTohomepage() throws InterruptedException 
	{
		driver.navigate().to("https://www.zigwheels.com/");
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Navigated back to: "+ title);
		
	}

}
	
