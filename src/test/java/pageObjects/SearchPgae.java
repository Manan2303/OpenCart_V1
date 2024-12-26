package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPgae extends BasePage{

	public SearchPgae(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	// Locator
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search_box;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement search_btn;
	
	@FindBy(xpath ="//body[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	WebElement Pro1;
	
	@FindBy(xpath ="//button[@id='button-cart']")
	WebElement Cart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement success_Alert;
	
	// Methods 
	
	public void search_item() {
		search_box.sendKeys("Mac");;
	}
	
	public void srch_btn() {
		search_btn.click();
	}
	
	public void sel_item() {
		Pro1.click();
		
	}
	
	public void addCart() {
		Cart.click();
		
	}
	
	public boolean successAddCart() {
		
		return success_Alert.getText() != null;
		}
		

}
