package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase1;

public class LogInPage1 extends TestBase1 {

	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy (xpath = "//input[@type='text']") private WebElement userIdTxtBox;
	@FindBy (xpath = "//input[@type='password']") private WebElement passTxtBox;
	@FindBy (xpath = "//button[@type='submit']") private WebElement logInBttn;
	@FindBy (xpath = "//input[@type='password']") private WebElement pinTxtBox;
	@FindBy (xpath = "//button[@type='submit']") private WebElement continueBttn;
	@FindBy (xpath = "//span[@class='nickname']") private WebElement nickname;
	
	
	public LogInPage1() {
		
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyKiteLogo1() {
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo1() {
		return zerodhaLogo.isDisplayed();
	}
	
	public String logIntoApp () throws InterruptedException, IOException {
		userIdTxtBox.sendKeys(getproperty("user"));
		Thread.sleep(2000);
		passTxtBox.sendKeys(getproperty("password"));
		Thread.sleep(2000);
		logInBttn.click();
		Thread.sleep(2000);
		pinTxtBox.sendKeys(getproperty("pin"));
		Thread.sleep(2000);
		continueBttn.click();
		Thread.sleep(2000);
		return nickname.getText();
		
		
	}
	
}
