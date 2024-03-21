package flexiquiztests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestsRun {
	
	static WebDriver driver;
	static String nameofCurrMethod = new Throwable() 
			.getStackTrace()[0] 
			.getMethodName(); 

	public static void loginWithCorrectEmailCorrectPassword() 
	{
		driver.findElement(By.cssSelector("#UserName")).clear();
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(MyApplicationConstants.USER_NAME);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys(MyApplicationConstants.PASSOWRD);
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		
		try 
		{	driver.findElement(By.cssSelector("div[id='userLogOut'] span")).getText();
			System.out.println("Test Verified");
			
		} catch (Exception e) 
		{
			System.out.println("Test Not Verified");
		}
		
		
	}
	public static void loginWithWrongMailCorrectPassword() 
	{
		driver.findElement(By.cssSelector("#UserName")).clear();
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(MyApplicationConstants.WRONG_USER_NAME);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys(MyApplicationConstants.PASSOWRD);
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		String error_message = "The user name or password provided is incorrect.";
		String message = driver.findElement(By.xpath("//li[normalize-space()='The user name or password provided is incorrect.']")).getText();
		validate(error_message, message);
	}
	public static void loginWithCorrectMailWrongPassword() 
	{
		driver.findElement(By.cssSelector("#UserName")).clear();
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(MyApplicationConstants.USER_NAME);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys(MyApplicationConstants.WRONG_PASSOWRD);
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		String error_message = "The user name or password provided is incorrect.";
		String message = driver.findElement(By.xpath("//li[normalize-space()='The user name or password provided is incorrect.']")).getText();
		validate(error_message, message);
	}
	public static void loginWithWrongUsernameAndWrongPassword() 
	{
		driver.findElement(By.cssSelector("#UserName")).sendKeys(MyApplicationConstants.WRONG_USER_NAME);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys(MyApplicationConstants.WRONG_PASSOWRD);
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		String error_message = "The user name or password provided is incorrect.";
		String message = driver.findElement(By.xpath("//li[normalize-space()='The user name or password provided is incorrect.']")).getText();
		validate(error_message, message);
	}
	public static void loginWithPasswordButNoEmail() 
	{
		driver.findElement(By.cssSelector("#UserName")).clear();
		driver.findElement(By.cssSelector("#Password")).sendKeys(MyApplicationConstants.PASSOWRD);
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		String error_message = "The Email / Username field is required.";
		String message = driver.findElement(By.xpath("//div[@id='userNameValidationMessage']")).getText();
		validate(error_message, message);
	}
	public static void validate(String error_message, String message) 
	{
			
		if(error_message.equals(message))
		{
			System.out.println("Pass"+" "+ nameofCurrMethod);
		}
		else {
			System.out.println("Fail"+" "+ nameofCurrMethod);
		}
	}
	public static void loginWithEmailButNoPassword() 
	{
		driver.findElement(By.cssSelector("#UserName")).sendKeys(MyApplicationConstants.USER_NAME);
		driver.findElement(By.cssSelector("#Password")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='loginNow']")).click();
		String error_message = "The Password field is required.";
		String message = driver.findElement(By.cssSelector("#passwordValidationMessage")).getText();
		validate(message, error_message);
	}
	public static void loginWithEmptyFeilds()
	{
		driver.findElement(By.cssSelector("#loginNow")).click();	
		String error_message = "The Email / Username field is required.";
		String message = driver.findElement(By.id("userNameValidationMessage")).getText();
		validate(message, error_message);
	}
	public static void main(String[] args)  
	{
		driver = new FlexiQuizBasicOperation().OpenBrowser();
		driver.findElement(By.cssSelector("#fq-main-menu-auth")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
				
		loginWithEmptyFeilds();
		loginWithEmailButNoPassword();
		loginWithPasswordButNoEmail();
		loginWithWrongUsernameAndWrongPassword();
		loginWithCorrectMailWrongPassword();
		loginWithCorrectMailWrongPassword();
		loginWithCorrectEmailCorrectPassword();
	}

}
