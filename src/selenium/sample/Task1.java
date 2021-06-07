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

import java.awt.*;

public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "//lib//";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
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
    public void onNumberTooSmall() throws InterruptedException {
       WebElement numberTextBox = driver.findElement(By.id("numb"));
       numberTextBox.sendKeys("31");
       WebElement submit = driver.findElement(By.className("w3-orange"));
       submit.click();
       WebElement errorMsg = driver.findElement(By.id("ch1_error"));
       String expectedValue = "Number is too small";
       String actualValue = errorMsg.getText();
       Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void onNumberTooBig(){
        WebElement numberTextBox = driver.findElement(By.id("numb"));
        numberTextBox.sendKeys("371");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = errorMsg.getText();
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void squareRootWithoutRemainder() {
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys("72");
        button.click();
        Alert alert = driver.switchTo().alert();
        String realMessage = alert.getText();
        Assert.assertTrue(realMessage.contains("8.49"));
        alert.accept();
        Assert.assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }

    @Test
    public void squareRootWithRemainder(){
        WebElement element1 = driver.findElement(By.id("numb"));
        WebElement element2 = driver.findElement(By.className("w3-orange"));
        element1.sendKeys("89");
        element2.click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        Assert.assertEquals("Square root of 89 is 9.43",msg);
    }


}
