package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample3Task {
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
    public void assertEqualExample() {
        WebElement heading1 = driver.findElement(By.id("heading_2"));
        String expectedValue = "Heading 2"; // This makes test to fail as the result is not correct; negative scenario; With "Heading 2 text" it will pass.
        String actualValue = heading1.getText();
        Assert.assertEquals("Values ar not matching", expectedValue, actualValue);
    }

    @Test
    public void assertTrueExample() {
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "This is also a button"; // To pass the test it should be "This is a button"
        String actualValue = button1.getAttribute("value");
        Assert.assertTrue(expectedValue.equalsIgnoreCase((actualValue)));
    }


    @Test
    public void assertFalse() {
        WebElement button2 = driver.findElement(By.name("randomButton2"));
        String expectedValue = "Next"; // Expected is false (test result = true), should be "This is a button" (then the test will fail)
        String actualValue = button2.getAttribute("value");
        Assert.assertFalse(expectedValue.equalsIgnoreCase((actualValue)));
    }

    @Test
    public void assertFail() {
        // some code, for example:
        int age = 90;
        if (age < 85) {
            Assert.fail("Age is too big");
        }
        System.out.println("Welcome to the club!");

    }


    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }
}
