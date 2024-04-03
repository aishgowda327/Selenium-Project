package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"sanity","master"})
	public void verify_login() 
	{
		logger.info("**** Starting TC_002_LoginTest ****");
		logger.debug("capturing application debug logs....");
		
		try {
	    
	   //Home Page
	    HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    logger.info("Clicked on myAccount link...");
	    
	    Thread.sleep(5000);
	    logger.info("Clicking on login link...");
	    hp.clickLogin();//login link under myAccount
	    
	    logger.info("Clicked on login link under myAccount...");
	    
	    //Login page
	    

	    LoginPage lp = new LoginPage(driver);
	    logger.info("Entering valid email and password..");
	    lp.setEmail(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    
	    Thread.sleep(5000);
	    lp.clickLogin();//login button
	    logger.info("clicked on login button");
	    
	    
	    //validating MyAccount page
	    MyAccountPage macc = new MyAccountPage(driver);
	    boolean target_page = macc.isMyAccountPageExists();
	     
	    if(target_page == true)
	    {
	    	logger.info("Login test passed...");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	logger.error("Login test failed");
	    	Assert.fail();
	    	
	    }
		}
		
		
		catch(Exception e) 
		{
		  Assert.fail();	
		}
		
		
	    logger.info("***** Finished TC_002_LoginTest ****");
	   
	    
	    
	}
	

}
