package testngFiles;

import java.io.IOException;

import org.testng.annotations.Test;

public class DependenyAnnot extends TestBase{
	
	@Test
	public void OpeningBrowser() throws IOException
	{
	//This opens the Browser
		Login();
	System.out.println("Executing opening Browser");

}
@Test(dependsOnMethods={"OpeningBrowser"},alwaysRun=true )
public void FlightBooking() throws IOException
{
	Login();
	System.out.println("Executing Flightbooking");
}
@Test(timeOut=45000)
public void Timerelated()
{
//This opens the Browser
System.out.println("New Testcase");

}
@Test(enabled=false)
public void Payment()
{
//This opens the Browser
System.out.println("New Testcase");

}


}
