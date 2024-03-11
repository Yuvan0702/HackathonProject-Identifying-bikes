package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utility_methods.ExtentReportCreator;


@Listeners(ExtentReportCreator.class)
public class Basetest
{
	public static WebDriver driver;
	//public static String url;
	public static Properties prop;
	@BeforeTest(groups = {"smoke","regression"})
	public WebDriver setup()
	{
		prop=new Properties();
		
		try 
		{
			// Loading the configuration file
			prop.load(new FileInputStream("src/main/java/config/Config.properties"));
		}	
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
		System.out.println(prop.getProperty("browserName"));
			
		// Checking which browser is specified in the configuration file and creating the corresponding WebDriver instance
		if(prop.getProperty("browserName").matches("edge")) 
		{
				
			driver = new EdgeDriver();
		}
				 
		else if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
					
			driver = new ChromeDriver();
		}
				
		else if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
				
		else if(prop.getProperty("browserName").matches("explorer"))
		{
			driver=new InternetExplorerDriver(); 
		}	
		
		//maximize the window
		driver.manage().window().maximize();
		// Navigating to the URL specified in the static variable
		String url= prop.getProperty("WebsiteUrl");
		driver.get(url);
		return driver;
	}
		
		
	
	
	@AfterTest(groups = {"smoke","regression"})
	public void teardown() 
	{
		driver.quit();
		
	}
	
	public  String takeScreenshot(String ScreenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=(System.getProperty("user.dir")+"\\Screenshots\\"+ScreenshotName+"_"+".png");
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);//copying ss to targetfile
		return targetFilePath;
		
		
		
	}

	

}
