package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class simpleSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.seleniumhq.org/");
		driver.findElement(By.xpath("//*[@id='menu_download']/a")).click();
		WebElement selversion = driver.findElement(By.xpath("//*[@id='mainContent']/table[1]/tbody/tr[1]/td[2]"));
		System.out.println(selversion.getText());

	}

}
