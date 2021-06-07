package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Task {static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void sample2Task() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        System.out.println(driver.findElement(By.id("heading_1")).getText());
        System.out.println(driver.findElement(By.name("randomButton1")));
        System.out.println(driver.findElement(By.className("unbelievable")).getText());
        System.out.println(driver.findElement(By.tagName("p")).getText());
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(0).getText());
        System.out.println(pTag.get(2).getText());

        Thread.sleep(5000);
        driver.quit();
    }}


