package BraveBroswer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Class1 
{
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\daduk\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
	ChromeOptions op= new ChromeOptions();
	op.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
	
	WebDriver driver= new ChromeDriver(op);
	driver.get("https://www.flipkart.com/");
	}
	

}
