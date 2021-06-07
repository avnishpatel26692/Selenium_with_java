package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class Sample3 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualsExample() {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String expectedValue = "Heading 1";
        String actualValue = heading1.getText();
        Assert.assertEquals(expectedValue, actualValue);


    }

    @Test
    public void assertTrueExample() {
        WebElement button2 = driver.findElement(By.name("randomButton2"));
        String expectedValue = "This is also a button";
        String actualValue = button2.getAttribute("value");
        Assert.assertEquals("Value is true ", expectedValue, actualValue);
    }

    @Test
    public void assertFalseExample() {
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "Next";
        String actualValue = button1.getAttribute("value");
        Assert.assertFalse(expectedValue.equals(actualValue));
    }

    @Test
    public void assertFail() {
        int age = 19;
        if (age < 18) {
            Assert.fail();
        }
        System.out.println("Welcome");

    }

    @After
    public void afterMethod() throws InterruptedException {
        {
            Thread.sleep(5000);

            driver.quit();
        }
    }
}