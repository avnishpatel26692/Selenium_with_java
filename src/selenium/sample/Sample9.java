package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;


public class Sample9 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    String browser = "Chrome";

    @Before
    public void beforeMethod() {
        //define driver

        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();


        //Gecko driver
//        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
//        driver = new FirefoxDriver();

        //Internet Explorer driver
//        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "IEDriverSever.exe");
//        driver = new InternetExplorerDriver();

        driver.get("https://kristinek.github.io/site/tasks/locators_different");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyBackgroundColor(){
        WebElement luckyParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = luckyParagraph7Label.getCssValue("background-color");
        if (browser.equals("FireFox")) {
            Assert.assertEquals("rgb(233, 30, 99)", actualValue);
        }
        else if (browser.equals("Chrome")) {
            Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
        }

    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
