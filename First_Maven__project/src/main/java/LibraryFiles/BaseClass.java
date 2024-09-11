package LibraryFiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class BaseClass 
{
	public ChromeOptions op;
	
	public static WebDriver m;
	
	public void openBrowser() throws IOException
	{
		op= new ChromeOptions();

		op.addArguments("--remote-allow-origins=*");
		m=new  ChromeDriver(op);
		m.manage().window().maximize();
		m.get(UtilityClass.getDataFromProFile("URL"));
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	
	
	
	public String captureScreen(String testName) throws IOException
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
		File src = ((TakesScreenshot)m).getScreenshotAs(OutputType.FILE);
		String des= "D:\\eclipse\\First_Maven__project\\FailedTestCaseSS"+timestamp+"-"+testName+".png";
		
		FileHandler.copy(src, new File(des));
		
		return des;
	
	}
	
	
	

}
