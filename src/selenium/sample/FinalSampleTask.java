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

public class FinalSampleTask {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/tasks/enter_a_number");
        web.manage().window().maximize();
    }

    @Test
    public void errorOnNumberTooSmall(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));
        WebElement element3 = web.findElement(By.id("ch1_error"));

        element1.sendKeys("7");
        element2.click();
        Assert.assertTrue(element3.isDisplayed());
        Assert.assertEquals("Number is too small",element3.getText());
    }

    @Test
    public void errorOnNumberTooBig(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));
        WebElement element3 = web.findElement(By.id("ch1_error"));

        element1.sendKeys("969");
        element2.click();
        Assert.assertTrue(element3.isDisplayed());
        Assert.assertEquals("Number is too big",element3.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement inputField = web.findElement(By.id("numb"));
        WebElement button = web.findElement(By.className("w3-btn"));
        inputField.sendKeys("64");
        button.click();
        Alert alert = web.switchTo().alert();
        String realMessage = alert.getText();
        Assert.assertTrue(realMessage.contains("8.00"));
        alert.accept();
        Assert.assertFalse(web.findElement(By.id("ch1_error")).isDisplayed());
    }

    @Test
    public void correctSquareRootWithRemainder(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));

        element1.sendKeys("66");
        element2.click();

        Alert alert = web.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        Assert.assertEquals("Square root of 66 is 8.12",msg);
    }

    @After
    public void afterMethod(){
        try {
            Thread.sleep(5000);
        }
        catch(Exception e){};
        web.close();
    }
}