package packTwo;

import org.testng.annotations.Test;

public class DependencyAnnot {
	
	@Test
	public void OpeningBrowser(){
		System.out.println("Executing Opening Browser");
	}
	
	@Test (dependsOnMethods=("OpeningBrowser"))
	public void FlightBooking(){
		System.out.println("Executing Flight Booking");
	}
	
	@Test (timeOut=5000)
	public void TimeRelated(){
		System.out.println("Checking time performance");
	}
	
	@Test (enabled=false)
	public void Payment(){
		System.out.println("Executing Performing Payment");
	}

}
