package Day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3.Login alanine “ yazdirin
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");

        //4.P assword alanine “ yazdirin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("1000");
        //8.
        //tarih kismina “2020 0 9 10 yazdirin
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");
        //9. Pay button
        //una tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //10. “The payment was successfully submitted.”
        //mesajinin ciktigini control edin
        String mesaj=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();
        String extentedMesaj="The payment was successfully submitted.";
        if (mesaj.equals(extentedMesaj)){
            System.out.println("sonuc yazisi testi PASSED");
        }else{
            System.out.println("sonuc yazisi testi FAILED");
        }
    }
}
