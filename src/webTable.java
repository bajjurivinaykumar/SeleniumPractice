
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.*;



public class webTable {

	static WebDriver driver;
	
	@BeforeSuite
	public void before()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");//driver launch
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");//driver quit
	}
	
	@AfterSuite
	public void after()
	{
		System.out.println("After suite");
	}
	
	@Test(priority = 0)
	public void test2()
	{
	 	
	}
	
	@DataProvider(name="webTable")
	public Object[][] dataProvider()
	{
		//object[][] a= {"1","2"};
		return new Object[][] {{"First-Value"}, {"Second-Value"}};
		
	}
	
	@Test(priority = 1,groups= {"smoke","search"},dependsOnMethods = {"test2"},dataProvider = "webTable")
	public  void test1(String name1)
	{
		System.out.println(name1);
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinayb\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/web-table-element.php#");
	String company = "Power Finance Co";

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	List<WebElement> columns = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/thead/tr/th"));
	System.out.println("Columns count: "+columns.size());
	
	List<WebElement>  rows = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr"));
	System.out.println("Rows count: "+rows.size());
	

	List<WebElement>  rows1 = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[1]"));
	
	for (int i = 0; i<rows1.size();i++)
	{
		//if(rows1.get(i).getText() == company)
			//System.out.println(rows1.get(i).getText() );
	}
	
		Assert.assertEquals(false, false,"test"); //message gets displayed when test failed
		SoftAssert obj = new SoftAssert();
		obj.assertEquals(0, 0);
		obj.assertAll();
	}
		
	
	
	}

