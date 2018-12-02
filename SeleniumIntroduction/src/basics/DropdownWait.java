package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://fantasycricket.dream11.com/in/");
		
		WebDriverWait wd = new WebDriverWait(driver,5);
		driver.findElement(By.xpath("//*[@id='m_rtxtEmail1']")).sendKeys("aa");
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='m_frmRegister']/div[1]/ul")));
		driver.findElement(By.xpath("//*[@id='m_frmRegister']/div[1]/ul")).click();
	}
}
