package salesforcetest;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import contestutility.PropertiesUtility;
import contestutility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(contestutility.TestEventListenersUtility.class)

public class Leads extends BaseTest{
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
		logger.info("Salesforce homepage is opened");
		
	
}
@Test

public static void lead_details() throws InterruptedException {
	
	logindetails();
	
	
	WebElement lead_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
	Actions action = new Actions(driver);
	lead_tab.click();
	System.out.println("lead tab is opened");
	logger.info("lead tab is opened");
	
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	
	Thread.sleep(1000);
	
List<WebElement> lead_details = 	driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select"));
	
	for(WebElement e:lead_details) {
		
		System.out.println(e.getText());
		logger.info(e.getText());
		
	}
	
	
	driver.close();
	
}
@Test

public static void unread_leads() throws InterruptedException {
	logindetails();
	WebElement lead_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
	Actions action = new Actions(driver);
	lead_tab.click();
	System.out.println("lead tab is opened");
	logger.info("lead tab is opened");
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	
	
	Thread.sleep(1000);
	driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select"));
	
	Select unread = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select")));
	unread.selectByVisibleText("My Unread Leads");
	
	Thread.sleep(4000);
	
	WebElement unread_tab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/input"));
	action.moveToElement(unread_tab).build().perform();
	
	unread_tab.click();
	
	System.out.println("reports tab is opened");
	logger.info("reports tab is opened");
	driver.close();
	
}

@Test
public static void same_lead_tab() throws InterruptedException {
	logindetails();
	WebElement lead_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
	Actions action = new Actions(driver);
	lead_tab.click();
	System.out.println("lead tab is opened");
	logger.info("lead tab is opened");
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	Thread.sleep(1000);
	driver.findElements(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select"));
	WebElement go_tab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/input"));
	action.moveToElement(go_tab).build().perform();
	
	go_tab.click();
	logger.info("same lead method is closed");
	driver.close();
	
}

public static void todays_lead() throws InterruptedException {
	logindetails();
	
	WebElement lead_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
	Actions action = new Actions(driver);
	lead_tab.click();
	System.out.println("lead tab is opened");
	logger.info("lead tab is opened");
	
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	
	Thread.sleep(1000);
    Select today_tab = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select")));

	today_tab.selectByVisibleText("Today's Leads");
	Thread.sleep(1000);
	WebElement go_tab = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/input"));
	action.moveToElement(go_tab).build().perform();
	
	go_tab.click();
	System.out.println("todays reports is opened");
	logger.info("todays reports is opened");
	driver.close();
	
	
}
public static void create_lead() throws InterruptedException {
	logindetails();
	WebElement lead_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
	Actions action = new Actions(driver);
	lead_tab.click();
	System.out.println("lead tab is opened");
	logger.info("lead tab is opened");
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	Thread.sleep(5000);
	
	 WebElement new_btn = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
     action.moveToElement(new_btn).build().perform();
     new_btn.click();
     
     System.out.println("new button clicked");
     
     driver.findElement(By.id("name_lastlea2")).sendKeys("mic");
     
     driver.findElement(By.id("lea3")).sendKeys("Aethna Home Products");
     
     
   WebElement save_btn= driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
   action.moveToElement(save_btn).build().perform();
   save_btn.click();
   System.out.println("Lead is created");
   logger.info("lead is created");
   driver.close();
	
}
	
	public static void main(String[] args) throws InterruptedException {
		lead_details();
		unread_leads();
		same_lead_tab();
		todays_lead();
		create_lead();
		

	}

}
