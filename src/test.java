
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.generic.Select;
public class test {

	public static void main(String[] args)
	{
	System.out.print("Hi");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver  = new ChromeDriver();
	driver.switchTo().defaultContent();
	
	InternetExplorerOptions options = new InternetExplorerOptions();
	options.introduceFlakinessByIgnoringSecurityDomains();
	
	
	driver.switchTo().window(null);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://www.google.com");
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
	// click on the compose button as soo
	ExpectedConditions.fr
	
	Wait wait = new FluentWait(WebDriver reference)
	.withTimeout(timeout, SECONDS)
	.pollingEvery(timeout, SECONDS)
	.ignoring(Exception.class);
	
	driver.findElement(By.name("q")).sendKeys("selenium");
	driver.findElement(By.xpath("//input[@value='Google Search']")).click();
	driver.findElement(By.linkText("Gmail")).click();
	
	org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(driver.findElement(By.name("PassCount")));	
	select.selectByVisibleText(null)
	select.selectByValue(null)
	select.selectByIndex(0)
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	// frames  -- http://demo.guru99.com/test/guru99home/ 
	driver.switchTo().frame("a077aa5e");
	driver.switchTo().frame(driver.findElement(By.className("")));
	driver.switchTo().defaultContent(); //use
	driver.switchTo().parentFrame();
	
	//windows -- http://demo.guru99.com/popup.php
	
	String parent = driver.getWindowHandle();
	Set<String> list = driver.getWindowHandles();
	list
	
	close() --only browser
	quit() -- all browser inst close
	
	driver.switchTo().alert();
	ExpectedConditions.alertIsPresent();
	
	Actions action = new Actions(driver);
	
	Action act = action.clickAndHold().build();
	act.perform();
	
	Actions builder = new Actions(driver);
	Action seriesOfActions = builder
		.moveToElement(txtUsername)
		.click()
		.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.doubleClick(txtUsername)
		.contextClick()
		.build();
		
	seriesOfActions.perform() ;
	
	
	
	
	
	
	
	
	
	
    }
}

