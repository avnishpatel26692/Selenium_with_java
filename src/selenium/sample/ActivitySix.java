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

public class ActivitySix {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().window().maximize();

    }

    @Test
    public void enterNumberMin() {
        WebElement fieldToEnterNumber = driver.findElement(By.id("numb"));
        WebElement fieldToEnterNumber2 = driver.findElement(By.className("w3-orange"));
        fieldToEnterNumber.sendKeys("49");
        fieldToEnterNumber2.click();


        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();

        Assert.assertEquals("Square root of 49 is 7.00", alertMsg);
    }



    @Test
    public void enterInvalidNumberMax() {
        WebElement fieldToEnterNumber = driver.findElement(By.id("numb"));
        WebElement fieldToEnterNumber2 = driver.findElement(By.className("w3-orange"));
        fieldToEnterNumber.sendKeys("101");
        fieldToEnterNumber2.click();

        WebElement faultMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too big";
        String Actual = faultMsg.getText();
        Assert.assertEquals(Expected, Actual);
    }

    @Test
    public void enterInvalidNumberNormal() {
        WebElement fieldToEnterNumber = driver.findElement(By.id("numb"));
        WebElement fieldToEnterNumber2 = driver.findElement(By.className("w3-orange"));
        fieldToEnterNumber.sendKeys("14");
        fieldToEnterNumber2.click();

        WebElement faultMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too small";
        String Actual = faultMsg.getText();
        Assert.assertEquals(Expected, Actual);
    }
}