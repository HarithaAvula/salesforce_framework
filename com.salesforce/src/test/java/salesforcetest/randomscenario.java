package salesforcetest;
import java.util.Iterator;
import java.util.List;
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



public class randomscenario extends BaseTest {
	@Test
	
	public static void logindetails() {
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
			logger.info("Sales force home page is displayed");
		
	}
	@Test
	
	public static void home_tab() throws InterruptedException {
		logindetails();
Thread.sleep(10000);
		
		//home tab
		
		WebElement home_tab_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(home_tab_click).build().perform();
		home_tab_click.click();
		
		
		System.out.println("Home page is displayed");
		logger.info("Sales force home page is displayed");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		
		
		WebElement username_click = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a"));
		action.moveToElement(username_click).build().perform();
		username_click.click();
		
		System.out.println("User profile page is dispalyed");
		logger.info("User profile page is dispalyed");
		driver.close();
		
		
		
	}
	
	@Test
	
	public static void home_tab_left() throws InterruptedException{
		
		logindetails();
Thread.sleep(10000);
		
		//home tab
		
		WebElement home_tab_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(home_tab_click).build().perform();
		home_tab_click.click();
		
		
		System.out.println("Home page is displayed");
		logger.info("Sales force home page is displayed");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		
		WebElement left_side_user = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[1]/div/div[2]/div[2]/div[2]/div[1]/div"));
		action.moveToElement(left_side_user).build().perform();
		left_side_user.click();
		System.out.println("User profile is displayed");
		logger.info("User profile page is dispalyed");
		
		driver.close();
	}
	
	@Test
	
	public static void profile_update() throws InterruptedException{
		logindetails();
        Thread.sleep(10000);
		
		//home tab
		
		WebElement home_tab_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(home_tab_click).build().perform();
		home_tab_click.click();
		
		
		System.out.println("Home page is displayed");
		logger.info("Sales force home page is displayed");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		
		WebElement left_side_user = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[1]/div/div[2]/div[2]/div[2]/div[1]/div"));
		action.moveToElement(left_side_user).build().perform();
		left_side_user.click();
		System.out.println("User profile is displayed");
		logger.info("User profile page is dispalyed");
		
		//edit button click
		
		
		Thread.sleep(10000);
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
	
		
		driver.switchTo().frame("contactInfoContentId")	;
		//	driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]"));
			
			driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
			
		WebElement lastname = 	driver.findElement(By.id("lastName"));
		lastname.clear();
		lastname.sendKeys("update1");
		
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]")).click();
		
		String updated_name = driver.getTitle();
		System.out.println(updated_name);
		logger.info(updated_name);
		
