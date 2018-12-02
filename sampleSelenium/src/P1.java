import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1 {

    public static void main(String[] args) {
        String baseUrl1 = "http://demo.guru99.com/test/link.html";
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl1);
        driver.findElement(By.partialLinkText("here")).click();
        System.out.println("Title of page is: " + driver.getTitle());
     //   driver.quit();

        String baseUrl2 = "http://demo.guru99.com/test/newtours/";

        driver.get(baseUrl2);
        String theLinkText = driver.findElement(By
                .partialLinkText("egis"))
                .getText();
        System.out.println(theLinkText);
        theLinkText = driver.findElement(By
                .partialLinkText("EGIS"))
                .getText();
        System.out.println(theLinkText);

        driver.quit();

    }
}
