package selenium.sample;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sample10Task {


    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/sync");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    @Test
    public void threadSleepWait() throws InterruptedException {
        Thread.sleep(8000);
        WebElement message = driver.findElement(By.xpath("//p"));
    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'this magic')]"));
    }

    @Test
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: green"));
    }

    @Test
    public void explicitWaitExample2() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text()='is this magic?']")));
    }

    @Test
    public void explicitWaitExample3() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'this magic')]")));
    }


}