		driver.close();
	
	}
	@Test
	
	
	public static void custom_tabs() throws InterruptedException {
		logindetails();
		Thread.sleep(10000);
		//+ is clicking

		WebElement cust_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[10]/a/img"));
		Actions action = new Actions(driver);
		action.moveToElement(cust_click).build().perform();
		cust_click.click();
		
		System.out.println("All tabs page is displayed");
		logger.info("All tabs page is displayed");
		
		//customized_tab
		
		
		WebElement customized_tab = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
		
		action.moveToElement(customized_tab).build().perform();
		customized_tab.click();
		
		System.out.println("Customized tab is displayed");
		logger.info("Customized tab is displayed");
		
		//selected tab
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[3]/select"));
		Select selected_tab = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[3]/select")))
;
		
		selected_tab.selectByVisibleText("Libraries");
		
		//remove_tab_button
		
		WebElement remove_tab_button = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[2]/table/tbody/tr[4]/td/div/table/tbody/tr/td[2]/div[3]/a/img"));
		
		action.moveToElement(remove_tab_button).build().perform();
		remove_tab_button.click();
		
		//save button
		
        WebElement save_button = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
		
		action.moveToElement(save_button).build().perform();
		save_button.click();
		driver.close();
		
		
	}
	@Test
	
	
	public static void event_tab() throws InterruptedException {
		logindetails();
		
		WebElement home_tab_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(home_tab_click).build().perform();
		home_tab_click.click();
		
		
		System.out.println("Home page is displayed");
		logger.info("Sales force home page is displayed");
		
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		
		//clicking on date and time link
		
		WebElement date_link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a"));
		action.moveToElement(date_link).build().perform();
		date_link.click();
		
		System.out.println("date and time link is clicked ");
		logger.info("date and time link is clicked");
		
		//time link
		
		WebElement time_link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td[1]/form/div[1]/div/div[1]/table/tbody/tr[2]/td[1]/div[29]/a"));
		action.moveToElement(time_link).build().perform();
		time_link.click();
		System.out.println("time link is clicked ");
		logger.info("time link is clicked ");
		//subject combo
		String oldwindow = driver.getWindowHandle();
		WebElement subject_combo = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		action.moveToElement(subject_combo).build().perform();
		subject_combo.click();
		System.out.println("subject combo  link is clicked ");
		logger.info("subject combo  link is clicked ");
	
	         // switching to each window
	        
	         Thread.sleep(5000);
	         String mainWindowHandle = driver.getWindowHandle();
	         Set<String> allWindowHandles = driver.getWindowHandles();
	 		 Iterator<String> iterator = allWindowHandles.iterator();

	         // Here we will check if child window has other child windows and will fetch the heading of the child window
	         while (iterator.hasNext()) {
	             String ChildWindow = iterator.next();
	                 if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                WebElement element = driver.findElement(By.xpath("//body/div[2]/ul[1]/li[5]/a[1]"));
	   	         Actions builder = new Actions(driver);
	   	         builder.moveToElement(element).click().build().perform();
	   	         
	   	         
	                 
	             }
	         }
	        
	         driver.switchTo().window(mainWindowHandle);
	 		System.out.println("clicking on other link is clicked ");
	 		logger.info("clicking on other link is clicked ");
	 		//end time
	 		
	 		WebElement end_time = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	 		action.moveToElement(end_time).build().perform();
	 		
	 		
	 		end_time.click();
	 		//time box
	 		WebElement full_time = driver.findElement(By.xpath("/html/body/div[2]"));
	 		System.out.println(full_time.getText());
	 	
	 		//time picking
	 		WebElement time_pick = driver.findElement(By.xpath("/html/body/div[2]/div[43]"));
	 		action.moveToElement(time_pick).build().perform();
	 		time_pick.click();
	 		
	 		//save_btn
	 		WebElement save_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div[1]/table/tbody/tr/td[2]/input[1]"));
	 		action.moveToElement(save_btn).build().perform();
	 		save_btn.click();
	 		
	 		System.out.println("Event is created");
	 		logger.info("Event is created ");
	 		
	 		driver.close();
	}
	@Test
	
	
	public static void month_tab() throws InterruptedException {
		logindetails();
		WebElement home_tab_click = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/nav/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(home_tab_click).build().perform();
		home_tab_click.click();
		
		
		System.out.println("Home page is displayed");
		logger.info("Home page is displayed");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
	
		
		//clicking on date and time link
		
		WebElement date_link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[2]/a"));
		action.moveToElement(date_link).build().perform();
		date_link.click();
		
		System.out.println("date and time link is clicked ");
		
		logger.info("date and time link is clicked");
		//time link
		
		WebElement time_link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td[1]/form/div[1]/div/div[1]/table/tbody/tr[2]/td[1]/div[21]/a"));
		action.moveToElement(time_link).build().perform();
		time_link.click();
		System.out.println("time link is clicked ");
		logger.info("date and time link is clicked");
		//subject combo
		String oldwindow = driver.getWindowHandle();
		WebElement subject_combo = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/a/img"));
		action.moveToElement(subject_combo).build().perform();
		subject_combo.click();
		System.out.println("subject combo  link is clicked ");
		logger.info("subject combo  link is clicked");
	
	         // switching to each window
	        
	         Thread.sleep(5000);
	         String mainWindowHandle = driver.getWindowHandle();
	         Set<String> allWindowHandles = driver.getWindowHandles();
	 		 Iterator<String> iterator = allWindowHandles.iterator();

	         // Here we will check if child window has other child windows and will fetch the heading of the child window
	         while (iterator.hasNext()) {
	             String ChildWindow = iterator.next();
	                 if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                WebElement element = driver.findElement(By.xpath("//body/div[2]/ul[1]/li[5]/a[1]"));
	   	         Actions builder = new Actions(driver);
	   	         builder.moveToElement(element).click().build().perform();
	   	         
	   	         
	                 
	             }
	         }
	        
	         driver.switchTo().window(mainWindowHandle);
	 		System.out.println("clicking on other link is clicked ");
	 		logger.info("clicking on other link is clicked ");
	 		//end time
	 		
	 		WebElement end_time = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	 		action.moveToElement(end_time).build().perform();
	 		
	 		
	 		end_time.click();
	 		//time box
	 		WebElement full_time = driver.findElement(By.xpath("/html/body/div[2]"));
	 		System.out.println(full_time.getText());
	 		logger.info(full_time.getText());
	 	
	 		//time picking
	 		WebElement time_pick = driver.findElement(By.xpath("/html/body/div[2]/div[43]"));
	 		action.moveToElement(time_pick).build().perform();
	 		time_pick.click();
	 		//reccurence
	 		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[8]/table/tbody/tr[1]/td/div/input")).click();
	 		//week radio button
	 		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[8]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]/input")).click();
	 		
	 	 	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[8]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/div/span/input")).click();
	 		
	 	 	WebElement date_picker = driver.findElement(By.id("datePicker"));
	 	 	
	 		List <WebElement>rows=date_picker.findElements(By.tagName("tr"));
	 		 
	 		  List <WebElement>columns=date_picker.findElements(By.tagName("td"));
	 		 
	 		  for (WebElement cell: columns){
	 		 
	 		   //Select 10th Date
	 		   if (cell.getText().equals("24")){
	 		 
	 		   cell.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/div[2]/table/tbody/tr[5]/td[6]")).click();
	 		 
	 		   break;
	 		 
	 		   }
	 		 
	 		  }
	 		
	 		 WebElement save_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div[1]/table/tbody/tr/td[2]/input[1]"));
		 		action.moveToElement(save_btn).build().perform();
		 		save_btn.click();
		 		
		 		System.out.println("Event is created");
		 		logger.info("Event is created ");
		 		//month 
		 		 WebElement month_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div/div[2]/span[2]/a[3]/img"));
			 		action.moveToElement(month_btn).build().perform();
			 		month_btn.click();
	 		
			 		
			 		System.out.println("month button  is clicked");
			 		logger.info("month button  is clicked");
			 		
	 		//end date link
	 		
	 		
	 	//	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div[1]/div[2]/div[8]/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[2]/div/span/span/span/a")).click();
	 		
		
			 		driver.close();
		
		
		
		
	}
	
		public static void main(String[] args) throws InterruptedException {
		
		home_tab();
		//clicking username on leftside
		
	home_tab_left();
		profile_update();
		custom_tabs();
		
		event_tab();
	
		
		month_tab();
		
		

	}

}
