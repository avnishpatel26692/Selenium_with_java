package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ActivityTwo {



        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

        @Test
        public void goToHomepage() throws Exception {
            //define driver
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
            WebDriver driver = new ChromeDriver();

            //open test homepage
//        driver.get("https://google.com");
            driver.get("https://kristinek.github.io/site/examples/locators");

            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();


//       System.out.println(driver.findElement(By.name("vfb-5")).getAttribute("value"));

//        System.out.println( driver.findElement(By.id("test3")).getText());

//        System.out.println (driver.findElement(By.className("test")).getText());


         WebElement heading2 = driver.findElement(By.id("heading_2"));

          List<WebElement> pTag = driver.findElements(By.tagName("p"));
          System.out.println(pTag.size());
          System.out.println(pTag.get(0).getText());


            Thread.sleep(5000);



            driver.quit();    //will close all browsers
        }

    private class WebElements {
    }
}


