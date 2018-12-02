package fan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class search {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver_win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String fanMainUrl = "http://www.fan.pl/";
        driver.get(fanMainUrl);
        Thread.sleep(3000);

        WebElement polishVersion = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[1]/td[2]/a"));
        polishVersion.click();
        String newurltitle = driver.getTitle();
        System.out.println(newurltitle);
        Thread.sleep(3000);

        WebElement searchform = driver.findElement(By.name("simple"));
        searchform.sendKeys("bathor");
        Select kategoria = new Select(driver.findElement(By.name("simplech")));
        kategoria.selectByVisibleText("Wykonawca");

        WebElement fraza = driver.findElement(By.name("fraza"));
        if(fraza.isSelected()){
            System.out.println("Fraza jest zaznaczona");
        } else {
            fraza.click();
        }

        WebElement dalej = driver.findElement(By.name("Submit"));
        dalej.click();
        Thread.sleep(3000);

     //   driver.navigate().back();

     //   polishVersion.click();
     //   driver.switchTo().frame(driver.findElement(By.cssSelector("body > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(15) > td:nth-child(1) > form:nth-child(1) > div:nth-child(1) > input:nth-child(1)")));
        WebElement searchform2 = driver.findElement(By.name("simple"));
        searchform2.sendKeys("bathory");
        WebElement dalej2 = driver.findElement(By.name("Submit"));
        dalej2.click();

    }
}
