package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {



    @Test
    public void test01() {

        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()

        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement addSonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(addSonucYazisi.isDisplayed());

    }

    @Test
    public void test02() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        yazin in gorunurolmasini beklerken yazinin locate ini kullanmak sorun olur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapabilir)
        bu durumda bekleme islemi ve locate i birlikte yapmaliyiz
        */
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.
                                        visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin

        WebElement addSonucYazisi=wait.until(ExpectedConditions.
                                    visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(addSonucYazisi.isDisplayed());

    }

}
