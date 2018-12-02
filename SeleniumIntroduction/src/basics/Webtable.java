package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C://geckodriver-v0.17.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.iupui.edu/~webtrain/tutorials/tables.html");
		
		WebElement table = driver.findElement(By.xpath("html/body/div[4]/table"));
		
		List<WebElement>noofrows = table.findElements(By.tagName("tr"));
		System.out.println("there are " + noofrows.size() + " rows in the table");
		
		int i = 0;
		for(WebElement eachrow:noofrows)
		{
			
			List<WebElement>eachcolumn = eachrow.findElements(By.tagName("td"));
			i++;
			System.out.println("Number of columns in " + i + "th row are " + eachcolumn.size());
			for(WebElement text:eachcolumn)
			{
				String celltext = text.getText();
				
				if(celltext.equals(" ") || celltext.equals("") || celltext.isEmpty()){
					System.out.println("(no cell content)");
				}
				else {
					System.out.println(celltext);
				}
			}
		}

	}

}
