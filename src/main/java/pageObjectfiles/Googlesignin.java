package pageObjectfiles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class Googlesignin {
	public WebDriver driver;
	public String filePath = null;
	
	
	public Googlesignin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	//page objects
	
	@FindBy(id="des_lIcon")
	WebElement login_btn ;
	
	
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement google_btn;
	
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement email;
	
	
	@FindBy (xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement next;
	
	
	@FindBy(xpath="//div[contains(text(),'Enter a valid email or phone number')]")
	WebElement error;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	public void clickSignin() throws InterruptedException 
	{
		 //Clicking the login button on homepage
		
		Thread.sleep(3000);
		login_btn.click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", login_btn);
	}
	
	public void googlebutton() throws InterruptedException
	{
		//clicking the google on the signin popup
		Thread.sleep(5000);
		google_btn.click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", google_btn);
	}
	
	public void emailInput(String emailID) throws InterruptedException
	{
	
		//window handling for the login window
        Set<String> windows = driver.getWindowHandles();
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Iterator<String> iterator = windows.iterator();
		
		String parent = iterator.next();
		
		String child = iterator.next();
		
		//switching to new window for login in
		driver.switchTo().window(child);
		Thread.sleep(5000);
		
        //control in separate window
		//enter email
        email.sendKeys(emailID);
	}
	
	public void emailNext() throws InterruptedException 
	{
        //clicking next button
        next.click(); 
        Thread.sleep(5000);
        
	}
	
	public void errormessage() throws InterruptedException 
	{
		
        //printing error message
        String message = error.getText();
        System.out.println(message);
        
	}
        

}
