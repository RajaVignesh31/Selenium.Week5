package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass
{
	@Test
	public void updateIncident() throws InterruptedException
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
		 
		//4. Search for the existing incident and click on the incident
		 // 4.1. Search the existing incidents
		 driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4. Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 Thread.sleep(2000);
		 
		//4.3. Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 Thread.sleep(2000);
		 
		//5. Update the incidents with Urgency as High and State as In Progress
		 //5.1. Update the incidents with Urgency as High 
		 
		 Select dd1 = new Select(driver.findElement(By.id("incident.urgency")));
		 dd1.selectByValue("1");
		 Thread.sleep(2000);
		 
		 //5.2. State as In Progress
		 Select dd2 = new Select(driver.findElement(By.id("incident.state")));
		 dd2.selectByValue("2");
		 Thread.sleep(2000);
		 
		 //5.3. Work notes
		 driver.findElement(By.xpath("(//textarea[@placeholder='Work notes'])[1]")).sendKeys("Incident Update");
		  
		 //5.4. Click Update
		 driver.findElement(By.id("sysverb_update_bottom")).click();
		 Thread.sleep(2000);
		 
		 //5.5. Search the same incident number in the next search screen
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.6. Click on incident 
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 Thread.sleep(2000);
		 
		//6. Verify the priority and state
		 //6.1. Verify the urgency
		 String urgency = driver.findElement(By.xpath("//select[@name='incident.urgency']/option[@selected='SELECTED']")).getText();
		 if(urgency.contains("High"))
		 {
			 System.out.println("Urgency is : " + urgency);
		 }
		 else
		 {
			 System.out.println("Urgency is not : High");
		 }
		 
		//6.2. Verify the state
		 String state = driver.findElement(By.xpath("//select[@name='incident.state']/option[@selected='SELECTED']")).getText();
		 if(state.contains("Progress"))
		 {
			 System.out.println("State is : " + state);
		 }
		 else
		 {
			 System.out.println("State is not : In Progress");
		 }
	}
}
