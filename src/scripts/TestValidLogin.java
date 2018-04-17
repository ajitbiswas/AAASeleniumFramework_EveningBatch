package scripts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testLogin(){
		
		Logger log = LogManager.getLogger(TestValidLogin.class.getName());
		log.debug("Creating an object of LoginPage pom class");
		LoginPage lp = new LoginPage(driver);
		log.info("Object created successfully");
		//enter username
		log.debug("Fetching the username from excel file");
		String un = Lib.getCellValue("ValidLogin", 1, 0);
		lp.setUsername(un);
		log.info("usernmame successfully enetered");
		//enter password
		String pwd = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(pwd);
		//cklick on login button
		lp.clickLogin();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		String hometitle = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(hometitle, "actiTIME - Enter Time-Track123");
		s.assertAll();
	}
}
