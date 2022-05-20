package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test() {
        // facebook anasayfaya gidip
        //yeni kayit olustur butonuna basalim
        //isim kutusunu locate edip
        //geriye kalan alanlari tab tusuyla dolasarak
        //formu doldurun
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        WebElement nameAlani=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(nameAlani).
                sendKeys("mehmet").
                sendKeys(Keys.TAB).
                sendKeys("karakoc").
                sendKeys(Keys.TAB).
                sendKeys("mehmetkkoc@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("mehmetkkoc@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456mekA").perform();


    }
}
