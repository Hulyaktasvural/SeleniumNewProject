package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C03_FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        /*
        findElement ile bir webelemente ulaşabilirken, birden fazla webelement için findElements() methodunu kullanırız.
        Bu webelementlerin sayısına ulaşmak için yada bu webelementlerin yazısını konsola yazdırabilmek için
        List<Webelement> linklerListesi = driver.findElements(By.locator("locator değeri")) olarak kullanırız.
        Oluşturmuş olduğumuz list'i loop ile konsola yazdırabiliriz.
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayısı = "+ linklerListesi.size());
/*
        for (WebElement w: linklerListesi){
            if(!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }
 */
       //Lambda ile yazdıralım
        linklerListesi.forEach(link -> {if (!link.getText().isEmpty()){
                                        System.out.println(link.getText());}});


         //Sign in webelementinin yazısını yazdıralım
        System.out.println("***********************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazısı = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazısı.getText());
        //webelementin üzerindeki yazıyı almak istiyorsak getText() methodunu kullanırız.


        driver.close();




    }
    //Amazon sayfasına gidiniz
    //iphone aratınız
    //çıkan sonuç yazısını konsola yazdırınız
    //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
}
