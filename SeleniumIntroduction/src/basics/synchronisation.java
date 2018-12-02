package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		driver.get("https://alaskatrips.poweredbygps.com");
		
		driver.findElement(By.xpath("//*[@id='tab-hotel-tab']")).click();
		driver.findElement(By.xpath("//*[@id='hotel-destination']")).sendKeys("nyc");
		driver.findElement(By.xpath("//*[@id='hotel-destination']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='hotel-checkin']")).sendKeys(Keys.ENTER);
		
		WebDriverWait d = new WebDriverWait(driver, 20);
//		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='7883']/div[2]/div/a")));
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='7883']/div[2]/div/a")));
		driver.findElement(By.xpath("//*[@id='7883']/div[2]/div/a")).click();
	}

}
