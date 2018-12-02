package basics;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ebay.com");
		
		int linksize = driver.findElements(By.tagName("a")).size();
		System.out.println("There are " + linksize + " links on the webpage");
		
		WebElement footer = driver.findElement(By.xpath("//*[@id='glbfooter']"));
		int footerlinksize = footer.findElements(By.tagName("a")).size();
		System.out.println("There are " + footerlinksize + " links in the footer");
		
		String collinkscss = "#gf-BIG > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > ul:nth-child(1)";
		WebElement collinks = driver.findElement(By.cssSelector(collinkscss));
		int collinkssize = collinks.findElements(By.tagName("a")).size();
		System.out.println("There are " + collinkssize + " links in the second column");
		
		String beforeclicking = null;
		String afterclicking;
		
		for(int i=0; i<collinkssize; i++)
		{
			System.out.println(collinks.findElements(By.tagName("a")).get(i).getText());
			if(collinks.findElements(By.tagName("a")).get(i).getText().contains("Site map"))
			{
				beforeclicking = driver.getTitle();
				collinks.findElements(By.tagName("a")).get(i).click();
				break;
				
			}
		}
		afterclicking = driver.getTitle();
//		Assert.assertNotEquals();
		if(beforeclicking!=afterclicking)
		{
			boolean abc = driver.findElement(By.xpath("//*[@id='myebay']/div[2]/ul/li[1]/a")).isDisplayed();
			if(abc==true)
			{
			System.out.println("PASS");
			}
		}
		else
		{
			System.out.println("FAIL");
		}

	}

}
