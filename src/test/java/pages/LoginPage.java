package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	
	WebDriver driver;

	@FindBy(xpath = ".//a[@data-twg-id ='header-login-desktop']")
	WebElement btnSignIn;
	
	@FindBy(xpath = ".//a[@data-twg-id ='header-login-desktop']//span")
	WebElement lblSignIn;
	
	@FindBy(xpath = ".//input[contains(@id,'dwfrm_login_username')]")
	WebElement txtUserName;
	
	@FindBy(id = "dwfrm_login_password")
	WebElement txtPassword;
	
	@FindBy(name = "dwfrm_login_login")
	WebElement btnLogin;
	
	@FindBy(xpath = ".//a[@title='Log Out' and @data-twg-id='header-logout-desktop'] ")
	WebElement lnkLogOut;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void verifyHomepage() {
		Assert.assertEquals(lblSignIn.getText(), "Sign In");
	}
	
	public void clickSignIn() {
		btnSignIn.click();
		
	}
	
	public void enterUserName(String Username) {
		txtUserName.sendKeys(Username);
		
	}
	
	public void enterPassword(String Password) {
		txtPassword.sendKeys(Password);
		
	}
	
	public void clickLogin() {
		btnLogin.click();
		
	}
	
	public void verifyLogin() {
		Assert.assertTrue(lnkLogOut.isDisplayed());
		
	}
	
}
