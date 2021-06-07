package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();


        //to open an url
        driver.get("https://kristinek.github.io/site/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //to close the browser
        Thread.sleep(5000);

            driver.quit();

    }
}