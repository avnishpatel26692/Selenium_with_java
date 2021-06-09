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
    String browser = "ie";

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
//        driver = new InternetExplorerDriver();

        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }
    @Test
    public void verifyFontSize(){
        WebElement fontSizeElememt = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = fontSizeElememt.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        {
        if (browser=="firefox")
            Assert.assertEquals("rgb(103, 58, 183)", fontSizeElememt.getCssValue("background-color"));
        else
            Assert.assertEquals("rgba(103, 58, 183, 1)", fontSizeElememt.getCssValue("background-color"));
        }
        System.out.println(fontSizeElememt.getCssValue("font-family"));
        System.out.println(fontSizeElememt.getCssValue("background-color"));
        System.out.println(fontSizeElememt.getCssValue("padding-left"));
    }
}
