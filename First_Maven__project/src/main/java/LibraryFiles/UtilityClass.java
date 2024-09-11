package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityClass 
{
	
	
	//used to fetch data from excel sheet 
	//need two inputs: 1. rowIndex, 2. cellIndex
	//@Author: Saurav
	public static String getData(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\eclipse\\First_Maven__project\\TestData\\Book1.xlsx");
		String Result = WorkbookFactory.create(file).getSheet("Sheet5").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return Result;
	}
	
	
	//used take screenshot of WebPage
	//need Two inputs: 1. WebDrivername, TCID
	//@Author: Saurav
	public static void captureScreenShot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec=new File("D:\\eclipse\\First_Maven__project\\FailedTestCaseSS\\TCID"+ TCID +".png");
		FileHandler.copy(src, dec);
	}
	
	
	//used to fetch data from property file
	//need one input : String Key
	//@Author name:Saurav
	public static String getDataFromProFile(String key) throws IOException
	{
		FileInputStream m= new FileInputStream("D:\\eclipse\\First_Maven__project\\PropertyFile.properties");
		Properties k= new Properties();
		k.load(m);
		
		String value = k.getProperty(key);
		
		return value;
	}
	
	public void getIntoIframe(WebDriver driver ,int Windowindex)
	{
		Set<String> ids = driver.getWindowHandles();
		
		List<String>aid= new ArrayList<String>(ids);
		String id = aid.get(Windowindex);
		driver.switchTo().window(id);
	}
	
	public static List<String> selectListboxoption(WebElement list,int indexValue)
	{
		Select m= new Select(list);
		m.selectByIndex(indexValue);
		List<WebElement> Alloptions = m.getOptions();
		List<String> Alp= new ArrayList<String>();
		 for(WebElement options: Alloptions)
		 {
			 String optionsAll = options.getText();
			 Alp.add(optionsAll);
		 }
	
		  return Alp;
	}
	
	public static void dropDown(WebDriver driver,WebElement eleme)
	{
		Actions act = new Actions(driver);
		act.click(eleme).perform();
		
		
	}
	
}
