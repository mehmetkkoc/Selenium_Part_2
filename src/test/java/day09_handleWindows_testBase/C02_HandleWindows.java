package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test(){
        // 1 - Amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        // 2 - url nin amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // 3 - yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com/");
        String bestbuyHandle = driver.getWindowHandle();
        // 4 - title in bestbuy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        // 5 - ilk sayfaya donup java aratalim
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);

        // 6 - arama sonuclarinin java icerdigini test edelim
        String aramaSonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonuc.contains("java"));

        // 7 - yeniden bestbuy in acik oldugu sayfaya gecelim
        driver.switchTo().window(bestbuyHandle);
        // 8 - logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }
}
