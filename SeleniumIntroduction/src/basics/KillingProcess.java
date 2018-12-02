package basics;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;

public class KillingProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WindowsUtils.killByName("notepad.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		Set<Cookie> abc = driver.manage().getCookies();
		System.out.println(abc.size());
		System.out.println(abc + "\n");
		driver.manage().deleteAllCookies();
		Set<Cookie> abcd = driver.manage().getCookies();
		System.out.println(abcd.size());

	}

}
