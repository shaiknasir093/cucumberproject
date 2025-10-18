package StepDefinition;

import java.io.File;
import StepDefinition.log;   // custom log wrapper
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginstepdef extends BaseClass {

    @BeforeAll
    public static void clearScreenshots() {
        File folder = new File("C:\\Users\\HP\\eclipse-workspace\\CucumberFramework1\\Screenshots");
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) file.delete();
            }
        }
        log.info("🧹 Cleared all old screenshots before test run");
    }

    @Before
    public void driver_setup() {
        launch_chrome_browser();
        log.info("🌐 Chrome browser launched and WebDriver initialized");
    }

    @Given("User launches chrome browser")
    public void User_launches_chrome_browser() {
        loginPg = new LoginPage(driver);
        driver.manage().window().maximize();
        log.info("🖥️ Chrome browser window maximized");
    }

    @Given("User launches edge browser")
    public void User_launches_edge_browser() {
        launch_edge_browser();
        log.info("🌐 Edge browser launched and WebDriver initialized");
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        log.info("🔗 Opened application URL: " + url);
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String emailadd, String password) {
        loginPg.enterEmail(emailadd);
        log.info("📧 Entered Email: " + emailadd);

        loginPg.enterPassword(password);
        log.info("🔑 Entered Password"+password);
    }

    @And("Click on Login")
    public void click_on_login() {
        loginPg.clickOnLoginButton();
        log.info("➡️ Clicked on Login button");
    }
  

    @And("wait for five seconds")
    public void wait_for_five_seconds() throws InterruptedException 
    {
      waitForPresence(loginPg.logout, 50);
      
    }




    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
            log.info("✅ Page title matched. Expected: " + expectedTitle+", Actual: " + actualTitle);
        } else {
            log.warn("❌ Page title mismatch. Expected: " + expectedTitle + ", Actual: " + actualTitle);

            Assert.assertTrue(false);
        }
    }

    @Then("check if user is loggedin")
    public void check_if_user_is_loggedin() {
        loginPg.LogoutButtonVisibility(driver);
        log.info("👤 Verified user is logged in (Logout button visible)");
    }

    @And("close browser")
    public void close_browser() {
        driver.quit();
        log.info("🛑 Browser closed successfully");
    }
    
    @AfterStep
    public void FailureScreenshot(Scenario sc)
    {
    	if(sc.isFailed())
    	{
    		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        	sc.attach(screenshot, "image/png", sc.getName());
    	}
    	
    }

    @After
    public void tear_down(Scenario sc) {
//        if (sc.isFailed() && driver != null) {
//            String testName = sc.getName();
//            failure_screenshot(testName);
//            log.error("📸 Scenario failed: " + testName + " → Screenshot captured");
//            
//        }
        if (driver != null) {
            driver.quit();
            driver = null;
            log.info("🔄 WebDriver instance closed after scenario: " + sc.getName());
        }
    }
}
