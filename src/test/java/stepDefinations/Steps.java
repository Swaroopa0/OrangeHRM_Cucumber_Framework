package stepDefinations;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageobjects.OrangeLoginPage;

public class Steps {
	WebDriver driver;
	OrangeLoginPage lp;
	Logger logger;
	
	ResourceBundle rb; // for reading properties file
	String br;    //to store browser name
	
	
	@Before
   public void setup()
   {
	   logger=LogManager.getLogger(this.getClass());
	   rb=ResourceBundle.getBundle("config");
	   br=rb.getString("browser");
	   
	   
   }
	
	@After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
       driver.quit();
    }
	
	@Given("User launch Browser")
	public void user_launch_browser() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		if(br.equals("chrome"))
        {
           driver=new ChromeDriver(options);
        }
        else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("opens URL {string}")
	public void opens_url(String urol) {
		driver.get(urol);
		logger.info("user launched browser succesfully");
		driver.manage().window().maximize();
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		
		lp=new OrangeLoginPage(driver);
		lp.setusername(username);
		logger.info("user e4nters username succesfully");
		lp.setpassword(password);
		logger.info("user enyters password succesfully");
		
	}

	@When("click on loginButton")
	public void click_on_login_button() {

		lp.clickLogin();
		logger.info("user clicked login succesfully");
	}

	@Then("user navigates to Dashboard")
	public void user_navigates_to_dashboard() {
		WebElement act_title=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		String exp_title="Dashboard";
		
		if(act_title.equals(exp_title))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}

	
	}

}
