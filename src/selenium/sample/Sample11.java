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

public class Sample11 {
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
    public void testGreenButton() {
        WebElement clickButton = driver.findElement(By.id("start_green"));
        clickButton.click(); // click Start Green button

        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='This text magicly changes color']")));
//    wait.until(ExpectedConditions.visibilityOfAllElementLocatedBy(By.id("finish_green")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green")));
    }

    @Test
    public void testGreenBlueButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("start_green_and_blue")));

        WebElement clickButton = driver.findElement(By.id("start_green_and_blue"));
        clickButton.click(); // click Start Green button

        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish_green_and_blue")));
    }

}
