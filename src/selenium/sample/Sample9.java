package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Sample9 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        //driver = new FirefoxDriver();

        //Internet explorer
        //System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        //driver = new InternetExplorerDriver();

        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void verifyBackgroundColor()
    {
        WebElement element1 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

}