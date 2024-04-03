
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		
		try
		{
		logger.info("**** starting Tc_001_AccountRegistrationtest.......*****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on MyAccount link ******");
		
		hp.clickRegister();
		logger.info("***** Clicked on registration link ******");
		
		logger.info("***** Entering customer details *****");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
//		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
//		regpage.setConfirmPassword(password);
		
		Thread.sleep(5000);
		
		regpage.setPrivacyPolicy();
		logger.info("***** Clicked on privacy ******");
		
		
	
		
		regpage.clickContinue();
		logger.info("***** Clicked on continue ******");
		
		String confmsg=regpage.getConfirmationMsg();
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("***** TC__001 finished ******");
	
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("test passed.....");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("test failed.....");
			Assert.fail();
		}
		
		}
		
		catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
	}
	
	
	
	
}