package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edelim
        //Arama kutusuna iphone yazdıralım ve aratalım
        /*
         Bir webelementin locate'ini birden fazla kullanacaksanız bir webelement'te değişken olarak atayabilirsiniz.
         Webelement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox")); şeklinde kullanabilirsiniz.
         1-Locate işlemi bittikten sonra eğer webelemente bir metin göndereceksek sendKey() methodu kullanırız.
         2-webelemente tıklayacaksak click() methodu kullanırız.
         3-webelementin üzerindeki yazıyı almak istiyorsak getText() methodunu kullanırız.
         4-sendKeys() methodundan sonra(yani webElemente metin gönderdikten sonra) Keys.ENTER ile ya da
         submit() methodu ile manuel olarak manuel olarak enter yaptığımız gibi otomasyonda da yapabiliriz.
         */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sayfayı kapatalım
        driver.close();




    }
}
