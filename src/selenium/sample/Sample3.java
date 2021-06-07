package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample3 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    @Test
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage

        driver.get("https://kristinek.github.io/site/examples/locators");

        System.out.println(driver.findElement(By.id("heading_2")).getText());
        System.out.println(driver.findElement(By.id("test1")).getText());

        System.out.println(driver.findElement(By.id("buttonId")).getText());
        System.out.println(driver.findElement(By.id("buttonId")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("randomButton2")).getText());
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("name"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value"));

        System.out.println(driver.findElement(By.className("test")).getText());

        List<WebElement> pTag = driver.findElements(By.className("text"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(0).getText());
        System.out.println(pTag.get(1).getText());

        Thread.sleep(1000);

        driver.close();

    }
}
