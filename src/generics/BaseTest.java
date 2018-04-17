package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GEKCO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod
	public void openApplication(){
		driver = new FirefoxDriver();
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		String timeout = Lib.getPropertyValue("ITO");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		
		if (ITestResult.FAILURE== res.getStatus()) {
			Lib.takeScreenshot(driver, res.getName());
			
		}
		driver.close();
	}
}
