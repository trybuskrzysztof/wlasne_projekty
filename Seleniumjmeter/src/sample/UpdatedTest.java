package sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class UpdatedTest {
	
	@Test
	
	public void testing(){
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://ebay.com");
		System.out.println(driver.getTitle());
		
	}

}
