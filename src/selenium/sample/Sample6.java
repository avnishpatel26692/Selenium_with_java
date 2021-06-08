package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void findXPath() {
        WebElement element1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(element2.getText());
    }

    @Test
    public void findCssSelector() {
        WebElement element1 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(element2.getText());
    }
}
