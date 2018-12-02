package fan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class training1 {

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

        WebElement login = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[7]/td[2]/a"));
        login.click();
        String logintitle = driver.getTitle();
        System.out.println(logintitle);
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        WebElement passwrd = driver.findElement(By.name("password"));
        WebElement submit1 = driver.findElement(By.name("SDalej"));

        email.sendKeys("krzysztof.t123@gmail.com");
        passwrd.sendKeys("graphical=");
        submit1.submit();
        String kontourl = driver.getCurrentUrl();
        System.out.println(kontourl);
        Thread.sleep(3000);

        WebElement wyloguj = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[1]/a"));
        wyloguj.click();

        driver.close();
    }
}
