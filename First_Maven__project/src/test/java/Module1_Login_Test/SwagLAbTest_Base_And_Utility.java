package Module1_Login_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabLoginPage;
import Module2_Order.SwagLabHomePage;
import Module3_Menu.SwagLabOpneMenuPage;

public class SwagLAbTest_Base_And_Utility extends BaseClass
{
	SwagLabLoginPage login; // datatype objectname
	SwagLabHomePage home;
	SwagLabOpneMenuPage menu;
	int TCID;

	
	@BeforeClass
	public void m() throws EncryptedDocumentException, IOException
	{
		
		openBrowser() ;
		 login= new SwagLabLoginPage(m);
		 home= new SwagLabHomePage(m);
		 menu= new SwagLabOpneMenuPage(m);
		
		 
	}
	@BeforeMethod
	public void logininApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageUserName(UtilityClass.getData(0, 0));
		login.inpSwagLabLoginPagePassword(UtilityClass.getData(0, 1));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
	}
	@Test
	public void verifylogo() throws InterruptedException
	{
		TCID=101;
		home.clickSwagLabHomePageADDtoCartButn();;
		boolean actResult =home.getSwaglabHomelogo();
		Assert.assertTrue(actResult,"failed: get false test case is failed ");
		
	}
	
	@AfterMethod
	public void logoutfromApp(ITestResult s1) throws InterruptedException, IOException
	{
		
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenShot(m, TCID);
		}
		home.clickSwagLabHomePageOpenMenuopt();;
		menu.clickswagLabMenuPageLogoutbutn();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
	}

}
