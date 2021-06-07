package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class Sample2Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //driver.get("https://kristinek.github.io/site/");
        driver.get("https://kristinek.github.io/site/examples/locators");

//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.findElement(By.id("heading_1")).getText());
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("id"));
        System.out.println(driver.findElement(By.className("amazing")).getText());
        System.out.println(driver.findElement(By.tagName("p")).getText());
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());


        //Sleep for 10 seconds
        Thread.sleep(5000);
        //Close browser
        driver.quit();
    }

}
