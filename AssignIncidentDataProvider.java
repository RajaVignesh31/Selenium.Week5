package week5.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssignIncidentDataProvider extends BaseClass
{
	@BeforeTest
	public void SetData()
	{
		excelFilePath = "./TestData/ServiceNow/tc003.xlsx";
	}
	
	@Test(dataProvider = "Dynamic_Data")
	public void assignIncident(String userName, String password, String filterIncident, String software, String workNote) throws InterruptedException
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
		 
		//4. click on open and Search for the existing incident and click on  the incident
		 //4.1 click on open
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4 Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //4.3 Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		//5. Assign the incident to  Software group
		 driver.findElement(By.name("lookup.incident.assignment_group")).click();
		 
		 Thread.sleep(3000);
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<String> (windowHandles);
		 
		 // Switch to new window
		 driver.switchTo().window(windowHandlesList.get(1));
		 Thread.sleep(4000);
		 
		 //5.1. Search for Software
		 driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(software, Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.2. Click on Software
		 driver.findElement(By.xpath("//a[text()='Software']")).click();
		 Thread.sleep(2000);
		 
		 // Switch back to old window and frame
		 driver.switchTo().window(windowHandlesList.get(0));
		 driver.switchTo().frame(0);
		 Thread.sleep(2000);
		 
		 //6. Update the incident with Work Notes 
		 driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(workNote);
		 Thread.sleep(2000);
		 
		//7. Verify the Assignment group and Assigned for the incident
		 //7.1. Click Update
		 driver.findElement(By.id("sysverb_update_bottom")).click();
		 Thread.sleep(2000);

		 //7.2. Search Incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //7.3. Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		 //7.4 Verify the Assignment group
		 String text = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		 System.out.println(text);
		 
		 if(text.contains("Software"))
		 {
			 System.out.println("Assignment group verified successfully");
		 }
		 else
		 {
			 System.out.println("Assignment group not verified successfully");
		 }
		 
		 String text2 = driver.findElement(By.xpath("(//span[@class='sn-widget-textblock-body sn-widget-textblock-body_formatted'])[1]")).getText();
		 System.out.println(text2);
		 
		 if(text2.contains("Incident"))
		 {
			 System.out.println("Work Notes verified successfully");
		 }
		 else
		 {
			 System.out.println("Work Notes not verified successfully");
		 }
	}
}
