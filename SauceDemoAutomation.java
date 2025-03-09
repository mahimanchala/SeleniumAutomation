package testClass;

import org.testng.annotations.Test;

import pageClass.BaseClass;

public class SauceDemoAutomation extends BaseClass{
	
	@Test
	public void login() throws Throwable
	{
		loginPage.userLogin();
	}
	
	@Test
	public void checkoutProduct() throws Throwable
	{
		loginPage.userLogin();
		homePage.addDeleteProd();
		homePage.checkoutProcess();
	}

}
