package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPgae;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC_Seach_Product extends BaseClass{
	
	
	@Test
	public void searchtest() {
		try {
	
		// Access home page
		HomePage home =new HomePage(driver);
		home.MyAccount();
		home.login();
		
		// Access login page 
		
		loginPage login= new loginPage(driver);
		login.setemail(pr.getProperty("email"));
		login.setpass(pr.getProperty("pass"));
		
		login.lg_btn();
		
		
		// access search
		
		SearchPgae srch_page = new SearchPgae(driver);
		srch_page.search_item();
		srch_page.srch_btn();
		srch_page.sel_item();
		srch_page.addCart();
		srch_page.successAddCart();
		
		boolean target = srch_page.successAddCart();
		
		System.out.println(target);
		
		Assert.assertEquals(target,true, "Success: You have added MacBook to your shopping cart!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		

	}
	

	
}
