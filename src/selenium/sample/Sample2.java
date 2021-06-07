package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/actions");


        /*driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
        driver.findElement(By.xpath("//input[@type = `submit`]")).click();*/

        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("name"));
        System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("class"));
//        //get title of page

        //
//        //Sleep for 10 seconds
        Thread.sleep(2000);

        //Close browser
        driver.quit();
    }
}

