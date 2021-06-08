package selenium.sample.ActivityDayTwo;

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

public class ActivityDayThreeSecondTask {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
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
    public void verifyFontSize()
    {
        WebElement element1 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)",element1.getCssValue("background-color") );
        System.out.println(element1.getCssValue("padding-left"));
    }

    @Test
    public void verifyBackgroundColor()
    {
        WebElement luckParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = luckParagraph7Label.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
    }
    @Test
    public void verifyBackgroundColorGreen()
    {
        WebElement element2 = driver.findElement(By.cssSelector("p.w3-green"));
        String actualFontSize = element2.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element2.getCssValue("font-family"));
        System.out.println(element2.getCssValue("background-color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)",element2.getCssValue("background-color") );
            }


    @Test
    public void verifyBackgroundColorBlue()
    {
        WebElement element2 = driver.findElement(By.cssSelector("p.w3-blue"));
        String actualFontSize = element2.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element2.getCssValue("font-family"));
        System.out.println(element2.getCssValue("background-color"));
        Assert.assertEquals("rgba(33, 150, 243, 1)",element2.getCssValue("background-color") );
    }

    @Test
    public void verifyBackgroundColorPink()
    {
        WebElement element2 = driver.findElement(By.cssSelector("p.w3-pink"));
        String actualFontSize = element2.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element2.getCssValue("font-family"));
        System.out.println(element2.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)",element2.getCssValue("background-color") );
    }
    @Test
    public void verifyBackgroundColorEmpty() {
        WebElement element2 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualFontSize = element2.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(element2.getCssValue("font-family"));
        System.out.println(element2.getCssValue("background-color"));
        Assert.assertEquals("rgba(0, 0, 0, 0)",element2.getCssValue("background-color") );
    }

}