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
        Thread.sleep(2500);
        driver.quit();
    }


    @Test
    public void checkNumberTooSmall() {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("48");
        WebElement clickButton = driver.findElement(By.className("w3-orange"));
        clickButton.click();

        WebElement message = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = message.getText();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkNumberTooBig() {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("180");
        WebElement clickButton = driver.findElement(By.className("w3-orange"));
        clickButton.click();

        WebElement message = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = message.getText();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkSquareRootWithoutRemainder() {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("81");
        WebElement clickButton = driver.findElement(By.className("w3-orange"));
        clickButton.click();

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.dismiss();
        String expectedValue = "Square root of 81 is 9.00";

        Assert.assertEquals(expectedValue, alertMessage);
    }

    @Test
    public void checkSquareRootWithRemainder() {
        WebElement inputField = driver.findElement(By.id("numb"));
        inputField.sendKeys("80");
        WebElement clickButton = driver.findElement(By.className("w3-orange"));
        clickButton.click();

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.dismiss();
        String expectedValue = "Square root of 80 is 8.94";

        Assert.assertEquals(expectedValue, alertMessage);
    }

}
