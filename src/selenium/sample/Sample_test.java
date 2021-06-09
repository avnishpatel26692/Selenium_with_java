package selenium.sample;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample_test {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://kristinek.github.io/site");
        driver.get("https://kristinek.github.io/site/examples/locators");

        //By name
       // driver.findElement(By.name("vfb-5")).getAttribute(("value"));
        //By classname
//        System.out.println(driver.findElement(By.className("twoTest")).getText());
//        WebElement heading1 = driver.findElement(By.id("heading_1"));
//        heading1.getText();
        //By tagname
//        System.out.println(driver.findElement(By.tagName("p")).getText());
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size());
        System.out.println(pTag.get(2).getText());



        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
        driver.findElement(By.xpath("//input[@type = `submit`]")).click();*/

        System.out.println(driver.findElement(By.id("h1")).getText());
//        //get title of page
        System.out.println(driver.getTitle());
//
//        //get URL of current page
        System.out.println(driver.getCurrentUrl());
//
//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}