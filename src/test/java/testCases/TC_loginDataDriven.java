package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.dataProvider;

public class TC_loginDataDriven extends BaseClass {

	@Test(dataProvider = "LoginData",dataProviderClass =dataProvider.class, groups    = "dataDriven") // excess data from dataprovider class 
	// if dataprovider is in different class then we user dataProvider Class variable is used
	public void loginDDT(String email,String pass, String exp_result) throws InterruptedException {
		try {
			//Homepage 
			HomePage home = new HomePage(driver);		
			home.MyAccount();		
			home.login();

			//Login Page

			loginPage lg = new loginPage(driver);		
			lg.setemail(email);		// this email and password fetch into excel sheet with the help of dataprovider method.
			lg.setpass(pass);		
			lg.lg_btn();
			

		

			// My account page 
			MyAccountPage my_acc =new MyAccountPage(driver);
			boolean target = my_acc.MyAccount();
			System.out.println(target + " 999999999999999999");
			if(exp_result.equalsIgnoreCase("Valid"))
			{
				if(target==true)
				{

					Assert.assertTrue(true);
					my_acc.logout();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(exp_result.equalsIgnoreCase("Invalid"))
			{
				if(target==true)
				{
					my_acc.logout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}


			}

		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("An exception occurred: " + e.getMessage());
			Thread.sleep(3000);
		}
	}
}



