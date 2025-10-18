package StepDefinition;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.*;







public class BaseClass extends log {
	public WebDriver driver;
	public LoginPage loginPg;
	//public static java.util.logging.Logger log;
	//public log testlog = new log();
	
	


	// Launch Chrome browser
	public void launch_chrome_browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
	}

	// Launch Firefox browser
	public void launch_firefox_browser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		loginPg = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	// Launch Edge browser
	public void launch_edge_browser() 
	{
		//WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		loginPg = new LoginPage(driver);
		driver.manage().window().maximize();
	}
	
	public void waitForPresence(WebElement element, int timeoutInSeconds) {
		try 
		{
			log.info("Waiting for element visibility");
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			    wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch( Exception e)
		{
			log.warn("Exception arrised as explicit wait time is elapsed and element is invisble");
			e.printStackTrace();
		}
	    
	    
	}

	
	//screenshot capture for failed scenario
	public void failure_screenshot(String scenarioname)
	{
		
	  

	            // Safe scenario name
	            String testName = scenarioname;

	            // Example data from tags
//	            String exampleData = sc.getSourceTagNames().toString().replaceAll("[^a-zA-Z0-9_-]", "_");

	            // Timestamp
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());

	            // Screenshot path
	            String screenshotPath = "C:\\Users\\HP\\eclipse-workspace\\CucumberFramework1\\Screenshots\\"
	                    + testName + "_" + "_" + timestamp + ".png";

	            try {
	                // Only attempt screenshot if driver session is still valid
	                
	                    TakesScreenshot ts = (TakesScreenshot) driver;
	                    File source = ts.getScreenshotAs(OutputType.FILE);

	                    File destination = new File(screenshotPath);
	                    destination.getParentFile().mkdirs();

	                    FileUtils.copyFile(source, destination);
	                    System.out.println("****📸 Screenshot saved:**** " + destination.getName());
	                    
	                
	            } 
	            catch (Exception e) {
	                System.out.println("❌ Exception while saving screenshot: " + e.getMessage());
	            }
	

}
	}

