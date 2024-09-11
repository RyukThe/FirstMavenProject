package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabLoginPage;
import Module2_Order.SwagLabHomePage;
import Module3_Menu.SwagLabOpneMenuPage;

public class Classtest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpneMenuPage menu;
	@Test
	public void m() throws EncryptedDocumentException, IOException, InterruptedException
	{
		openBrowser();
		login.inpSwagLabLoginPageUserName(UtilityClass.getData(0, 0));
		login.inpSwagLabLoginPagePassword(UtilityClass.getData(0, 1));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
		
		
	}
	

}
