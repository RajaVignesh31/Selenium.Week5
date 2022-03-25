package week5.assignments;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Attributes 
{
	int count = 0;
	@Test
	public void tc01()
	{
		System.out.println("Test Anotation");
		System.out.println(count++);
	}
	
	@Test(invocationCount=10)
	public void tc02()
	{
		System.out.println("Test Anotation - Invocation Count 10");
		System.out.println(count++);
	}
	
	@Test(invocationCount=10, threadPoolSize = 5)
	public void tc03()
	{
		System.out.println("Test Anotation - Invocation Count 10, ThreadPoolSize 5");
		System.out.println(count++);
	}
	
	@Test(invocationCount=10, invocationTimeOut=3000)
	public void tc04()
	{
		System.out.println("Test Anotation - Invocation Count 10, Invocation TimeOut 3000");
		System.out.println(count++);
	}
	
	@Test(invocationCount=10, timeOut=1000)
	public void tc05()
	{
		System.out.println("Test Anotation - Invocation Count 10, TimeOut 1000");
		System.out.println(count++);
	}
	
	@Test(priority = -1)
	public void tc06()
	{
		System.out.println("Test Anotation - Priority -1");
		System.out.println(count++);
	}
	
	@Test(enabled = false)
	public void tc07()
	{
		System.out.println("Test Anotation - Enabled false");
		System.out.println(count++);
	}
	
	@Ignore
	@Test
	public void tc08()
	{
		System.out.println("Test Anotation, Ignore Annotation");
		System.out.println(count++);
	}
	
	@Test(dependsOnMethods= {"week5.assignments.Attributes.tc01"})
	public void tc09()
	{
		System.out.println("Test Anotation - DependsOnMethods tc01");
		System.out.println(count++);
	}
	
	@Test(dependsOnMethods= {"week5.assignments.Attributes.tc09"}, alwaysRun=true)
	public void tc10()
	{
		System.out.println("Test Anotation - DependsOnMethods tc09, AlwaysRun True");
		System.out.println(count++);
	}	
}
