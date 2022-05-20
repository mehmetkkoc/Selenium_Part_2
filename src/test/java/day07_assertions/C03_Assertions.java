package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
   // @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement mailKutusu=driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com"+ Keys.ENTER);
        WebElement hataMesaji=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(hataMesaji.isDisplayed());
        System.out.println(hataMesaji.getText());


    }


}
