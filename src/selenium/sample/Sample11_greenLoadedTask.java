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

public class Sample11_greenLoadedTask {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void greenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement button = driver.findElement(By.id("start_green"));
        button.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green")));
//                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));


    }

    @Test
    public void greenAndBlueLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("start_green_and_blue")));
        WebElement button = driver.findElement(By.id("start_green_and_blue"));
        button.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green_and_blue")));
    }
}
