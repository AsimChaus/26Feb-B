package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase1;

public class DashBoardPage1 extends TestBase1 {

	@FindBy(xpath ="//span[@class='user-id']") private WebElement menuButtn;
	@FindBy(xpath ="//h4[@class='username']") private WebElement userFullNameText;
	@FindBy(xpath ="//div[@class='email']") private WebElement emailIdText;
	@FindBy(xpath ="//button[text()='Start investing ']") private WebElement startInvestingBlueButtn;
	@FindBy(xpath ="(//input[@type='text'])[2]") private WebElement serachBox;
	@FindBy(xpath ="//span[@class='tradingsymbol']") private WebElement suggestionInMenu;
	@FindBy(xpath ="//button[text()='Create GTT ']") private WebElement createGTTButtn;
	@FindBy(xpath ="//input[@label='Trigger price']") private WebElement triggerPriceTxtBox;
	@FindBy(xpath ="//input[@label='Qty.']") private WebElement qtyTxtBox;
	@FindBy(xpath ="//input[@label='Price']") private WebElement priceTxtBox;
	@FindBy(xpath ="//button[@class='button-outline cancel']") private WebElement cancelButtn;
	
	public DashBoardPage1() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUserFullName() throws InterruptedException {
		menuButtn.click();
		Thread.sleep(2000);
		return userFullNameText.getText();
	}
	
	public String verifyEmailId() throws InterruptedException {
		menuButtn.click();
		Thread.sleep(2000);
		return emailIdText.getText();
	}
	public void placeGTTOrder() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		startInvestingBlueButtn.click();
		Thread.sleep(2000);
		serachBox.sendKeys(readExcelData(0, 0));
		Thread.sleep(2000);
		suggestionInMenu.click();
		Thread.sleep(2000);
		createGTTButtn.click();
		Thread.sleep(2000);
		triggerPriceTxtBox.clear();
		triggerPriceTxtBox.sendKeys(readExcelData(0, 1));
		Thread.sleep(2000);
		qtyTxtBox.clear();
		qtyTxtBox.sendKeys(readExcelData(0, 2));
		Thread.sleep(2000);
		priceTxtBox.clear();
		priceTxtBox.sendKeys(readExcelData(0, 3));
		Thread.sleep(2000);
		cancelButtn.click();
	}	
}
