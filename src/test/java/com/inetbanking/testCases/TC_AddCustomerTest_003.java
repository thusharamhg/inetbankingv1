package com.inetbanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);	
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		
		logger.info("Providing customer details...");
		
		addcust.custName("Thush");  
		logger.info("1");
		
		addcust.custgender();  
		logger.info("2");
		
		addcust.custdob("10", "13", "1988");  
		logger.info("3");
		
		Thread.sleep(3000);
		addcust.custaddress("Sri Lanka");
		logger.info("4");
		
		addcust.custcity("Maharagama");
		logger.info("5");
		
		addcust.custstate("COLOMBO");
		logger.info("6");
		
		addcust.custpinno("5000074");
		logger.info("7");
		
		addcust.custtelephoneno("0718048519");
		logger.info("8");
		
		String email = randomestring()+"@gmail.com";    //randomestring() coming from base class common method
		addcust.custemailid(email);
		logger.info("9");
		
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		
		logger.info("Assert Validation Started...");
		//Assertion - According to this lecturer we need to keep the assertion inside the test case, not in the page object class (AddCustomerPage)
		boolean res = driver.getPageSource().contains("Register");  //Customer Registered Successfully!!!
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case 003 Passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test Case 003 Failed");
		}
	}
	
	
	
	


}
