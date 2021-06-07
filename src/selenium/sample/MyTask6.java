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

public class MyTask6 {

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
    public void Smallnumber() throws InterruptedException {
        WebElement numfield = driver.findElement(By.id("numb"));
        numfield.click();
        String input = "15";
        numfield.sendKeys(input);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement ErrMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too small";
        String Actual = ErrMsg.getText();
        Assert.assertEquals(Expected,Actual);

    }
    @Test
    public void HugeNumber()
    {
        WebElement numfield = driver.findElement(By.id("numb"));
        numfield.click();
        String input = "152";
        numfield.sendKeys(input);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        WebElement ErrMsg = driver.findElement(By.id("ch1_error"));
        String Expected = "Number is too big";
        String Actual = ErrMsg.getText();
        Assert.assertEquals(Expected,Actual);
    }


@Test
    public void ValidNumberWithNoReminder()
    {
        WebElement numfield = driver.findElement(By.id("numb"));
        numfield.click();
        String input = "64";
        numfield.sendKeys(input);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert  = driver.switchTo().alert();
        String alertmsg = alert.getText();
        alert.dismiss();
        WebElement ErrMsg = driver.findElement(By.id("ch1_error"));
        Assert.assertFalse(ErrMsg.isDisplayed());
        String Expected = "Square root of 64 is 8.00";
        Assert.assertEquals(Expected,alertmsg);
    }
    @Test
    public void ValidNumberWithReminder()
    {
        WebElement numfield = driver.findElement(By.id("numb"));
        numfield.click();
        String input = "65";
        numfield.sendKeys(input);
        WebElement submit = driver.findElement(By.className("w3-orange"));
        submit.click();
        Alert alert  = driver.switchTo().alert();
        String alertmsg = alert.getText();
        alert.dismiss();
        WebElement ErrMsg = driver.findElement(By.id("ch1_error"));
        Assert.assertFalse(ErrMsg.isDisplayed());
        String Expected = "Square root of 65 is 8.06";
        Assert.assertEquals(Expected,alertmsg);
    }


}