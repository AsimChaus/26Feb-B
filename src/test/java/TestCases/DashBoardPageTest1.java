package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase1;
import Pages.DashBoardPage1;
import Pages.LogInPage1;

public class DashBoardPageTest1 extends TestBase1 {
	LogInPage1 logIn;
	DashBoardPage1 dash;
	@BeforeMethod
	public void startup() throws IOException {
		initialisation();
	    logIn = new LogInPage1();
	    dash = new DashBoardPage1();
	}
	
	@Test
	public void verifyUserFullNameTest() throws InterruptedException, IOException {
		logIn.logIntoApp();
		String value = dash.verifyUserFullName();
		Assert.assertEquals(value, "Asim Mirasahab Chaus");
	}
	

	@Test
	public void verifyEmailIdTest() throws InterruptedException, IOException {
		logIn.logIntoApp();
		String value = dash.verifyEmailId();
		
		Assert.assertEquals(value, "asimc456@gmail.com");
	}
	
	@Test
	public void placeGTTOrderTest() throws InterruptedException, EncryptedDocumentException, IOException {
		logIn.logIntoApp();
		dash.placeGTTOrder();
	}
	
	
	@AfterMethod
	
	public void exit() {
		driver.quit();
	}
	//hi upadated file

}
