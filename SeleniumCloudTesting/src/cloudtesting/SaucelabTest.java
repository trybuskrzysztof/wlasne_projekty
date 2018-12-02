package cloudtesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaucelabTest {
	
	@Test
	
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("version", "5");
		dc.setCapability("platform", "XP");
		
		WebDriver driver = new RemoteWebDriver (
				new URL("http://trybuskrzysztof:d8fbd938-420d-472c-bc42-3aa550bac307@ondemand.saucelabs.com:80/wd/hub"),dc);
		
		driver.get("http://ebay.com");
		System.out.println(driver.getTitle());
				
		
	} // http://saucelabid:Accesskey@ondemand.saucelabs.com:80/wd/hub
	

}
