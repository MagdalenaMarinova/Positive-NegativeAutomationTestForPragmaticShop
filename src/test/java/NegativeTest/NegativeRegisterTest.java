package NegativeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NegativeRegisterTest {

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
    public void unsuccessfulRegisterTest() {

        WebElement MyAccount = driver.findElement(By.cssSelector("i.fa.fa-user"));
        MyAccount.click();

        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();

        WebElement subscribe = driver.findElement(By.name("newsletter"));
        Assert.assertTrue(!subscribe.isSelected());

        WebElement policy = driver.findElement(By.name("agree"));
        Assert.assertTrue(!policy.isSelected());

        WebElement Continue = driver.findElement(By.xpath("//div[@class='buttons']//input[@class='btn btn-primary']"));
        Continue.click();

        WebElement Warning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals("Warning: You must agree to the Privacy Policy!", Warning.getText());

        WebElement FirstNameError = driver.findElement(By.xpath("//div[@class='text-danger'][contains(text(),'First Name must be between 1 and 32 characters!')]"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!", FirstNameError.getText());

        WebElement LastNameError = driver.findElement(By.xpath("//div[@class='text-danger'][contains(text(),'Last Name must be between 1 and 32 characters!')]"));
        Assert.assertEquals("Last Name must be between 1 and 32 characters!", LastNameError.getText());

        WebElement Email = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"));
        Assert.assertEquals("E-Mail Address does not appear to be valid!", Email.getText());

        WebElement Telephone = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"));
        Assert.assertEquals("Telephone must be between 3 and 32 characters!", Telephone.getText());

        WebElement Password = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"));
        Assert.assertEquals("Password must be between 4 and 20 characters!", Password.getText());


    }

    @AfterMethod

    public void tearDown () { driver.quit(); }
}
