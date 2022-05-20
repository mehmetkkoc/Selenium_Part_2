package day08_alerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    //●Bir class olusturun: IframeTest
    //●https://the internet.herokuapp.com/iframe adresine gidin.
    //●Bir metod olusturun: iframeTest
    //○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○Text Box’a “Merhaba Dunya!” yazin.
    //○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.
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
        driver.close();
        }

    @Test
    public void test() throws InterruptedException {
        //●https://the-internet.herokuapp.com/iframe adresine gidin.
        //●Bir metod olusturun: iframeTest
        //○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());
        //○Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);
        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya");

        driver.switchTo().defaultContent();

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement linkYaziElementi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());


    }
}
