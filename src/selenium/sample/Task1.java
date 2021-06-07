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
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear(); //clear the field value
        textBox.sendKeys("27");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = resultText.getText();

        Assert.assertEquals(expectedValue, actualValue);

    }

    // This test fails now because there's a bug on the site
    @Test
    public void errorOnNumberTooSmallBug() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear(); //clear the field value
        textBox.sendKeys("49");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = resultText.getText();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear();
        textBox.sendKeys("101");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = resultText.getText();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear();
        textBox.sendKeys("81");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert = driver.switchTo().alert();
        String expectedValue = "Square root of 81 is 9.00";
        String actualValue = alert.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear();
        textBox.sendKeys("86");
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert = driver.switchTo().alert();
        String expectedValue = "Square root of 86 is 9.27";
        String actualValue = alert.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }
}
