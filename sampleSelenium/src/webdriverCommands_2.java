import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverCommands_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demoqa.com/frames-and-windows/");
        driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
        driver.close();

    }
}
