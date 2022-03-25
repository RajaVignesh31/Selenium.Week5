package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass
{
	@Test
	public void deleteIncident() throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("Raja@1985");
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		//4. Search for the existing incident and navigate into the incident
		 // 4.1. Search the existing incidents
		 driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4 Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //4.3 Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		//5. Delete the incident
		 driver.findElement(By.id("sysverb_delete_bottom")).click(); 
		 Thread.sleep(2000);
		 
		 //5.1. Confirm Delete 
		 driver.findElement(By.id("ok_button")).click();
		 Thread.sleep(2000);
		 
		//6. Verify the deleted incident
		 String text = driver.findElement(By.xpath("//td[@colspan='13']")).getText();
		 System.out.println(text);
		 
		 if(text.contains("No records to display"))
		 {
			 System.out.println("Incident deleted successfully");
		 }
		 else
		 {
			 System.out.println("Incident not deleted successfully");
		 }
	}
}

