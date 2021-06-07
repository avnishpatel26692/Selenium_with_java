package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");








        System.out.println(driver.findElement(By.id("test1")).getText());
        System.out.println(driver.findElement(By.id("test2")).getText());
        System.out.println(driver.findElement(By.id("test3")).getText());

        System.out.println("***************************");

        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("id"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("type"));

        System.out.println("***************************");

        System.out.println(driver.findElement(By.className("unbelievable")).getText());
        System.out.println(driver.findElement(By.className("amazing")).getText());

        System.out.println("***************************");


        List<WebElement> el = driver.findElements(By.tagName("p"));
        System.out.println(el.size());
        System.out.println(el.get(2).getText());

        driver.quit();



    }
}
