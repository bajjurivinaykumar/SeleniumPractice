
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;



public class windowHandling {

	static WebDriver driver;
	
	
	
	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/popup.php");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	String parent = driver.getWindowHandle();
	driver.findElement(By.linkText("Click Here")).click();
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	while(it.hasNext())
	{
		String child = it.next();
		if (child != parent)
		{
			driver.switchTo().window(child);
			System.out.println(driver.getTitle());
		}
	
		
	}

	
	
	driver.close();
	driver.switchTo().window(parent);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
		
	
	
	}
}

