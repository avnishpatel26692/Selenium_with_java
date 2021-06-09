package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //Define driver
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().window().maximize();
    }

    @Test
    public void explicitWaitForGreenLoaded() {
        WebElement button = driver.findElement(By.xpath("//button[@id='start_green']"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
    }

    @Test
    public void explicitWaitForGreenAndBlueLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String buttonXPath = "//button[@id='start_green_and_blue']";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonXPath)));
        WebElement button = driver.findElement(By.xpath(buttonXPath));
        button.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green_and_blue']")));
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }
}
