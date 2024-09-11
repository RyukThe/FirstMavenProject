package LibraryFiles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManeger implements ITestListener
{
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public String reportName;
	
	
	
	public void onTestStart(ITestResult result)
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName= "Test-Report"+timeStamp;
		spark= new ExtentSparkReporter("D:\\eclipse\\First_Maven__project\\FailedTestCaseSS\\"+reportName);
		spark.config().setDocumentTitle("Automation Test Result");
		spark.config().setReportName("First Maven Project ");
		spark.config().setTheme(Theme.STANDARD);
		
		
		extent= new ExtentReports();
		extent.attachReporter( spark);
		try {
			extent.setSystemInfo("Application", UtilityClass.getDataFromProFile("URL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.setSystemInfo("Operating Systme",System.getProperty("os.name"));
		new BaseClass();
		Capabilities cap = ((RemoteWebDriver)BaseClass.m).getCapabilities();
		extent.setSystemInfo("Browser Name", cap.getBrowserName());
		extent.setSystemInfo("Browser Version", cap.getBrowserVersion());
		extent.setSystemInfo("User", "Saurav");
		extent.setSystemInfo("Java Version ", System.getProperty("java.version"));
		extent.setSystemInfo("Environment", "SIT");
		
		
		
		
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getTestName());
		test.assignAuthor("Saurav");
		test.pass("Pass");
		test.log(Status.PASS, "Test Case Passed!!!");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		test= extent.createTest(result.getName());
	
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Cases  Failed");
		test.generateLog(Status.FAIL, "Test Case Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		
		try {
			String imgpath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Case Skipped ");
		
	}



	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}
