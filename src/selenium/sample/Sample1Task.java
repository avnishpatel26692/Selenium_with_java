package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample1Task {

        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        //for mac os
        //static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

        @Test
        public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");

        //define driver for mac os
        //System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //To open a url
        driver.get("https://kristinek.github.io/site/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(5000);

        //to close the browser
            driver.quit();
    }
}
