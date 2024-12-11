package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// Locator 
	
	@FindBy(xpath= "//input[@id='input-email']")
	WebElement txt_email;
	
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement password;
	
	
	@FindBy(xpath= "//input[@value='Login\']")
	WebElement login_btn;
	
	
	// Actions Mehods 
	
	public void setemail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setpass(String pass) {
		password.sendKeys(pass);
	}
	
	public void lg_btn() {
		login_btn.click();
	}
	
	public String getmail_id() {
		return txt_email.getAttribute("value");
		
	}
	
	
	

}
