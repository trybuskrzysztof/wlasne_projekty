package sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class sample {
		
	@Test
	public void testing(){
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ebay.com");
		System.out.println(driver.getTitle());
	}
}
