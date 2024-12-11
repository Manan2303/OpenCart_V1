package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

 public class BasePage {
	
	
	WebDriver driver; // instance function  
	//Constructor
	
	
	 public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

}
