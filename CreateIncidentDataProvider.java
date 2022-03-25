package week5.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIncidentDataProvider extends BaseClass
{
	@BeforeTest
	public void SetData()
	{
		excelFilePath = "./TestData/ServiceNow/tc001.xlsx";
	}
	
	@Test(dataProvider = "Dynamic_Data")
	public void createIncident(String userName, String password, String filterIncident, String description) throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys(userName);
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys(password);
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys(filterIncident,Keys.ENTER);
		 
		//4. Click on Create new option and fill the mandatory fields
		 //4.1. Click on create new option
		 driver.findElement(By.xpath("//div[text()='Create New']")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);
		  
		 //4.3. Select a value for Caller from another window list
		 driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		 
		 // Switch to new window
		 driver.switchTo().window(windowHandlesList.get(1));
		 Thread.sleep(2000);
		 
		 //4.4. Select a value for Caller 
		 driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		 
		 // Switch back to old window and frame
		 driver.switchTo().window(windowHandlesList.get(0));
		 driver.switchTo().frame(0);
		 Thread.sleep(2000);
		 
		 //4.5. Enter value for short_description
		 driver.findElement(By.xpath("//input[@aria-label = 'Short description']")).sendKeys(description);
		 		 
		 //4.6. Read the incident number and save it a variable
		 String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		 System.out.println("Number: "+ text);
		 
		 //4.7. Click on Submit button
		 driver.findElement(By.id("sysverb_insert_bottom")).click();
		 Thread.sleep(2000);
		 
		//5. Verify the newly created incident
		 //5.1. Search the same incident number in the next search screen
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(text,Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.2. Verify the incident is created successful
		 String text2 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		 
		 if(text.equals(text2))
		 {
			 System.out.println("Incident is created successfully");
			 incident = text2;
		 }
		 else
		 {
			 System.out.println("Incident is not created successfully");
		 }	 
	}
}
