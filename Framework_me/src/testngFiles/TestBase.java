package testngFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {
	
	public WebDriver driver = null;
	
	@Test
	public void InstallSoftware() {
		System.out.println("Installing Software");
	}
	
	@Test
	public void Login() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\trybusk\\workspace\\Framework\\src\\testngFiles\\datadriver.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.18.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		System.out.println(prop.getProperty("username"));
//		driver.findElement(By.xpath:"").sendkeys(Username);
	}
	
	@Test
	public void TestSoftware() {
		System.out.println("Testing Software");
	}
	
	@AfterSuite
	public void UninstallSoftware() {
		System.out.println("Uninstalling Software");
	}

}
