package salesforcetest;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Toolkit;
import org.openqa.selenium.Alert;
// options--
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import contestutility.constant;
import contestutility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(contestutility.TestEventListenersUtility.class)


public class salesforce_login  extends BaseTest{


	private static Properties propertyFile;
	public static  void loginToFirebase() throws InterruptedException, IOException {
		
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
		
	 String result  =     driver.getTitle();
	     
	 if (result.equalsIgnoreCase(expected)) {
		 
		 System.out.println(result);
		 logger.info(result);
		 
	 }
		
		driver.close();

	}
	@Test 
	
	public static void loginwrong() {
		
		 PropertiesUtility propertiesUtility =new PropertiesUtility();
		   
	      Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
			
			String url=propertiesUtility.getPropertyValue("url");
			String username=propertiesUtility.getPropertyValue("login.valid.userid");
			
			GetDriverInstance("chrome");
			
			goToUrl(url);
			
			By idLoc = By.id("username");
			WebElement userName = driver.findElement(idLoc);
			WaitUntilElementIsVisible(userName,"username element");
			enterText(userName,username, "usernameEle");

			WebElement password_ele = 	driver.findElement(By.id("password"));
			String password_value = password_ele.getAttribute("value");
		
		if(password_value.isEmpty()) {
			
			System.out.println("password box is empty");
			
			
		}
		
		driver.findElement(By.id("Login")).click();
		
	    WebElement error_msg = 	driver.findElement(By.id("error"));
	   System.out.println(error_msg.getText());
	   logger.error(error_msg.getText());
	    driver.close();
	
		
	}
	
	@Test
	
	public static void remberbox() {
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
			
			driver.findElement(By.name("rememberUn")).click();
			System.out.println("Remember checkbox is clicked");

			driver.findElement(By.id("Login")).click();
		
			System.out.println("Login button is clicked");
			logger.info("Login button is clicked");
			driver.close();
			
		
	}
	
	@Test
	public static void returnfromhome() throws InterruptedException {
		
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
			
			driver.findElement(By.name("rememberUn")).click();
			System.out.println("Remember checkbox is clicked");

			driver.findElement(By.id("Login")).click();
		
			System.out.println("Login button is clicked");
			
			driver.findElement(By.id("userNavLabel")).click();
			
			System.out.println("profile tab is clicked");
			
			driver.findElement(By.id("userNavMenu"));
			
			
			WebElement logout  = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			
			logout.click();
			
			System.out.println("Logout button is clicked");
			
			driver.get("https://ertg-dev-ed.develop.my.salesforce.com/");
			
			
		    WebElement user_id =  	driver.findElement(By.xpath("//*[@id=\"idcard-identity\"]"));
		
			System.out.println(user_id);
			
		     if(user_id.getText().equalsIgnoreCase(username)) {
			
			System.out.println("Username is same");
			logger.info("Username is same");
			
		
		}
		driver.close();
		
	}
	
	@Test
public static void forgotpassword() {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		driver.get("https://login.salesforce.com/");
		
		driver.get("https://ertg-dev-ed.develop.my.salesforce.com/secur/forgotpassword.jsp?locale=us");
		
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("learningtest2023@gmail.com");
		driver.findElement(By.id("continue")).click();
		
     	WebElement message = 	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]"));
		System.out.println(message.getText());
		logger.info(message.getText());
		
		
		
		
	}

	@Test
public static void wrong_details() throws InterruptedException {
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	   
    Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
		
		String url=propertiesUtility.getPropertyValue("url");
		String username=propertiesUtility.getPropertyValue("login.invalid.userid");
		String password=propertiesUtility.getPropertyValue("login.invalid.password");
		
		 GetDriverInstance("chrome");
			
			goToUrl(url);
			
			By idLoc = By.id("username");
			WebElement userName = driver.findElement(idLoc);
			WaitUntilElementIsVisible(userName,"username element");
			enterText(userName,username, "usernameEle");

			WebElement passwrd = driver.findElement(By.id("password"));
			enterText(passwrd, password, "passwordEle");

			driver.findElement(By.id("Login")).click();
	
	WebElement error_msg = 	driver.findElement(By.id("error"));
	System.out.println(error_msg.getText());
	logger.error(error_msg.getText());
	
	driver.close();
	
	
}
@Test

public static void usermenu() {
	
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
		List<WebElement> details = 	driver.findElements(By.id("userNavMenu"));
		
		for(WebElement e:details) {
			
			System.out.println(e.getText());
			logger.info(e.getText());

		}

		driver.close();
		
		
	
	
}
@Test

public static void myprofile() {
	
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
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	String url1 = 	driver.getCurrentUrl();
		
		driver.get(url1);
		
		//contact details
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
		
	driver.switchTo().frame("contactInfoContentId")	;
	//	driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]"));
		
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		
	WebElement lastname = 	driver.findElement(By.id("lastName"));
	lastname.clear();
	lastname.sendKeys("update");
	
	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]")).click();
	
	String updated_name = driver.getTitle();
	System.out.println(updated_name);
	
	logger.info(updated_name);
	driver.close();
	
	
	
	
}
@Test

