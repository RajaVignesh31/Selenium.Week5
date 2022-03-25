package week5.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelGeneric;

public class BaseClass 
{
	public static String incident;
	public RemoteWebDriver driver;
	public String excelFilePath;
	
	@Parameters ({"URL"})
	@BeforeMethod
	public void preCondition(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@DataProvider(name = "Dynamic_Data")
	public String[][] testData() throws IOException
	{
		String data[][] = ReadExcelGeneric.getData(excelFilePath);
		return data;
	}
}
