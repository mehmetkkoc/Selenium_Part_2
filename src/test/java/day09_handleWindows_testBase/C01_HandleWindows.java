package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
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
        //driver.close();
    }

    @Test
    public void test(){
        // 1 - amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        // CDwindow-9E351AECB9F2160C45C24172D85A3EEA
        // bu kod acilan sayfanin uniqe hash codudur
        // Selenium sayfalar arasi geciste bu window handle degerini kullanir
        // eger sayfalar arasinda driver imizi gezdiriyorsak
        // ve herhangi bir sayfadan su anda bulundugumuz sayfaya gecmek istiyorsak
        //driver.switchTo().window("CDwindow-9E351AECB9F2160C45C24172D85A3EEA");
        // bu sayfanin window handle degerini girerek bu sayfaya gecis saglayabiliriz

        // 2 - arama kismindan nutella arat
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

        // 3 - ilk urunun resmini tiklayarak farkli bir tab acin

        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        bu konutu kullandigimizda driver otomatik olarak olusturulan new taba gecer
        yeni tab da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])")).click();

        // 4 - yeni tabda acilan urunun title yazdirin

        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());
        
        // ilk sayfaya gecip url'i yazdiralim

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }

}
