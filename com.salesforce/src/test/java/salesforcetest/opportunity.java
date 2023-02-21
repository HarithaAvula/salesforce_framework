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


public class opportunity extends BaseTest{
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
			
			logger.info("logined into salesforce");
	}
	@Test
	
	public static void 	opportunity_test() throws InterruptedException {
		
		 logindetails();
		 WebElement opp_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[6]/a"));
			Actions action = new Actions(driver);
			action.moveToElement(opp_tab).build().perform();
			opp_tab.click();
			System.out.println("opportunity tab is opened");
			logger.info("opportunity tab is opened");
			Thread.sleep(10000);
			WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
			action.moveToElement(close_tab).build().perform();
			close_tab.click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//select[@id='fcf']"));
			Select opp_tab_details = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		
			
			List<WebElement> details = opp_tab_details.getOptions();
			
			
			
			for(WebElement e:details) {
				
				System.out.println(e.getText());
				logger.error(e.getText());
			}
			
			driver.close();
		 
		
	}
	@Test
	
	public static void opportunity_create() throws InterruptedException {
		logindetails();
		WebElement opp_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[6]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(opp_tab).build().perform();
		opp_tab.click();
		System.out.println("opportunity tab is opened");
		logger.info("opportunity tab is opened");
		
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		Thread.sleep(2000);
		
		
		WebElement new_btn = driver.findElement(By.name("new"));
		action.moveToElement(new_btn).build().perform();
		new_btn.click();
		Thread.sleep(1000);
		System.out.println("new button is clicked");
		//opp name 
		driver.findElement(By.id("opp3")).sendKeys("phone case");
		//ammount
		driver.findElement(By.id("opp7")).sendKeys("$450000");
		//date
		driver.findElement(By.id("opp9")).sendKeys("2/7/2023");
		//camping name
		
		driver.findElement(By.id("opp17")).sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");
		
		//lead source
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[6]/td[2]/span/select"));
		
		Select lead_source = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[6]/td[2]/span/select")));
		
		lead_source.selectByVisibleText("Web");
		//stage
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[4]/td[4]/div/span/select"));
        Select stage = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[4]/td[4]/div/span/select")));
		
		stage.selectByVisibleText("Prospecting");
		
		
		WebElement save_btn = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
		action.moveToElement(save_btn).build().perform();
		save_btn.click();
		
		System.out.println("opportunity is created");
		logger.info("opportunity is created");
		driver.close();
		
		
	}
	@Test
	
	public static void opportunity_pipeline() throws InterruptedException {
		logindetails();
		
		WebElement opp_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[6]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(opp_tab).build().perform();
		opp_tab.click();
		System.out.println("opportunity tab is opened");
		logger.info("opportunity tab is opened");
		
		
		Thread.sleep(10000);
		//WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[0]/div/a"));
		
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		Thread.sleep(2000);
		
		WebElement pipeline = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		action.moveToElement(pipeline).build().perform();
		pipeline.click();
		System.out.println("Opportunity pipeline is displayed");
		logger.info("Opportunity pipeline is displayed");
		
		driver.close();
		
		
	}
	@Test
	
	public static void opportunity_struck() throws InterruptedException {
		
		logindetails();
		WebElement opp_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[6]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(opp_tab).build().perform();
		opp_tab.click();
		System.out.println("opportunity tab is opened");
		logger.info("opportunity is created");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		Thread.sleep(2000);
		
		WebElement struck = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		action.moveToElement(struck).build().perform();
		struck.click();
		System.out.println("Opportunity struck is displayed");
		logger.info("Opportunity struck is displayed");
		
		driver.close();
		
	}
	@Test
	
	public static void Quartily_summary() throws InterruptedException {
		logindetails();
		WebElement opp_tab = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[6]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(opp_tab).build().perform();
		opp_tab.click();
		System.out.println("opportunity tab is opened");
		logger.info("opportunity is created");
		Thread.sleep(10000);
		WebElement close_tab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a"));
		action.moveToElement(close_tab).build().perform();
		close_tab.click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[1]/td/select"));
        Select interval = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[1]/td/select")));
		
		interval.selectByVisibleText("Current and Next FQ");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[2]/td/select"));
        Select include = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[2]/td/select")));
		
		include.selectByVisibleText("Open Opportunities");
		
		WebElement run_report = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[3]/td/input"));
		action.moveToElement(run_report).build().perform();
		run_report.click();
		
		System.out.println("reports are displayed");
		logger.info("reports are displayed");
		driver.close();
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		opportunity_test();
		opportunity_create();
		
		opportunity_pipeline();
		opportunity_struck();
		Quartily_summary();
		
	}

}
