package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;


public class Sample8 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/tasks/locators_different");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyFontSize(){
        WebElement element1 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = element1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        Assert.assertEquals("rgba(103, 58, 183, 1)", element1.getCssValue("background-color"));

        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element1.getCssValue("background-color"));
        System.out.println(element1.getCssValue("padding-left"));
    }

    @Test
    public void verifyBackgroundColor(){
        WebElement luckyParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = luckyParagraph7Label.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
    }

    @Test
    public void browserFunctionalities() throws InterruptedException {
        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);
        driver.navigate().back();
        Thread.sleep(2500);
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.navigate().forward();
        Thread.sleep(2500);
        driver.navigate().refresh();
    }

    @Test
    public void verifyParagraph1() {
        WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualBGColor = Paragraph1Label.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualBGColor);
        String actualFontFamily = Paragraph1Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
        String actualFontSize = Paragraph1Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

    @Test
    public void verifyParagraph2() {
        WebElement luckyParagraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue = luckyParagraph2Label.getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", actualValue);
        String actualFontFamily = luckyParagraph2Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
        String actualFontSize = luckyParagraph2Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

    @Test
    public void verifyParagraph4() {
        WebElement luckyParagraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue = luckyParagraph4Label.getCssValue("background-color");
        Assert.assertEquals("rgba(103, 58, 183, 1)", actualValue);
        String actualFontFamily = luckyParagraph4Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
        String actualFontSize = luckyParagraph4Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

    @Test
    public void verifyParagraph6BGColor() {
        WebElement coolParagraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue = coolParagraph6Label.getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", actualValue);
        String actualFontFamily = coolParagraph6Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
        String actualFontSize = coolParagraph6Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

    @Test
    public void verifyParagraph7BGColor() {
        WebElement luckyParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = luckyParagraph7Label.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
        String actualFontFamily = luckyParagraph7Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
        String actualFontSize = luckyParagraph7Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
