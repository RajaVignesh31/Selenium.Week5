package week5.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadLeaftaps extends ProjectSpecificMethods
{
	@BeforeTest
	public void setData()
	{
		excelFilePath = "./TestData/Leaftaps/tc001.xlsx";
	}
	
	@Test(dataProvider = "Dynamic_Data")
	public void run01_CreateLead(String userName, String password, String companyName, String firstName, String lastName)
	{
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.name("submitButton")).click();
	}
}
