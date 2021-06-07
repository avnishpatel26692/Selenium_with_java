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
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open an URL
        driver.get("https://kristinek.github.io/site/examples/locators");

        //find element by ID
        System.out.println();
        System.out.println("Element found by ID \"standartText\":");
        System.out.println("Text: " + driver.findElement(By.id("standartText")).getText());
        System.out.println("Value: " + driver.findElement(By.id("standartText")).getAttribute("value"));
        System.out.println("Class: " + driver.findElement(By.id("standartText")).getAttribute("class"));

        //find element by name
        System.out.println();
        System.out.println("Element found by name \"randomButton1\":");
        System.out.println("Text: " + driver.findElement(By.name("randomButton1")).getText());
        System.out.println("Value: " + driver.findElement(By.name("randomButton1")).getAttribute("value"));
        System.out.println("Class: " + driver.findElement(By.name("randomButton1")).getAttribute("class"));

        //Find element by classname
        System.out.println();
        System.out.println("Element found by name \"text\":");
        System.out.println("Text: " + driver.findElement(By.className("text")).getText());
        System.out.println("Value: " + driver.findElement(By.className("text")).getAttribute("value"));
        System.out.println("Class: " + driver.findElement(By.className("text")).getAttribute("class"));


//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.close();
    }
}
