package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // gorevini fake isimlerle yapalim
        // facebook anasayfaya gidip
        //yeni kayit olustur butonuna basalim
        //isim kutusunu locate edip
        //geriye kalan alanlari tab tusuyla dolasarak
        //formu doldurun
        driver.get("https://www.facebook.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        Thread.sleep(1000);
        WebElement nameAlani=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);

        Faker faker = new Faker();
        String fakeMail=faker.internet().emailAddress();

        actions.click(nameAlani).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("03").
                sendKeys(Keys.TAB).
                sendKeys("Apr").
                sendKeys(Keys.TAB).
                sendKeys("1984").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(2000);
    }
}
