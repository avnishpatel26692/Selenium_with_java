package selenium.sample;

import com.beust.jcommander.IValueValidator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();


        //to open an url
        driver.get("https://kristinek.github.io/site/examples/locators");
//        driver.get("https://kristinek.github.io/site/examples/actions");


//        //finding element by id
//        System.out.println(driver.findElement(By.id("heading_1")).getText());
//        System.out.println(driver.findElement(By.id("dummy")).getText());
//
//        //throws error if id is not correct
//        //System.out.println(driver.findElement(By.id("dummy1")).getText());
//
//
//        //finding elelment by name
//        //System.out.println(driver.findElement(By.name("randomButton1")));
//
//        driver.findElement(By.name("randomButton1"));


        //by Attributes (value=)
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("class"));
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("id"));


        //by classname
//        System.out.println(driver.findElement(By.className("twoTest")).getText());
//
////        by tagName
        System.out.println(driver.findElement(By.tagName("p")).getText());
//
////        Elements having common properties
//        WebElement heading1= driver.findElement(By.id("heading_1"));
//        heading1.getText();

        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(2).getText());
        //to close the browser
        Thread.sleep(5000);

        driver.quit();

    }
}

