
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class iframe {

	static WebDriver driver;  //threadlocal
	
	
	
	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/guru99home/");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("a077aa5e")));
	
	List<WebElement> elements = driver.findElements(By.tagName("a"));
	if (elements.size()== 1)
	{
		elements.get(0).click();
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		driver.quit();
		
	}
		
	
	
	}
	

	 public void captureScreenshot()
	    {
		    SimpleDateFormat timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss");

	    	String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+timeStamp.format(new Date())+".png";
			File source = new File(screenshotPath);
	    	 try {
	    	        source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	        FileUtils.copyFile(source, new File (screenshotPath));
	    	       
	       	    } 
	    	 catch (IOException e) {
	    	        e.printStackTrace();
	    	    } 
	    }
}

