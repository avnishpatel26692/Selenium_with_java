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

public class Tasks {
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

        element1.sendKeys("1");
        element2.click();
        Assert.assertTrue(element3.isDisplayed());
        Assert.assertEquals("Number is too small",element3.getText());
    }

    @Test
    public void errorOnNumberTooBig(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));
        WebElement element3 = web.findElement(By.id("ch1_error"));

        element1.sendKeys("999");
        element2.click();
        Assert.assertTrue(element3.isDisplayed());
        Assert.assertEquals("Number is too big",element3.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));

        element1.sendKeys("64");
        element2.click();

        Alert alert = web.switchTo().alert();
        Assert.assertEquals("Square root of 64 is 8.00",alert.getText());
    }

    @Test
    public void correctSquareRootWithRemainder(){
        WebElement element1 = web.findElement(By.id("numb"));
        WebElement element2 = web.findElement(By.className("w3-orange"));

        element1.sendKeys("50");
        element2.click();

        Alert alert = web.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        Assert.assertEquals("Square root of 50 is 7.07",msg);
    }

    @After
    public void afterMethod(){
        try {
            Thread.sleep(2500);
        }
        catch(Exception e){};
        web.close();
    }
}
