package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike" + Keys.ENTER);

        // sonuc yazısını yazdırın
        List<WebElement> sonucYazısı =  driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazısı.get(0).getText()); //1-16 of 200 results for "city bike"

        //Xpath ile list kullanmadan tek seferde locate aldık
        WebElement sonuçYazısıXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        // sonuc sayısını yazdırın
        String [] sonuçSayısı = sonucYazısı.get(0).getText().split(" ");
        System.out.println("Sonuç Sayısı =" +sonuçSayısı[2]);

        //Sayfadaki 12.elementi list kullanmadan xpath'in index özelliğini kullanarak locate aldık
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        // ilk ürünün locatini alın
        List<WebElement> ürünler = driver.findElements(By.className("s-image"));
        WebElement ilkÜrün = ürünler.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkÜrün.isDisplayed());

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkÜrün.isEnabled());

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkÜrün.isSelected()); //False döner çünkü webelement seçilme özelliğine sahip değil

        // ilk urune tıklayın
        ilkÜrün.click(); //webelementin üstüne tıklar.

        // sayfayı kapatın
        driver.close();

          /*
            //ARAMA KUTUSUNUN HTML KODLARI
            <input type="text" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
            tabindex="0" aria-label="Search Amazon" spellcheck="false">
          */



        //Relative Xpath syntax -->  //tagname[@attributeName='atributeValue']
        //input[@type='text']
        //                            (//input[@type='text'])[1]
        //                            //*[@type='text']
    /*
        Aldığımız xpath unique olmadığı zaman xpath'imizi parantez içine alarak index belirtebiliriz.
    Böylelikle webelementleri Liste atıp istediğimiz elementi almakla uğraşmayız.
    Xpath'in değişik kullanma yolları vardır.
     */

        //Techproeducation sayfasına gidelim
        //Çıkan reklamı locate edip kapatalım
        //Arama bölümünde qa aratalım
        //Sayfa başlığının qa içerdiğini doğrulayalım
        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        //Carrer Opportunities In QA linkine tıklayalım
        //Başlığın Opportunities içerdiğini test edelim
        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım

    }
}
