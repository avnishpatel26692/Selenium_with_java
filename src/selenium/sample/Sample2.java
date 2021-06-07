package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    @Test
    public void sample2java() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
        //driver.get("https://google.com");
//        driver.get("https://kristinek.github.io/site/");
        driver.get("https://kristinek.github.io/site/examples/locators");

//        System.out.println(driver.findElement(By.id("heading_1")).getText());
//        System.out.println(driver.findElement(By.id("dummy")).getText());
//        System.out.println(driver.findElement(By.name("")).getText());
//        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));
//
//        //find by classname
//        System.out.println(driver.findElement(By.className("twoTest")).getText());
//
//        //find by tag name
//        System.out.println(driver.findElement(By.tagName("p")).getText());
//
//        //find web element
//        WebElement heading1 = driver.findElement(By.id("heading_1"));
//        heading1.getText();

        //get list of multiple elements with the same tag
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(0).getText());
        System.out.println(pTag.get(1).getText());

        //find elements with common properties
        System.out.println();

        //get title and url from a page that is being tested
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        //set time how long the tested page will be open
        Thread.sleep(2000);

        //to close the browser
        // .close closes 1 browser, .quit closes all browsers
//        driver.close();
        driver.quit();
    }
}
