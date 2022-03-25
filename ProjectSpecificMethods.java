package week5.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelGeneric;

public class ProjectSpecificMethods 
{
	public RemoteWebDriver driver;
	String excelFilePath;
	
	@Parameters ({"URL","BROWSER_NAME"})
	@BeforeMethod 
	public void beforeMethod(String url, String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod 
	public void afterMethod()
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
