package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample10 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
//        driver.get("https://kristinek.github.io/site/examples/locators");
//        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.get("https://kristinek.github.io/site/examples/sync");

    }
    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
    }
    @Test
    public void threadSleepWait() throws InterruptedException {
        Thread.sleep(10000);
        WebElement msg = driver.findElement(By.xpath("//p"));
    }

    @Test
    public void explicitWait()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style","color: rgb(119, 119, 119);"));
    }

    @Test
    public void explicitWaitExample2()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='This text magicly changes color']")));
    }

    @Test
    public void explicitWaitExample3()
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
    }



}