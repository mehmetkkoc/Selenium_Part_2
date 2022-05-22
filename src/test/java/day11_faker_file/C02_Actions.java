package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.xml.crypto.KeySelectorResult;

public class C02_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //1
        //Bir Class olusturalim KeyboardActions2
        //2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3
        //video’yu gorecek kadar asagi inin
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        Thread.sleep(2000);


        //4
        //videoyu izlemek icin Play tusuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        Thread.sleep(3000);
        //5
        //videoyu calistirdiginizi test edin
        WebElement youtubeLinki=driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLinki.isDisplayed());


    }
}
