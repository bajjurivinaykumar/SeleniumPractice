package pageclass;
import org.openqa.selenium.*;

public class LoginPage extends BasePage {
	
	FindBy[How = how.css, using = By.id("username")]
	private WebElement username; 
	
	FindBy[How = how.css, using = By.id("password")]
			private WebElement password; 

	FindBy[How = how.css, using = By.id("Loginbutton")]
			private WebElement OK; 
	
	FindBy[How = how.css, using = By.id("Loginbutton")]
			private WebElement Cancel; 
	
	public Loginpage(WebDriver driver)
	{
		pageFactory.initElements(this.class, driver);
	}
	
	public void clickOk()
	{
		HighLightelement(username);
		username.sendKeys(password);
		
		OK.click();
		if (driver.getCurrentUrl() == "home page")
		{
					
		}
		else
		{
			
		}
	}
	
	data[][] 
			
	public void Search(String name, String city) {
		if (data[0].name == "")
		{
			username.sendKeys(data.name);
		}
		
		if (data[0].city == "")
		{
			Selct select =new select(elemetn);
			selectbyVisibleText(name);
		}
		searchbutton.click()
		
	}
	
public Homepage EnterCredentials(username, password)
{
	HighLightelement(username);
	username.sendKeys(password);
	
	OK.click();
	if (driver.getCurrentUrl() == "home page")
	{
				
	}
	else
	{
		
	}
	
}



}
