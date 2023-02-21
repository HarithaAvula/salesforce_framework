package salesforcetest;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import contestutility.PropertiesUtility;
@Listeners(contestutility.TestEventListenersUtility.class)

public class AccountingTesting extends BaseTest{
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
			
			extentreport.logTestInfo("sales force home page is opened");
			
		
		
	}
@Test

public static void accountcreate() throws InterruptedException {
	
	logindetails_all();
	WebElement account_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[5]/a"));
	
	Actions action = new Actions(driver);
	action.moveToElement(account_tab).build().perform();
	account_tab.click();
	
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	Thread.sleep(10000);
	
	
	
	WebElement scanEle =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[3]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")));
	
	action.moveToElement(scanEle).click().build().perform();
	
	
	
	//Creating account 

	Thread.sleep(1000);
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/input[1]")).sendKeys("new data");
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[6]/td[2]/span/select"));
	Select select =  new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[6]/td[2]/span/select")));

	select.selectByVisibleText("Technology Partner");
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[7]/table/tbody/tr[1]/td[2]/span/select"));
	Select select_priority = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[7]/table/tbody/tr[1]/td[2]/span/select")));
	select_priority.selectByVisibleText("High");
	
	
/*	WebElement save_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
	action.moveToElement(save_btn).build().perform();
	save_btn.click();*/
	Thread.sleep(10000);
	
	
	WebElement save_btn =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]")));
	
	action.moveToElement(save_btn).click().build().perform();
	logger.info("account is created");
	
	
	driver.close();
	
	
	
	
}
@Test

public static void create_new_view() throws InterruptedException {
	logindetails_all();
	
	WebElement account_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[5]/a"));
	
	Actions action = new Actions(driver);
	action.moveToElement(account_tab).build().perform();
	account_tab.click();
	
	Thread.sleep(10000);
	
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]")).click();
	//view name
	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/input")).sendKeys("viewdata5");
	//view unique name
 	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/input")).sendKeys("viewdata5");
	//save button
	
	Thread.sleep(1000);
    WebElement save_btn =new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[3]/table/tbody/tr/td[2]/input[1]")));
	
	action.moveToElement(save_btn).click().build().perform();
	
	//save_btn.click();
	
	System.out.println("View page is created");
	logger.info("View page is created");
	
	driver.close();
	
	
}
@Test

public static void view_page() throws InterruptedException {
	logindetails_all();
	WebElement account_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/nav/ul/li[5]/a"));
	
	Actions action = new Actions(driver);
	action.moveToElement(account_tab).build().perform();
	account_tab.click();
	
	Thread.sleep(10000);
	WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
	action.moveToElement(close_tab).build().perform();
	close_tab.click();
	
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select"));
	Select select =  new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select")));
	
	select.selectByVisibleText("viewdata3");
	Thread.sleep(1000);
	
	
	 WebElement save_btn =new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/form/div[1]/div/div[1]/a[1]")));
		
		action.moveToElement(save_btn).click().build().perform();
		
	//	save_btn.click();
	
     WebElement view_name = 	driver.findElement(By.xpath("//input[@id='fname']"));
	
	view_name.clear();
	view_name.sendKeys("changed");
	
	//field
	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[2]/div[2]/table[2]/tbody/tr[2]/td[2]/select"));
	
	Select select_filed =  new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[2]/div[2]/table[2]/tbody/tr[2]/td[2]/select")));

	select_filed.selectByVisibleText("Account Name");
	
	
	//
	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[2]/div[2]/table[2]/tbody/tr[2]/td[3]/select"));
	Select select_opreator =  new Select(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[2]/div[2]/table[2]/tbody/tr[2]/td[3]/select")));

	select_opreator.selectByVisibleText("contains");
	
	driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[2]/div[2]/div[2]/table[2]/tbody/tr[2]/td[4]/input")).sendKeys("a");
	
	//save button
	 WebElement save_btn1 =new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]")));
		
		action.moveToElement(save_btn1).click().build().perform();
	//save_btn1.click();
		logger.info("View page method is completed");
	
	driver.close();
	
	
}

	public static void main(String[] args) throws InterruptedException {
		accountcreate();
		create_new_view();
		view_page();

	}

}
