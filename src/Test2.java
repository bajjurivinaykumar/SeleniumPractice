
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;


public class Test2 {

	static WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public static void main(String[] args)
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	Test2 obj = new Test2();
	System.out.print("Hi");
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/newtours/index.php");
	
	obj.Login();
	obj.NavigateToFlights();
	obj.SelectFlights();
	obj.BackToHome();
	obj.closeBrowser();
	
		
    }
	
	public void Login()
	{
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),\"Login Success\")]")));
	 }
	
	public void NavigateToFlights()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Flights\"]")));
		driver.findElement(By.xpath("//a[text()=\"Flights\"]")).click();
		 
	}
	
	public void SelectFlights()
	{
		 if((driver.getCurrentUrl()).contains("reservation.php"))
		    {
		    	System.out.print("Navigated to Flights Page");
		    	driver.findElement(By.xpath("//input[@value=\"oneway\"]")).click();
		    	Select passenger = new Select(driver.findElement(By.xpath("//select[@name=\"passCount\"]")));
		    	passenger.selectByVisibleText("3");
		    	Select fromAirport = new Select(driver.findElement(By.xpath("//select[@name=\"fromPort\"]")));
		    	fromAirport.selectByValue("New York");
		    	Select fromMonth = new Select(driver.findElement(By.xpath("//select[@name=\"fromMonth\"]")));
		    	fromMonth.selectByValue("8");
		    	Select toAirport = new Select(driver.findElement(By.xpath("//select[@name=\"toPort\"]")));
		    	toAirport.selectByIndex(2);
		    	driver.findElement(By.xpath("//input[@value=\"Business\"]")).click();
		    	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	driver.findElement(By.xpath("//input[@name=\"findFlights\"]")).click();
		    	
		    	
		    }
		
	}
	
	public void BackToHome()
	{
		if((driver.getCurrentUrl()).contains("reservation2.php"))
	    {
			driver.findElement(By.cssSelector("img[src*=\"images/home.gif\"]")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}

