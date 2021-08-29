
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;



public class mouseandkeyboard {

	static WebDriver driver;
	
	
	
	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://test3i.campsystems.com");

	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement txtUsername = driver.findElement(By.name("txtUserID"));
	txtUsername.clear();
	WebElement txtPassword = driver.findElement(By.name("txtPassword"));
	txtPassword.clear();
	
	Actions builder = new Actions(driver);
	Action seriesOfActions = builder
		.moveToElement(txtUsername)
		.click()
		.sendKeys(txtUsername, "vinay0761")
		.doubleClick(txtUsername)
		.contextClick()
		.build();
		
	seriesOfActions.perform() ;

	Action seriesOfActions1 = builder
			.moveToElement(txtPassword)
			.click()
			.keyDown(txtPassword, Keys.SHIFT)
			.sendKeys(txtPassword, "test")
			.keyUp(txtPassword, Keys.SHIFT)
			.doubleClick(txtPassword)
			.contextClick()
			.build();
			
	seriesOfActions1.perform() ;
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	
	driver.quit();
		
	
	
	}
}

