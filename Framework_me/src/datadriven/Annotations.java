package datadriven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeMethod
	public void UserIDGeneration(){
		System.out.println("Userid Generation before every test method");
	}
	
	@Test (dataProvider="getData")
	public void Userid(String username, String password, String id){
		System.out.println("This block executes before each Test");
		System.out.println(username);
		System.out.println(password);
		System.out.println(id);
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
	
	@Test
	public void FlightBooking(){
		System.out.println("Flight Booking");
	}
	
	@DataProvider
	public Object[][] getData()
	{
//		i stands for number of times testcase should run (3)
//		j stands for number of parameters it should send for one go (2)
		Object[][] data = new Object[3][3];
		data[0][0]="user1";
		data[0][1]="pass1";
		data[0][2]="id1";
		
		data[1][0]="user2";
		data[1][1]="pass2";
		data[1][2]="id2";
		
		data[2][0]="user3";
		data[2][1]="pass3";
		data[2][2]="id3";
		return data;
	}
	

}
