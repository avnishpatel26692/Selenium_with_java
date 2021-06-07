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

public class Test1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
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
        WebElement numField = driver.findElement(By.id("numb"));
        numField.clear();
        numField.sendKeys("25"); //printing the text

        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click(); // click Result button

        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = resultText.getText();
    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement numField = driver.findElement(By.id("numb"));
        numField.clear();
        numField.sendKeys("105"); //printing the text

        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click(); // click Result button

        WebElement resultText = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = resultText.getText();
    }

    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement numField = driver.findElement(By.id("numb"));
        numField.clear();
        numField.sendKeys("64"); //printing the text

        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click(); // click Result button

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss(); // alert.accept();
        String expectedValue = "Square root of 64 is 8.00";
        Assert.assertEquals(expectedValue, alertMsg);
    }

    @Test
    public void correctSquareRootWithRemainder(){
        WebElement numField = driver.findElement(By.id("numb"));
        numField.clear();
        numField.sendKeys("65"); //printing the text

        WebElement resultButton = driver.findElement(By.className("w3-orange"));
        resultButton.click(); // click Result button

        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss(); // alert.accept();
        String expectedValue = "Square root of 65 is 8.06";
        Assert.assertEquals(expectedValue, alertMsg);
    }




}
