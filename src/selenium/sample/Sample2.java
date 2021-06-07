package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");

        driver.get("https://kristinek.github.io/site/examples/locators");

        System.out.println(driver.findElement(By.className("twoTest")).getText());
//            System.out.println(driver.findElement(By.className("text amazing")).getText());
        System.out.println(driver.findElement(By.id("test2")).getText());

        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value" +
                ""));
        List<WebElement> pTag = driver.findElements(By.tagName("p"));

//        //Sleep for 5 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }


}
