package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void findXpath()
    {
        WebElement element1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element1.getText());

        //2nd example
    }

    @Test
    public void findCSSSelector()
    {
        WebElement element2 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(element2.getText());

        //2nd example
    }
}
