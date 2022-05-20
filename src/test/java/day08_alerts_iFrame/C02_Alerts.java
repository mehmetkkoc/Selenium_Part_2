package day08_alerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //●Bir class olusturun: Alert s
    //●https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //●Bir metod olusturun: acceptAlert
    //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //“You successfully clicked an alert” oldugunu test edin
    //●Bir metod olusturun: dismissAlert
    //○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin
    //●Bir metod olusturun: sendKeysAlert
    //○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown() {
       driver.close();
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //●Bir metod olusturun: acceptAlert
        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String ilkAlertSonuc=driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        String expectedIlkSonuc="You successfully clicked an alert";
        Assert.assertEquals(ilkAlertSonuc,expectedIlkSonuc);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        //●Bir metod olusturun: dismissAlert
        //○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        String ikinciSonuc=driver.findElement(By.xpath("//p[@style='color:green']")).getText();
        Assert.assertFalse(ikinciSonuc.contains("successfuly"));

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //●Bir metod olusturun: sendKeysAlert
        //○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("Mehmet Karakoc");
        driver.switchTo().alert().accept();
        String sonSonucYazisi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedSonSonuc="Mehmet Karakoc";
        Assert.assertTrue(sonSonucYazisi.contains(expectedSonSonuc));

    }
}
