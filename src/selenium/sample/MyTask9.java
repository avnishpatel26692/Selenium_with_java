package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MyTask9 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
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
    public void ccsvalues()
    {
        WebElement butt1 = driver.findElement(By.xpath("//div[@id='standartParagraph']/p[1]"));
        String Expected = "15px";
        Assert.assertEquals(Expected,butt1.getCssValue("font-size"));
        Expected = "Verdana, sans-serif";
        Assert.assertEquals(Expected,butt1.getCssValue("font-family"));
        Expected = "rgba(0, 0, 0, 0)";
        Assert.assertEquals(Expected,butt1.getCssValue("background-color"));



        WebElement butt2 = driver.findElement(By.xpath("//div[@id='standartParagraph']/p[2]"));
        Expected = "15px";
        Assert.assertEquals(Expected,butt2.getCssValue("font-size"));
        Expected = "Verdana, sans-serif";
        Assert.assertEquals(Expected,butt2.getCssValue("font-family"));
        Expected= "rgba(76, 175, 80, 1)";
        Assert.assertEquals(Expected,butt2.getCssValue("background-color"));


        WebElement butt3 = driver.findElement(By.xpath("//div[@id='nonStandartParagraph']/p[1]"));
        Expected = "15px";
        Assert.assertEquals(Expected,butt3.getCssValue("font-size"));
        Expected = "Verdana, sans-serif";
        Assert.assertEquals(Expected,butt3.getCssValue("font-family"));
        Expected = "rgba(103, 58, 183, 1)";
        Assert.assertEquals(Expected,butt3.getCssValue("background-color"));


        WebElement butt4 = driver.findElement(By.xpath("//div[@id='nonStandartParagraph']/p[3]"));
        Expected = "15px";
        Assert.assertEquals(Expected,butt4.getCssValue("font-size"));
        Expected= "Verdana, sans-serif";
        Assert.assertEquals(Expected,butt4.getCssValue("font-family"));
        Expected = "rgba(33, 150, 243, 1)";
        Assert.assertEquals(Expected,butt4.getCssValue("background-color"));

        WebElement butt5 = driver.findElement(By.xpath("//div[@id='nonStandartParagraph']/p[4]"));
        Expected = "15px";
        Assert.assertEquals(Expected,butt5.getCssValue("font-size"));
        Expected = "Verdana, sans-serif";
        Assert.assertEquals(Expected,butt5.getCssValue("font-family"));
        Expected = "rgba(233, 30, 99, 1)";
        Assert.assertEquals(Expected,butt5.getCssValue("background-color"));





    }
}