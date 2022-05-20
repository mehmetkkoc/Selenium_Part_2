package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    //1. Bir class oluşturun : RadioButtonTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın. https://www.facebook.com adresine gidin

    WebDriver driver;
    @Before
    public void setup() {
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
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        //Cookies’i kabul edin

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        Thread.sleep(2000);

        //-“radio buttons” elementlerini locate edin
        WebElement femaleButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement costumButton= driver.findElement(By.xpath("//input[@value='-1']"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(2000);

    }

}
