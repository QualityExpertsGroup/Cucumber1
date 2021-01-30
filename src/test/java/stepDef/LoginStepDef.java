package stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginStepDef {
	WebDriver driver;
	LoginPage lp;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.thewarehouse.co.nz/");
	}
	
	@Given("I am on the Home Page")
	public void i_am_on_the_home_page() {		
		lp = new LoginPage(driver);
		lp.verifyHomepage();
	  
	}

	@When("I enter my {string} and {string}")
	public void i_enter_my_and(String Username, String Password) {
		lp.clickSignIn();
		lp.enterUserName(Username);
		lp.enterPassword(Password);
		lp.clickLogin();
	}

	@Then("I should see the MyAccount page")
	public void i_should_see_the_my_account_page() {
		lp.verifyLogin();
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
