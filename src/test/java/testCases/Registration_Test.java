package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Registration_POC;
import testBase.BaseClass;

public class Registration_Test extends BaseClass{


	@Test(groups = {"Regression", "Master"})      
	public void Regis_test() throws InterruptedException  {
		// perform home page action
		try {
		logger.info(" ******* Test start ***********");
		HomePage home = new HomePage(driver);
		home.MyAccount();
		
		logger.info("Account link successfully clicked");
		home.registration();
		logger.info("Registration link successfully clicked");

       
		Registration_POC register= new Registration_POC(driver);
		logger.info("Details enter successfully");
		register.setFirstName("Manan kumar");
		register.setLastName("Singh");
		register.setEmail(randomString() + "@gmail.com");
		register.setContact("7985748464");
		register.setpass("123456");
		register.setConfirmaPass("123456");

		Assert.assertEquals(register.getpassword(), register.getconfirmpass() , "Password does not match");
		// validation to check pass and confirm password should same

		register.Setcheck();
		register.confirm();		
		
		logger.info("Validation test case ");
		String cofirrmsg = register.configmessage();

		if (cofirrmsg.equals("Your Account Has Been Created!")){
			Assert.assertTrue(true);
			
//			Assert.assertEquals(cofirrmsg, "Your Account Has Been Created!");
		}
		else {
			 logger.error("Test Failed");
			 logger.debug("test failed");
			 
			 Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
//			logger.error("Test failed: " + e.getMessage());
//			Assert.fail("Test failed: " + e.getMessage());
			Assert.fail();
		}
		logger.info("Test Finish");
		
		
	}
	


}
