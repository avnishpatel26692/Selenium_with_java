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
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualsExample(){
        WebElement heading2 = driver.findElement(By.id("heading_2"));
        String expectedValue = "Heading 2 text";
        String actualValue = heading2.getText();
        Assert.assertEquals("values are not matching",expectedValue,actualValue);
    }
    @Test
    public void assertTrueExample(){
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "This is a bUtToN"; //the case does not matter
        String actualValue = button1.getAttribute("value");
        Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
    }

    @Test
    public void assertFalse(){
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "Next";
        String actualValue = button1.getAttribute("value");
        Assert.assertFalse(expectedValue.equals(actualValue));
    }

    @Test
    public void assertFail(){
        int age = 19;
        if(age<18){
        Assert.fail("Age is not correct");
    }
        System.out.println("Welcome!");}

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }
}
