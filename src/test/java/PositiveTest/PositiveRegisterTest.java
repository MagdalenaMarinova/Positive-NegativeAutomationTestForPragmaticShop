package PositiveTest;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PositiveRegisterTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Web Drivers\\new\\85\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }


    @Test
    public void successfulRegisterTest () {

        WebElement MyAccount = driver.findElement(By.cssSelector("i.fa.fa-user"));
        MyAccount.click();

        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();

        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        FirstName.sendKeys("Maggie");

        WebElement LastName = driver.findElement(By.id("input-lastname"));
        LastName.sendKeys("Ivanova");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("magggie.blalala" + RandomString.make(5) + "@abv.bg");

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("0885436130");

        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("password");

        WebElement confirm = driver.findElement(By.name("confirm"));
        confirm.sendKeys("password");


        WebElement subscribe = driver.findElement(By.name("newsletter"));

        if (!subscribe.isSelected())
            subscribe.click();

        Assert.assertTrue(subscribe.isSelected());


        WebElement policy = driver.findElement(By.name("agree"));

        if (!policy.isSelected())
            policy.click();

        Assert.assertTrue(policy.isSelected());

        WebElement Continue = driver.findElement(By.xpath("//div[@class='buttons']//input[@class='btn btn-primary']"));
        Continue.click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://shop.pragmatic.bg/index.php?route=account/success");


    }

    @AfterMethod

    public void tearDown () { driver.quit(); }

}
