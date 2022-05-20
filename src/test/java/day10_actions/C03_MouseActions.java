package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1
        //Yeni bir class olusturalim: MouseActions1
        //2
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkHandle=driver.getWindowHandle();
        //3
        //Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlan).perform();
        //4
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        String expectedAlertText="You selected a context menu";
        Assert.assertEquals(driver.switchTo().alert().getText(),expectedAlertText);

        //5
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//div[@class='large-12 columns'][1]")).click();
        Thread.sleep(5000);


        //6
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set <String> handles=driver.getWindowHandles();
        String ikinciHandle="";
        for (String each:handles
             ) {
            if (!each.contains(ilkHandle)){
                ikinciHandle=each;
            }

        }
        driver.switchTo().window(ikinciHandle);


        //7
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String h1Tagi=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(h1Tagi,"Elemental Selenium");
    }
}
