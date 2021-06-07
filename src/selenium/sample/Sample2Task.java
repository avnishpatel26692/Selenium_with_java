package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2Task {


    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");

        System.out.println(driver.findElement(By.id("heading_1")).getText());
    System.out.println(driver.findElement (By.className("twoTest")).getText());




//
//

//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
