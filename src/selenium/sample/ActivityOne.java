package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class ActivityOne {



        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

        @Test
        public void goToHomepage() throws Exception {
            //define driver
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
            WebDriver driver = new ChromeDriver();

            //open test homepage
//        driver.get("https://google.com");
            driver.get("https://kristinek.github.io/site/");

            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


            Thread.sleep(5000);



            driver.quit();    //will close all browsers
        }
    }


