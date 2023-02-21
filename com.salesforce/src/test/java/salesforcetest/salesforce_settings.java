package salesforcetest;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import contestutility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(contestutility.TestEventListenersUtility.class)

public class salesforce_settings extends BaseTest {


@Test
	
	public static void logindetails_all () {
	
	 PropertiesUtility propertiesUtility =new PropertiesUtility();
	   
     Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
		
		String url=propertiesUtility.getPropertyValue("url");
		String username=propertiesUtility.getPropertyValue("login.valid.userid");
		String password=propertiesUtility.getPropertyValue("login.valid.password");
		
		
		
		String expected = "Home Page ~ Salesforce - Developer Edition";
	     GetDriverInstance("chrome");
		
		goToUrl(url);
		
		By idLoc = By.id("username");
		WebElement userName = driver.findElement(idLoc);
		WaitUntilElementIsVisible(userName,"username element");
		enterText(userName,username, "usernameEle");

		WebElement passwrd = driver.findElement(By.id("password"));
		enterText(passwrd, password, "passwordEle");

		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.id("userNavMenu"));
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		
		System.out.println("Settings tab is clicked");
		
		String url1 = driver.getCurrentUrl();
		driver.get(url1);
	
	
	
}
	
	@Test
	

	public static void logoutdetails() throws InterruptedException  {
		
		  logindetails_all ();
		  
			WebElement personal_data = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[2]/a"));
			
			Actions action = new Actions(driver);
		     action.moveToElement(personal_data).build().perform();
		     personal_data.click();
		     
		     System.out.println("personal data tab is clicked");
		     Thread.sleep(1000);
		    
		     WebElement login_details = driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
		     action.moveToElement(login_details).build().perform();
		     login_details.click();
			
		      WebElement download_link = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
		      
		      action.moveToElement(download_link).build().perform();
		      download_link.click();
		      
		      System.out.println("download link is clicked and displayed");
		      
		      driver.close();
			
	}
	
	@Test 
	
public static void display_layout() throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://login.salesforce.com/");
		
		String username = "learningtest2023@gmail.com";
		
		driver.findElement(By.id("username")).sendKeys("learningtest2023@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("selenium2023");
		driver.findElement(By.name("rememberUn")).click();
		
		
		driver.findElement(By.id("Login")).click();
		
		System.out.println("Sales force home page is loaded");
		
		//profile details
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.id("userNavMenu"));
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
		
		String url = driver.getCurrentUrl();
		driver.get(url);
		
		WebElement display_layout = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[3]/a"));
		
		Actions action = new Actions(driver);
	     action.moveToElement(display_layout).build().perform();
	     display_layout.click();
		
	     System.out.println("displayed layout is clicked");
	     
		
		WebElement customize_tab = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[3]/div/div[1]/a"));
		
		action.moveToElement(customize_tab).build().perform();
		customize_tab.click();
		
		Select select =  new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[2]/td/select")));
		select.selectByVisibleText("Salesforce Chatter");
		
	    Thread.sleep(2000);
	    System.out.println("Salesforce chatter is selected");
	    
	    Thread.sleep(1000);
	    
	    
	
	WebElement aval_tab=	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[1]/select"));
	action.moveToElement(aval_tab).build().perform();
	aval_tab.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
 
    //act.sendKeys(Keys.PAGE_UP).build().perform();       //Page Up
   // System.out.println("Scroll up perfomed");
    Thread.sleep(3000);
	
	  Select select_id = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[1]/select")));
      select_id.selectByVisibleText("Reports");
	System.out.println("Reports tab is selected");
	
      
      WebElement add_btn = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[2]/div[2]/a"));
      action.moveToElement(add_btn).build().perform();
      add_btn.click();
      
      WebElement save_btn = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
      action.moveToElement(save_btn).build().perform();
      save_btn.click();
	 
	   System.out.println("Save button is clicked ");
	   
	   driver.close();
	
	
}
	
	public static void email_settings() throws InterruptedException {
		logindetails_all ();
		WebElement email_tab = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/a"));
		Actions action =  new Actions(driver);
	    action.moveToElement(email_tab).build().perform();
	    email_tab.click();
	    
	    WebElement email_settings = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[4]/div/div[1]/a/span"));
	    action.moveToElement(email_settings).build().perform();
	    email_settings.click();
	    
	    Thread.sleep(1000);
	    
	    
	    WebElement email_name =     driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[6]/table/tbody/tr[3]/td[2]/div/input"));
	    action.moveToElement(email_name).build().perform();
	    email_name.clear();
	    
	    email_name.sendKeys("bhanu");
	   
		
		
         WebElement save_btn = 		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
         action.moveToElement(save_btn).build().perform();
           save_btn.click();

	    String return_msg = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]")).getText();
	    System.out.println(return_msg);
	
	
	    driver.close();
		
		
	}
	
	public static void calendartab() throws InterruptedException {
		logindetails_all ();
		
		 WebElement cal_tab = driver.findElement(By.xpath(" /html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/a"));
		    Actions action = new Actions(driver);
		    action.moveToElement(cal_tab).build().perform();
		    cal_tab.click();
		    
		   Thread.sleep(1000);
		   
		    WebElement activity_reminder = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/div/div[2]/a"));
		    action.moveToElement(activity_reminder).build().perform();
		    activity_reminder.click();
		    Thread.sleep(1000);
		    WebElement open_btn = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[7]/table/tbody/tr[3]/td/input"));
		    
		    action.moveToElement(open_btn).build().perform();
		    open_btn.click();
		    String url_pop1 = "https://ertg-dev-ed.develop.my.salesforce.com/ui/core/activity/ActivityReminderPage?at=1675625545636&test=1";
		    
		    String url_pop = driver.getCurrentUrl();
		    
		    if(url_pop1.equalsIgnoreCase(url_pop)) {
		    	
		    	System.out.println("Pop window is displayed");
		    	extentreport.logTestInfo("Calendartab is displayed");
		    	
		    }
		    
		   driver.close();
		
		
	}
	@Test 
	
	public static void developertab() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://login.salesforce.com/");
		
		String username = "learningtest2023@gmail.com";
		
		driver.findElement(By.id("username")).sendKeys("learningtest2023@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("selenium2023");
		driver.findElement(By.name("rememberUn")).click();
		
		
		driver.findElement(By.id("Login")).click();
		System.out.println("Sales force home page is displayed");
		//profile details
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.id("userNavMenu"));
		String oldwindow = driver.getWindowHandle();
		WebElement developerElement =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[3]"));
		Actions action  = new Actions(driver);
		action.moveToElement(developerElement).build().perform();
		developerElement.click();
		
		Thread.sleep(5000);
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
	
		for (String h: getWindow){
	         // switching to each window
	         driver.switchTo().window(h);
	         String s= driver.getTitle();
	         // checking specific window title
	         if(s.equalsIgnoreCase("Sign in - Google Accounts")){
	            System.out.println("Window title to be closed: "+ driver.getTitle());
	            extentreport.logTestInfo("Window title to be closed: "+ driver.getTitle());
	            
	            driver.close();
	         }
	      }
	
		driver.switchTo().window(oldwindow);
		driver.quit();
	
		
	}
	public static void main(String[] args) throws InterruptedException {
		logoutdetails();
		display_layout();
		email_settings();
		calendartab();
		developertab();
		

	}

}
