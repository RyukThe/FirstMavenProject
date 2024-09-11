package Module2_Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="(//button[text()='Add to cart'])[1]") private WebElement ADD2cart;
	@FindBy(xpath= "(//button[text()='Remove'])[1]") private WebElement Remove;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement menu;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement A_z;

	
	public SwagLabHomePage(WebDriver driver) 
	{
	
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSwaglabHomelogo()
	{
		boolean result = logo.isDisplayed();
		return result;
	}
	

	
	public void clickSwagLabHomePageADDtoCartButn()
	{
		ADD2cart.click();
	}
	
	public String getswaglabhomepageremovebutton()
	{
		String actText = Remove.getText();
		return actText;
	}



	public void clickSwagLabHomePageOpenMenuopt()
	{
		menu.click();
	}
	
	public WebElement A_z()
	{
		WebElement list = A_z;
		 return list;
	}
}

