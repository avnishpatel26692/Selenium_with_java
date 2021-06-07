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

public class FormSample {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
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
    public void errorOnNumberTooSmall(){
        WebElement enterValue = driver.findElement(By.id("numb"));
        enterValue.sendKeys("11");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String expectedResult = " Number is too small";
        String actualResult = errorMessage.getText();
    }

    @Test
    public void errorOnNumberTooBig(){
        WebElement enterValue = driver.findElement(By.id("numb"));
        enterValue.sendKeys("111");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String expectedResult = " Number is too big";
        String actualResult = errorMessage.getText();
    }

    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement enterValue = driver.findElement(By.id("numb"));
        enterValue.sendKeys("64");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();

        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        String expectedValue = "Square root of 64 is 8.00";
        Assert.assertEquals(expectedValue, msg);

    }

    @Test
    public void correctSquareRootWithRemainder(){
        WebElement enterValue = driver.findElement(By.id("numb"));
        enterValue.sendKeys("66");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();

        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        String expectedValue = "Square root of 66 is 8.12";
        Assert.assertEquals(expectedValue, msg);

    }

}