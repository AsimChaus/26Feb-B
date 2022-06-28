package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase1 {
	public String getproperty(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\asimc\\eclipse-workspace\\FrameworkZerrodha\\src\\main\\java\\Config\\Config.properties");
	    prop.load(file);
	    return prop.getProperty(value);
	
	}
	public static WebDriver driver;
	public void initialisation() throws IOException {
		String browserName = getproperty("browser"); 
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(o);
		
		} else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(getproperty("url"));
	}
	
	public String readExcelData(int i,int j) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\asimc\\eclipse-workspace\\FrameworkZerrodha\\Testdata\\Testdata1.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(i).getCell(j).getStringCellValue();
		return value;
	}

}
