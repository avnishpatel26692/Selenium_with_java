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

public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void errorOnNumberIsTooSmall() {
        String num = "45";
        WebElement toEnterSmallNum = driver.findElement(By.id("numb"));
        toEnterSmallNum.click();
        toEnterSmallNum.sendKeys(num);
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        submitButton.click();
        WebElement numIsTooSmall = driver.findElement(By.id("ch1_error"));
        String expectedResult = "Number is too small";
        String actualResult = numIsTooSmall.getText();
        Assert.assertTrue(actualResult.contains(actualResult));

    }
    @Test
    public void errorOnNumberIsTooBig() {
        String num = "105";
        WebElement toEnterSmallNum = driver.findElement(By.id("numb"));
        toEnterSmallNum.click();
        toEnterSmallNum.sendKeys(num);
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        submitButton.click();
        WebElement numIsTooSmall = driver.findElement(By.id("ch1_error"));
        String expectedResult = "Number is too big";
        String actualResult = numIsTooSmall.getText();
        Assert.assertTrue(actualResult.contains(actualResult));

    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        String num = "100";
        WebElement toEnterSmallNum = driver.findElement(By.id("numb"));
        toEnterSmallNum.click();
        toEnterSmallNum.sendKeys(num);
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        String expectedResult = "Square root of 100 is 10.00";
        String actualResult = alert.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        alert.accept();
    }
    @Test
    public void correctSquareRootWithRemainder(){
        String num = "98";
        WebElement toEnterSmallNum = driver.findElement(By.id("numb"));
        toEnterSmallNum.click();
        toEnterSmallNum.sendKeys(num);
        WebElement submitButton = driver.findElement(By.className("w3-btn"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        alert.getText();
        String expectedResult = "Square root of 98 is 9.90";
        String actualResult = alert.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        alert.accept();


    }










}
