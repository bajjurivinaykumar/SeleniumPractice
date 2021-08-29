
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.testng.IInvokedMethod;
//import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import PageObjects.BaseClass;

public class TestListener implements ITestListener/* ,IInvokedMethodListener*/ {
	
	public static ExtentSparkReporter htmlReporter;
    public static ExtentTest test;
    public static ExtentReports report;
    SimpleDateFormat timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss");
    
    //Executes before starting first Test
    @Override
    public void onStart(ITestContext testContext)
    {    	
    	String repName = "Test-Report" + timeStamp.format(new Date()) +".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+ repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Test Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);		
    }
    
  //Executes after completing all tests
    @Override
    public void onFinish(ITestContext testContext)
    {
    	report.flush();
    }
    
    //Executes when test Fails  
    @Override
    public void onTestFailure(ITestResult testResult) 
    {
       	test = report.createTest(testResult.getName());
    	test.log(Status.FAIL,MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));
   		captureScreenshot(testResult,test);    	
    }
    
    //Capturing screenshot 
    public void captureScreenshot(ITestResult testResult, ExtentTest test)
    {
    	String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+testResult.getName()+"_"+timeStamp.format(new Date())+".png";
		File source = new File(screenshotPath);
    	 try {
    	        source = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
    	        FileUtils.copyFile(source, new File (screenshotPath));
    	        test.addScreenCaptureFromPath(screenshotPath);
       	    } 
    	 catch (IOException e) {
    	        e.printStackTrace();
    	    } 
    }

    //Executes when test Skipped 
    @Override
    public void onTestSkipped(ITestResult testResult)
    {
    	test=report.createTest(testResult.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(testResult.getName(),ExtentColor.ORANGE));
		captureScreenshot(testResult,test);
    }
    
    //Executes when test Passes
    @Override
    public void onTestSuccess(ITestResult testResult)
    {
    	test = report.createTest(testResult.getName());
    	test.log(Status.PASS,MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
    	captureScreenshot(testResult,test);
    }
	

}
