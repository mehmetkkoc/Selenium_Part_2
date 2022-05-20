package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setUp(){
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
    public void test(){
        // Eger test methodunuzda hicbir test yoksa test calistiktan sonra
        // hicbir problemle karsilasilmadigini raporlamak icin "TEST PASSED" yazisi cikar

        // Eger testleri if ile yaparsak
        // test test failed olsa da sorunla karsilasilmadigindan "Test Passed" yazisi cikacaktir
        driver.get("https://www.amazon.com");
        // url'in https://www.facebook.com oldugunu test edin

       /* if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }*/

        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("url beklenenden farkli",expectedUrl, actualUrl);
        /*
        Assert ile yaptigimiz testlerde assertion failed olursa
        Java kodlarin calismasini durdurur ve Assert class'i
        bizi hata konusunda bilgilendirir
                org.junit.ComparisonFailure: Url beklenenden farkli
                Expected :https://www.facebook.com
                Actual   :https://www.amazon.com/
                <Click to see difference>
        Boylece hatanin ne oldugunu arastirmamiza gerek kalmadan
        JUnit bize raporlamis olacak
         */
    }
}
