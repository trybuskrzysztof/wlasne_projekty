package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class WebsiteTraining {
	
	static String textToSelect = "babydoll";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://ebay.com");
		Select select = new Select(driver.findElement(By.id("gh-cat")));
		select.selectByIndex(3);
		
		WebDriverWait wd = new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("ba");
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-id-4']")));
		driver.findElement(By.xpath("//*[@id='ui-id-4']")).click();

		
	}
	
}
