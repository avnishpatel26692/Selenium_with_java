package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open an URL
        driver.get("https://kristinek.github.io/site/examples/locators");

        //find element by ID
        System.out.println("Element found by ID \"standartText\":");
        System.out.println("Text: " + driver.findElement(By.id("standartText")).getText());
        System.out.println("" + driver.findElement(By.id("standartText")).getAttribute("value"));
//        System.out.println(driver.findElement(By.id("dummy")).getText());
//        System.out.println(driver.findElement(By.name("randomButton1")).getText());

//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("class"));
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("id"));

        //By classname
        driver.get("https://kristinek.github.io/site/examples/locators");
        System.out.println(driver.findElement(By.className("twoTest")).getText());

        //By tagname
        System.out.println(driver.findElement(By.tagName("p")).getText());

        WebElement heading1 = driver.findElement(By.id("heading_1"));

        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        //1st element
        System.out.println(pTag.get(0).getText());

        //3rd element
        System.out.println(pTag.get(3).getText());
//\
//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
