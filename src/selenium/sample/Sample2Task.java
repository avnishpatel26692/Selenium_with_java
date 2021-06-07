package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Sample2Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

//       To open url
        driver.get("https://kristinek.github.io/site/examples/locators");

//         By id
        System.out.println(driver.findElement(By.id("nonStandartText")).getText());

//        By tag
        System.out.println(driver.findElement(By.tagName("p")).getText());


//     By name
        System.out.println(driver.findElement(By.name("randomButton2")).getText());

// By class
        System.out.println(driver.findElement(By.className("twoTest")).getText());

//         By list
        List<WebElement> pTag = driver.findElements(By.tagName("p"));


//       Sets seconds how long the browsers is opened. Here = 5 sec
        Thread.sleep(5000);

//       To close the browser "close" closes the recent one opened on the desk. "Quit" = closes all opened browsers.
        driver.close();

    }

}
