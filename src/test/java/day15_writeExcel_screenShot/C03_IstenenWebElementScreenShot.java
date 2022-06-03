package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementScreenShot extends TestBase {
    @Test
    public void webElementScreenShot() throws IOException {

        // amazona gidip nutella aratalim
        // ve sonuc sayisinin oldugu web elementin fotosunu cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
}