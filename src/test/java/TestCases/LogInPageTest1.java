package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase1;
import Pages.LogInPage1;

public class LogInPageTest1 extends TestBase1 {
	LogInPage1 logIn;
	@BeforeMethod
	public void startup() throws IOException {
	     initialisation();
		logIn = new LogInPage1();
	 
	}
	
	@Test
	public void verifykitelogoTest() {
		boolean act = logIn.verifyKiteLogo1();
		Assert.assertEquals(act, true);
	}
	@Test
	public void verifyzerodhalogoTest() {
		boolean act = logIn.verifyZerodhaLogo1();
		Assert.assertEquals(true, act);
	}
	@Test
	public void logIntoAppTest () throws InterruptedException, IOException {
		String actual = logIn.logIntoApp();
		Assert.assertEquals(actual, "Asim");
	}
	
	@AfterMethod
	public void exit () {
	  driver.quit();
	}

}