public static void posttext() throws InterruptedException {
	
	JavascriptExecutor js;
	
	PropertiesUtility propertiesUtility =new PropertiesUtility();
	   
    Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
		
		String url=propertiesUtility.getPropertyValue("url");
		String username=propertiesUtility.getPropertyValue("login.valid.userid");
		String password=propertiesUtility.getPropertyValue("login.valid.password");
		
		
		
		String expected = "Home Page ~ Salesforce - Developer Edition";
	     GetDriverInstance("chrome");
		
		goToUrl(url);
		js = (JavascriptExecutor) driver;
		By idLoc = By.id("username");
		WebElement userName = driver.findElement(idLoc);
		WaitUntilElementIsVisible(userName,"username element");
		enterText(userName,username, "usernameEle");

		WebElement passwrd = driver.findElement(By.id("password"));
		enterText(passwrd, password, "passwordEle");

		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		driver.findElement(By.id("userNavMenu"));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	    String url1 = 	driver.getCurrentUrl();
	
	    Thread.sleep(10000);
        
	       driver.get(url1);
	       

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
        // 6 | selectFrame | index=2 | 
        driver.switchTo().frame(0);
        // 7 | mouseDown | css=.chatterPublisherRTE | 
        {
          WebElement element = driver.findElement(By.cssSelector("html"));
          Actions builder = new Actions(driver);
         // builder.moveToElement(element).clickAndHold().perform();
          builder.moveToElement(element).click().build().perform();
        }
        // 8 | mouseUp | css=p | 
        {
          WebElement element = driver.findElement(By.cssSelector("p"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).release().perform();
        }
        // 9 | click | css=.chatterPublisherRTE | 
        driver.findElement(By.cssSelector(".chatterPublisherRTE")).click();
        // 10 | editContent | css=.chatterPublisherRTE | <p>test data</p>
        {
          WebElement element = driver.findElement(By.cssSelector(".chatterPublisherRTE"));
          js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>test data</p>'}", element);
        }
        // 11 | selectFrame | relative=parent | 
        driver.switchTo().defaultContent();
        // 12 | click | id=publishersharebutton | 
        driver.findElement(By.id("publishersharebutton")).click();
        // 13 | click | id=userNavLabel | 

     driver.close();
	
	
	
}
@Test

public static void fileupload() throws InterruptedException, AWTException {
	
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
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	    String url1 = 	driver.getCurrentUrl();
	
	    Thread.sleep(10000);
        
driver.get(url1);
		
		WebElement feed = driver.findElement(By.linkText("Feed"));
	     
	     Actions action = new Actions(driver);
	     action.moveToElement(feed).build().perform();
	     feed.click();
		
	 
		
		
	WebElement file_upload = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/ul/li[2]/a"
			));
	
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("#publisherAttachContentPost")).click();
	
    
	Thread.sleep(1000);
	
     driver.findElement(By.cssSelector("#chatterUploadFileAction")).click();
	
     Thread.sleep(1000);
     
     WebElement browse=driver.findElement(By.xpath("//input[@id='chatterFile']"));
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		
		executor.executeScript("document.getElementById('chatterFile').click();");
		
		StringSelection stringSelection = new StringSelection("/Users/sureshreddy/Desktop/Haritha_work/java_practice/SeleniumMaven/NewData.xlsx/NewData.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_V);
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
		
		
  
    driver.close();
 
}
@Test

public static void photoupload() throws InterruptedException, AWTException {
	
	JavascriptExecutor js;
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
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	    String url1 = 	driver.getCurrentUrl();
	
	    Thread.sleep(10000);
        
        driver.get(url1);
         WebElement photo_link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[1]/div/a"));

          Actions action = new Actions(driver);
          action.moveToElement(photo_link).build().perform();
          photo_link.click();
          Thread.sleep(5000);

			driver.switchTo().frame(2);
			
			driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("/Users/sureshreddy/Desktop/Haritha_work/java_practice/SeleniumMaven/photos/F.jpeg");
			driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();
			Thread.sleep(10000);
			
			
			driver.findElement(By.id("j_id0:j_id7:save")).click();
			driver.switchTo().defaultContent();
			
			System.out.println("photo is uploaded");
			
			driver.close();

	
	
}


@Test

	
	public static void main(String[] args)throws InterruptedException, AWTException, IOException {
		loginToFirebase();
		loginwrong();
		remberbox();
		
		returnfromhome();
		forgotpassword();
		wrong_details();
		
		usermenu();
		
		myprofile();
	//	posttext();
	//	fileupload();
	  photoupload();
		
		

	}

	
}
