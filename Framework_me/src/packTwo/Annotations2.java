package packTwo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations2 {
	
	@BeforeSuite
	public void InstallSoftware() {
		System.out.println("Installing Software");
	}
	
	@Test
	public void TestSoftware() {
		System.out.println("Testing Software");
	}
	
	@AfterSuite
	public void UninstallSoftware() {
		System.out.println("Uninstalling Software");
	}

}
