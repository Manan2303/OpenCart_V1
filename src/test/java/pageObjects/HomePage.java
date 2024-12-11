package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locatord
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement Accountlink;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register_link;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Login']")
	WebElement login_link;
	
	// Action Mthods 
	public void MyAccount() {
		Accountlink.click();
	}

	public void registration() {
		Register_link.click();
	}
	
	public void login() {
		login_link.click();
	}
	
}
