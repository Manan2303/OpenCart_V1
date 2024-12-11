package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class login_test extends BaseClass {
	@Test(groups = {"Sanity","Master"})
	public void Login_TC() throws InterruptedException {
		try {
		logger.info(" ******* Test start ***********");
		// access home page throughD
		HomePage home = new HomePage(driver);
		logger.info("Access Homepage ");
		home.MyAccount();
		logger.info("Account link click successfully ");
		home.login();
		logger.info("Login link click successfully ");
		
		
		loginPage lg = new loginPage(driver);
		
		lg.setemail(pr.getProperty("email"));
		logger.info("Email enterred successfully");
		lg.setpass(pr.getProperty("pass"));
		logger.info("Enter password ");
		lg.lg_btn();
		logger.info("Button click successfully ");
		
		Thread.sleep(5000);
		
		// My account page 
		MyAccountPage my_acc =new MyAccountPage(driver);
		boolean target = my_acc.MyAccount();
		System.out.println(target);
		logger.error("Test Failled expected mail not matched");
		Assert.assertEquals(target,true,"Text Mismatched");
		}
		catch(Exception e){
			Assert.fail();
			
		}
		
		logger.info("*******Test finished*******");
		
	
		
	}
	  
	

}
