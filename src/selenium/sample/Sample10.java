package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Sample10 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver

        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/sync");
        driver.manage().window().maximize();
    }

    @Test
    public void threadSleepWait() throws InterruptedException {
        Thread.sleep(10000); // Wait for 10 seconds irrespective for any conditions
        WebElement msg = driver.findElement(By.xpath("//p"));
    }


    @Test
    public void implicitWait() {
        // Maximum time for finding an element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Wait for 10 seconds until the next element appears
        WebElement msg = driver.findElement(By.xpath("//p"));
    }

    @Test
    public void explicitWait() {
        // Check attributes example: color of text
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119);"));
    }

    @Test
    public void explicitWaitExample2() {
        // Wait until element is invisible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='This text magicly changes color']")));
    }

    @Test
    public void explicitWaitExample3() {
        // Wait until element is visible
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(), 'dev magic')]")));
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }
}
