
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class alert {

	static WebDriver driver;
	
		
	public static void main(String[] args)
	{
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	WebDriverWait wait = new WebDriverWait(driver, 10);
	driver.findElement(By.name("cusid")).sendKeys("123");

	driver.findElement(By.name("submit")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	driver.quit();
	
	}
}

