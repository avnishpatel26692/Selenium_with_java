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
    public void test1(){
        String number = "10";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.xpath("//button"));
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));

        inputField.sendKeys(number);
        submitButton.click();

        String expectedError = "Number is too small";
        String actualValue = errorMessage.getText();
        Assert.assertTrue(expectedError.equals(actualValue));







    }
}