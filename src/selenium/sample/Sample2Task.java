package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "//lib//";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

//        open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");

//        Finding an element using ID
        System.out.println(driver.findElement(By.id("heading_1")).getText());

        //By Classname
        System.out.println(driver.findElement(By.className("unbelievable")).getText());

        //By Tagname
        System.out.println(driver.findElement(By.tagName("p")).getText());

        List<WebElement> pTag = driver.findElements(By.tagName("p"));
       System.out.println(pTag.size());
        //1st element
        System.out.println(pTag.get(0).getText());

//        to close the browser
        driver.quit();
    }
}
