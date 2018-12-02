package basics;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class formMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
/*		AddonsTest.addAddons();
 		WebDriver driver = new FirefoxDriver(AddonsTest.firefoxprofile);
*/		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.makemytrip.com/");
		System.out.println("Before clicking on Mutli City radio button");
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id='hp-widget__return']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath(".//*[@id='js-multiCitySearchFrom_1']")).isDisplayed());
		System.out.println("After clicking on Mutli City radio button");
		
		driver.findElement(By.xpath("//*[@id='js-switch__option']/div[3]/label")).click();
		System.out.println(driver.findElement(By.xpath(".//*[@id='js-multiCitySearchFrom_1']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath(".//*[@id='js-multiCitySearchFrom_1']")).isEnabled());
		
		int count = driver.findElements(By.xpath(".//*[@id='js-multiCitySearchFrom_1']")).size();
		if(count==0){
			System.out.println("button is not present in code or webpage");
		}
		else{
			System.out.println("button is present in code or webpage");
		}
		
		System.out.println(driver.findElement(By.xpath(".//*[@id='deals_live_deals']")).getText());
		System.out.println(driver.findElement(By.xpath(".//*[@id='fd-wrap']/div[2]/h2")).getText());		
		
		driver.findElement(By.cssSelector("#hp-widget__depart")).click();
		driver.findElement(By.cssSelector("div.ui-datepicker-inline:nth-child(2) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(4)")).click();
		

	}

}
