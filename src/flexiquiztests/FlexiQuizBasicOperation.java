package flexiquiztests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlexiQuizBasicOperation 
{
	public WebDriver OpenBrowser () 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get(MyApplicationConstants.URL);
		
		driver.manage().window().maximize();
		
		return driver;
		
	}
}
