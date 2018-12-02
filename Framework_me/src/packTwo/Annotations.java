package packTwo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeMethod
	public void UserIDGeneration(){
		System.out.println("Userid Generation before every test method");
	}
	
	@AfterMethod
	public void UserIDeletion(){
		System.out.println("Userid Deletion after every test method");
	}
	
	@BeforeTest
	public void ClearCookies(){
		System.out.println("Clearing Cookies before test run");
	}
	
	@AfterTest
	public void CookiesClosed(){
		System.out.println("Clearing Cookies after test run");
	}
	
	@Test
	public void OpeningBrowser(){
		System.out.println("Opening Browser");
	}
			
	@Test (groups = ("Priority1"))
	@Parameters(("adminUserid"))
	
	public void FlightBooking(String Userid){
		System.out.println("Flight Booking 1 for:");
		System.out.println(Userid);
	}

}
