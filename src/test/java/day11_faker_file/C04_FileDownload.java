package day11_faker_file;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gid elim
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indir elim

        driver.findElement(By.xpath("//*[text()='text.txt']")).click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads a indirilecektir
        // Bize downloads un dosya yolu lazim


        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\text.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));



    }
}
