package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Sample6 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/locators");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void findXPath() {
        WebElement element1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element1.getText());
    }

    @Test
    public void findXPath1() {
        WebElement element2 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(element2.getText());
    }

    @Test
    public void findCSSSelector() {
        WebElement element3 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(element3.getText());
    }

    @Test
    public void findCSSSelector1() {
        WebElement element4 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(element4.getText());
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
