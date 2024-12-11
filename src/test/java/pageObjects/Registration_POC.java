package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_POC extends BasePage {

	public Registration_POC(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	// locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;


	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtphn;

	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txtpass;

	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtConfirm_pass;



	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_checkbox;


	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnConfirm;


	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirm;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);

	}

	public void setLastName(String Lname) {
		txtLastName.sendKeys(Lname);

	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);

	}
	public void setpass(String pass) {
		txtpass.sendKeys(pass);

	}
	public void setConfirmaPass(String pass) {
		txtConfirm_pass.sendKeys(pass);

	}

	// to get value of pass
	public String getpassword() {
		return txtpass.getAttribute("value");

	}
	// to get value of confirm pass 
	public String getconfirmpass() {
		return txtConfirm_pass.getAttribute("value");

	}
	public void Setcheck() {
		chk_checkbox.click();;

	}
	public void confirm() {
		btnConfirm.click();

	}
	public void setContact(String contact) {
		txtphn.sendKeys(contact);

	}

	public String configmessage() {
		try
		{
			return(msgconfirm.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}

}