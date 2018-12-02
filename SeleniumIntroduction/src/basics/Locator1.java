package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("qaclickacadaemy");
		driver.findElement(By.name("pass")).sendKeys("12345");
		
		//customised xpath:
		driver.findElement(By.xpath("//input[@value='Log in']"));
//		driver.findElement(By.partialLinkText("Forgot")).click();
//		driver.findElement(By.linkText("Forgot your account?")).click();
//		driver.findElement(By.xpath(".//*[@id='u_0_t']")).click();

		/*
		driver.get("http://qaclickacademy.com");
		driver.findElement(By.xpath("//*[@id='newsletter']/div[2]/div[3]/a")).click();
		*/
	}

}
