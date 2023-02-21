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


public class contactdetails  extends BaseTest{
	@Test
	
	public static  void logindetails() {
		
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
			
			logger.info("Sales force home page is opened");
		
	}
@Test

 public static void  contact_create() throws InterruptedException {
	 logindetails();
	 
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		 Thread.sleep(10000);
		 
		 WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
			
	 /*     
		 WebElement window_alert =   driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/input[1]"));
	      Thread.sleep(3000);
	      
	      action.moveToElement(window_alert).build().perform();
	      window_alert.wait();*/
		 
		 
		 WebElement new_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
		 action.moveToElement(new_btn).build().perform();
		 new_btn.click();
		 
	      System.out.println("New contact page is displayed");
	      //lastname
	      driver.findElement(By.id("name_lastcon2")).sendKeys("jhon");
	      //account name
	      driver.findElement(By.id("con4")).sendKeys("abc");
	      

			 WebElement save_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
			 action.moveToElement(save_btn).build().perform();
			 save_btn.click();
			 
	      System.out.println("Contact is created");
	      logger.info("Contact is created");
		
		driver.close();
	 
	 
 }
 @Test
 
 public static void create_new_view() throws InterruptedException {
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		 Thread.sleep(10000);
		 
		 WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
			
		
		 WebElement new_view = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		 action.moveToElement(new_view).build().perform();
		 new_view.click();
		 
		System.out.println("Createb new view is opened");
		//view name
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/input"))
		        .sendKeys("contactview1");
		//view unique name
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/input"))
		.sendKeys("contactview1");
		//save btn
		WebElement save_btn = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		
		action.moveToElement(save_btn).build().perform();
		save_btn.click();
		
		System.out.println("created new view link ");
		logger.info("created new view link ");
		driver.close();
		
	 
	 
	 
 }
@Test 

 public static void recently_created() throws InterruptedException {
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		 Thread.sleep(10000);
		
		 WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
			
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[3]/select"));
		Select recently_tab= new Select (driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[3]/select")));
		recently_tab.selectByVisibleText("Recently Created");
		System.out.println("recently tab is diaplayed");
		logger.info("recently tab is diaplayed");
		driver.close();
	 
	 
 }
	@Test
	
 public static void my_contacts() throws InterruptedException {
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		 Thread.sleep(10000);
		 WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
		 //my contact
		 driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select"));
		 Select my_contact_id = new Select (driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select")));
		 my_contact_id.selectByVisibleText("My Contacts");
		//go button
		 Thread.sleep(1000);
		 
		 WebElement go_tab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/input"));
			action.moveToElement(go_tab).build().perform();
	      	go_tab.click();
		
		System.out.println("My contact is opened");
		logger.info("My contact is opened");
		driver.close();
	
 }
 @Test
 public static void  recent_contact_info() throws InterruptedException {
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		 Thread.sleep(10000);
		 //close button
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		
	     WebElement recent_info = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a"));
		action.moveToElement(recent_info).build().perform();
		recent_info.click();
		System.out.println("recent contact  is opened");
		logger.info("recent contact  is opened");
		driver.close();
		
	 
	 
 }
	@Test
	
 public static void create_new_view_neg() throws InterruptedException {
	 
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		logger.info("Contacts tab is opened");
		 Thread.sleep(10000);
		 
		//close button
			WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
		
		 WebElement new_view = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		 action.moveToElement(new_view).build().perform();
		 new_view.click();
		 
		System.out.println("Createb new view is opened");
		//view name
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/input"))
		.sendKeys("contactview");
		//save btn
		WebElement save_btn = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		
		action.moveToElement(save_btn).build().perform();
		save_btn.click();
		
	WebElement error_msg = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
				
		System.out.println(error_msg.getText());
		logger.error(error_msg.getText());
		driver.close();
	 
 }
 @Test
 
 public static void contact_create_fail() throws InterruptedException {
	 logindetails();
	 WebElement contact_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(contact_tab).build().perform();
		contact_tab.click();
		
		System.out.println("Contacts tab is opened");
		logger.info("Contacts tab is opened");
		 Thread.sleep(10000);
		 
		 //close button
		 WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
			
			 WebElement new_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
			 action.moveToElement(new_btn).build().perform();
			 new_btn.click();
			 
		      System.out.println("New contact page is displayed");
		      //lastname
		      driver.findElement(By.id("name_lastcon2")).sendKeys("jhon");
		      //account name
		      driver.findElement(By.id("con4")).sendKeys("abc");
		      
		      
		      //save&new
		      WebElement save_new_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[2]"));
				 action.moveToElement(save_new_btn).build().perform();
				 save_new_btn.click();
				 
		WebElement  description =driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[1]/h2"));
				
			System.out.println(description.getText());
			
				 
     if (description.getText().equalsIgnoreCase("New Contact")) {
     	System.out.println("test case is failed");
     	logger.error("test case is failed");
     	
     }
		      
		driver.close();
	 
	 
 }
	public static void main(String[] args) throws InterruptedException {
		
		contact_create();
		create_new_view();
		recently_created();
		my_contacts();
	    recent_contact_info();
		   
		create_new_view_neg();
		contact_create_fail();
		

	}

}
