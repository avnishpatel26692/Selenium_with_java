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

public class FormSampleTasks {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }

    @Test
    public void errorOnNumberTooSmall(){
        WebElement errorOnNumberTooSmall = driver.findElement(By.id("numb"));
        errorOnNumberTooSmall.click();
        String number = "20";
        errorOnNumberTooSmall.sendKeys(number);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement ErrorMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too small";
        String Actual = ErrorMsg.getText();
        Assert.assertEquals(Expected,Actual);
    }

    @Test
    public void errorOnNumberTooBig(){
        WebElement errorOnNumberTooBig = driver.findElement(By.id("numb"));
        errorOnNumberTooBig.click();
        String number = "103";
        errorOnNumberTooBig.sendKeys(number);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement ErrorMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too big";
        String Actual = ErrorMsg.getText();
        Assert.assertEquals(Expected,Actual);
    }

    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement correctSquareRootWithoutRemainder = driver.findElement(By.id("numb"));
        correctSquareRootWithoutRemainder.click();
        String number = "64";
        correctSquareRootWithoutRemainder.sendKeys(number);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss();
        String Expected = "Square root of 64 is 8.00";
        Assert.assertEquals(Expected,alertMsg);
    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement correctSquareRootWithRemainder = driver.findElement(By.id("numb"));
        correctSquareRootWithRemainder.click();
        String number = "70";
        correctSquareRootWithRemainder.sendKeys(number);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss();
        String Expected = "Square root of 70 is 8.37";
        Assert.assertEquals(Expected,alertMsg);
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }
}
