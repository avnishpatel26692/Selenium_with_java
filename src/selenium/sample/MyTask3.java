package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyTask3 {
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

    @Test
    public void assertEqualsExample()
    {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String expectedValue = "Heading 1";
        String actualValue = heading1.getText();
        Assert.assertEquals("values are not matching",expectedValue,actualValue);
    }

    //moj
    @Test
    public void assertEqualsExample1()
    {
    WebElement a1 = driver.findElement(By.className("text"));
    String ExpectedResult = "sample text 1";
    String ActualResult = a1.getText();
    Assert.assertEquals(ExpectedResult,ActualResult);
    }

    @Test
    public void assertTrueExample()
    {
        WebElement button2 = driver.findElement(By.name("randomButton2"));
        String expectedValue = "This is also a button";
        String actualValue = button2.getAttribute("value");
        Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
    }

    // moj
    @Test public void assertTrueExample1()
    {
        WebElement a2 = driver.findElement(By.id("buttonId"));
        String ExpectedResult = "This is also a button";
        String ActualResult = a2.getAttribute("value");
        Assert.assertTrue(ExpectedResult.equalsIgnoreCase(ActualResult));
    }

    @Test
    public void assertFalse()
    {
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "This is a button12";
        String actualValue = button1.getAttribute("value");
        Assert.assertFalse(expectedValue.equals(actualValue));
    }
    //moj
    @Test public void assertFalse1(){
        WebElement a3 = driver.findElement(By.id("heading_1"));
        String ExpectedResult = "Vasja";
        String ActualResult = a3.getText();
        Assert.assertFalse(ExpectedResult.equalsIgnoreCase(ActualResult));
    }

    @Test
    public void assertFail()
    {
        int age = 19;
        if(age<18) {
            Assert.fail("Age is below 18");
        }
        System.out.println("Welcome");
    }

    //moj
    @Test
    public void assertFail1()
    {
        int salary = 200;
        if (salary < 300) {
            Assert.fail("Sorry mate");
        }
        System.out.println("Otherwise Hello!");
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }
}