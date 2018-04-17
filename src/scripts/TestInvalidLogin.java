package scripts;
import org.testng.annotations.Test;
import generics.BaseTest;
import generics.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest {
	@Test
	public void testInvalidLogin() throws InterruptedException{
		LoginPage lp = new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		for (int i = 1; i <=rowCount; i++) {
			String un = Lib.getCellValue("InvalidLogin", i, 0);
			lp.setUsername(un);
			Thread.sleep(2000);
			String pwd = Lib.getCellValue("InvalidLogin", i, 1);
			lp.setPassword(pwd);
			Thread.sleep(2000);
			lp.clickLogin();
		}
	}
}
