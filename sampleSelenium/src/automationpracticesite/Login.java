package automationpracticesite;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Login {

    public static void main (String args[]) {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver_win64\\geckodriver.exe");
        String baseURL = "http://automationpractice.com/index.php";
        WebDriver driver = new FirefoxDriver();
        driver.get(baseURL);

        WebElement signIn = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
//        WebElement offer = driver.findElement(By.xpath("//div[@id='columns']/div/div/div[2]/ul/li[1]/a/img"));

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        offer.click();

//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://somedomain/someurl");
        WebElement dynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='columns']/div/div/div[2]/ul/li[1]/a/img")));

       // WebElement emailfield = driver.findElement(By.id("email_create"));

        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String str = new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        System.out.println(str);
    }
}