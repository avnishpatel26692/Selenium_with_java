package selenium.sample.ActivityDayThree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActivityDayThreeFirstTaskOurActivity {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {

        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");

        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().window().maximize();


    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }


    @Test
    public void explicitWaitExampleGreenLoaded() {
        WebElement startLoadingGreenButton = driver.findElement(By.id("start_green"));
        startLoadingGreenButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
    }

    @Test
    public void explicitWaitExampleGreenAndBlueLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("start_green_and_blue")));
        WebElement startLoadingGreenBlueButton = driver.findElement(By.id("start_green_and_blue"));
        startLoadingGreenBlueButton.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green_and_blue")));
    }

  

}



