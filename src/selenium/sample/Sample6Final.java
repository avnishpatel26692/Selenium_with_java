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

public class Sample6Final {

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
    @Test
    public void tooSmallNR(){
    WebElement textbox = driver.findElement(By.id("numb"));
    textbox.sendKeys("48");
    WebElement submitButton = driver.findElement(By.className("w3-orange"));
    submitButton.click();
    WebElement errorMessage = driver.findElement(By.id("ch1_error"));
    String expectedValue = "Number is too small";
    String actualValue = errorMessage.getText();
    Assert.assertTrue(actualValue.contains(expectedValue));

    }
    @Test
    public void tooBigNR() {
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("102");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = errorMessage.getText();
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void correctRoot(){
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("64");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        String expectedValue = "Square root of 64 is 8.00";
        Assert.assertEquals(expectedValue, alertMsg);

    }
    @Test
    public void nrWithNoRoot(){
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("60");
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        String expectedValue = "Square root of 60 is 7.75";
        Assert.assertEquals(expectedValue, alertMsg);

    }


    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }
}