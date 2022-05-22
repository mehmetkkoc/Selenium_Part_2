package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1.
        //Tests packagenin altina bir class oluşturun : C05_ UploadFile
        //2.
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3.
        //chooseFile butonuna basalim
        //4.
        //Yuklemek istediginiz dosyayi secelim
        /* Bu islemi selenium ile yapma imkanimiz yok
        cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik yapilmis olacaktir
         */
        // 1. adim choose file button unu locate edelim

        WebElement dosyaSecButtonu=driver.findElement(By.id("file-upload"));
        // 2. adim yuklenedek dosyanin yolunu olusturalim

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";
        String yuklenecekDosyaYolu=farkliKisim+ortakKisim;

        //3. adim sendKeys ile dosya yolunu secme button una yollayalim
        dosyaSecButtonu.sendKeys(yuklenecekDosyaYolu);


        //5.
        //Upload butonuna bas alim
        //6.
        //6.“File Uploaded!” textinin goruntulendigini test edelim
        Thread.sleep(5000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        Thread.sleep(3000);

    }
}
