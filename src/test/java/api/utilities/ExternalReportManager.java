package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExternalReportManager implements ITestListener 

{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testcontext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-report-"+timeStamp+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("RestAssuredAutomattionProject");
		sparkReporter.config().setReportName("pet store user API");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "per store user API");
		extent.setSystemInfo("Operating system", System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getenv("user.name"));
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","shilpa");
	}
	 public void onTestSuccess(ITestResult result)
	 {
		 test=extent.createTest(result.getName());
		 test.assignCategory(result.getMethod().getAfterGroups());
		 test.createNode(result.getName());
		 test.log(Status.PASS, "Test Passed");
	 }
	
	 public void onTestFailure(ITestResult result)
	 {
		 test=extent.createTest(result.getName());
		 test.createNode(result.getName());
		 test.assignCategory(result.getMethod().getAfterGroups());
		 test.log(Status.FAIL, "Test Failed");
		 test.log(Status.FAIL, result.getThrowable().getMessage());
	 }
	
	 public void onTestSkipped(ITestResult result)
	 {
		 test=extent.createTest(result.getName());
		 test.createNode(result.getName());
		 test.assignCategory(result.getMethod().getAfterGroups());
		 test.log(Status.SKIP, "Test Skipped");
		 test.log(Status.SKIP, result.getThrowable().getMessage());
	 }
	 
	 public void onFinish(ITestContext testContext)
	 {
		extent.flush();
	 }
	
}
