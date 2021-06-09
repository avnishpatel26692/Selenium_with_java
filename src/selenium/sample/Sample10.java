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

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Sample10 {
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
        Thread.sleep(5000);

        driver.quit();
    }
////    @Test
////    public void threadSleepWait() throws InterruptedException {
////        Thread.sleep(10000);
////        WebElement msg = driver.findElement(By.xpath("//*[@id='magic_text']/p"));
//    }
        @Test
        public void implicitWait () {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement msg = driver.findElement(By.xpath("//*[@id='magic_text']/p"));
        }
        @Test
        public void explicitWait () {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119"));
        }
        @Test
        public void explicitWait2(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(), 'This text magically changes color']")));
        }

        @Test
    public void explicitWait3(){
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(), 'dev magic')]")));
        }
    }
