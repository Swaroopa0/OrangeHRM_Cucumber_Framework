package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class OrangeLoginPage extends OrangeBasepage{

	public OrangeLoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(name="username")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	//Actions
	public void setusername(String username)
	{
	txtusername.sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	


}
