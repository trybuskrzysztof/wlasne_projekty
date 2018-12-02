package com.trybus.frameworkexcercise.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTests {
    private WebDriver driver;
    private String email = "trybus.tester123@gmail.com";
    private String password = "qwer1234!@#$";
    private String username = "trybus.tester";

    @BeforeClass
    private void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    private void openBrowser() {
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

   @Test
   public void testAddingItemToCard() {

       new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");

       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
       driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).click();
       WebElement firstItemTitleElement = driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div/div/div[2]/div[1]/div[1]/a/h2"));
       String firstItemTitle = firstItemTitleElement.getText();
       firstItemTitleElement.click();

       assert (driver.findElement(By.id("productTitle"))).getText().equals(firstItemTitle);

       driver.findElement(By.id("add-to-cart-button")).click();
       WebElement cart = driver.findElement(By.id("hlb-view-cart-announce"));
       cart.click();

//       Actions builder = new Actions(driver);
//       Action moveTo = builder.moveToElement(cartitem).build();
//       moveTo.perform();

       WebElement carttitle = driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span"));
       System.out.println(carttitle.getText());
       System.out.println(firstItemTitle);

       assert (carttitle.getText().contains(firstItemTitle));

       WebElement delete = driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input"));
       delete.click();

       WebElement cartafterdelete = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
       cartafterdelete.click();

       WebElement homepage = driver.findElement(By.className("nav-logo-link"));
       homepage.click();

//       String text = driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div/div[3]/div[1]/span/text()"));
//       System.out.println(text);

  //     assert (driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div/div[3]/div[1]/span/text()")).getText().contains("was removed from Shopping Cart."));
   }

   @Test
    public void testSignInSignOut() {
        WebElement youraccount = driver.findElement(By.id("nav-your-amazon"));
        youraccount.click();

        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).submit();

        assert driver.findElement(By.xpath("//*[@id=\"hud-customer-name\"]/div/a")).getText().contains(username);

        Actions builder = new Actions(driver);
        Action moveMouse = builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"))).build();
        moveMouse.perform();

        WebElement signOut = driver.findElement(By.linkText("Sign Out"));
        signOut.click();

        assert driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1")).getText().equals("Sign in");
   }
}