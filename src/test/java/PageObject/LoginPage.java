package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;


//import com.sun.tools.javac.util.Assert;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	public WebElement LoginBtn;
	
	
	@FindBy(linkText = "Logout")
	public WebElement logout;
	
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnLogOutButton()
	{
		logout.click();
	}
	
	public boolean  LogoutButtonVisibility(WebDriver driver)
	{
		try
		{
			boolean testResult = logout.isDisplayed();
			//System.out.println("Logout button is visible");
			return testResult;	
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to locate logout button");
			 Assert.fail("Exception arised, hence faililing this test..." + e.getMessage());
		        return false; // Just to satisfy compiler
		        
		}
		finally
		{
			System.out.println("Finally block code is executed");
			//driver.quit();
		}
		
	}
}