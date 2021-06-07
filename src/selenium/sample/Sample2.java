package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    //for mac os
    //static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    @Test
    public void sample2java() throws Exception {

//        define driver for mac os
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

//        To open a url
        driver.get("https://kristinek.github.io/site/examples/locators");
        //driver.get("https://kristinek.github.io/site/examples/actions");

        //Finding an element using id prpoerty
        //<h2 id="heading_1">Heading 1</h2>
       /* System.out.println(driver.findElement(By.id("heading_1")).getText());
        System.out.println(driver.findElement(By.id("dummy")).getText());
        // throws an error if id is not present
        //System.out.println(driver.findElement(By.id("dummy1")).getText());
        // Find an element using name property
        //<input type="button" value="This is a button" name="randomButton1">
        driver.findElement(By.name("randomButton1"));*/
/*
        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("class"));
        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("id"));*/

        //By Classname
        //System.out.println(driver.findElement(By.className("twoTest")).getText());

        //By Tagname
        System.out.println(driver.findElement(By.tagName("p")).getText());

        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        //1st element
        System.out.println(pTag.get(0).getText());

        //3rd element
        System.out.println(pTag.get(2).getText());

        Thread.sleep(2000);

        //to close the browser
        driver.quit();
    }
}