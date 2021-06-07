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


public class FormSample {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys("48"); //49 is accepted, even though it shouldn't be.
        button.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String realValue = errorMessage.getText();
        Assert.assertEquals(expectedValue, realValue);

    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys("101");
        button.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String realValue = errorMessage.getText();
        Assert.assertEquals(expectedValue, realValue);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys("64");
        button.click();
        Alert alert = driver.switchTo().alert();
        String realMessage = alert.getText();
        Assert.assertTrue(realMessage.contains("8.00"));
        alert.accept();
        Assert.assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys("51");
        button.click();
        Alert alert = driver.switchTo().alert();
        String realMessage = alert.getText();
        Assert.assertTrue(realMessage.contains("7.14"));
        alert.accept();
        Assert.assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
