package basics;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;

public class TakingScreenshot {

	public static void main(String[] args) throws IOException {
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
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\trybusk\\Desktop\\screenshot.png"));

	}

}
