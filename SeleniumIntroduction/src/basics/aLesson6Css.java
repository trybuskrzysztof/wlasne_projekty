package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class aLesson6Css {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("costam");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("costam2");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
/*		
		xpath= //tagname[@attribute='value']				
		Css = tagname[attribute='value']
				div[class='identity first']
*/
	}

}
