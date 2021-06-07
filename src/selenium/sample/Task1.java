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

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
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
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void enterNumberUnder50() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear(); // clear the field value
        textBox.sendKeys("10");
        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expected = "Number is too small";
        String actual = resultText.getText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void enterNumberOver100() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear();
        textBox.sendKeys("150");
        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expected = "Number is too big";
        String actual = resultText.getText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void enterNumberWithSquareRootNoRemainder() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear(); // clear the field value
        textBox.sendKeys("64");
        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss();

        String expected = "Square root of 64 is 8.00";

        Assert.assertEquals(expected, alertMsg);
    }

    @Test
    public void enterNumberWithSquareRootWithRemainder() {
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.clear(); // clear the field value
        textBox.sendKeys("55");
        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click();

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss();

        String expected = "Square root of 55 is 7.42";

        Assert.assertEquals(expected, alertMsg);
    }
}
