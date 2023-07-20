package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01_getTagName_getAttributeName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1- https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");


        //2- arama kutusunu locate ediniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- arama kutusunun tagName'inin "input" olduğunu test edin
        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";
        if (actualTagName.equals(expectedTagName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //4- arama kutusunun name attribute'nun değerinin "field-keywords" olduğunu test edin
         /*
            <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
            tabindex="0" aria-label="Search Amazon" spellcheck="false">
             */

        String actualAttributeName = aramaKutusu.getAttribute("name");
        String expectedAttributeName = "field-keywords";
        if (actualAttributeName.equals(expectedAttributeName)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfayı kapatın
        driver.close();














    }
}
