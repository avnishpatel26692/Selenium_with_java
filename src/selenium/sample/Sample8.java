package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample8 {
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
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void verifyFontSize(){
        WebElement fontSizeElememt = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = fontSizeElememt.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        Assert.assertEquals("rgba(103, 58, 183, 1)", fontSizeElememt.getCssValue("background-color"));

        System.out.println(fontSizeElememt.getCssValue("font-family"));
        System.out.println(fontSizeElememt.getCssValue("background-color"));
        System.out.println(fontSizeElememt.getCssValue("padding-left"));
    }
    @Test
    public void verifyBackgroundColor() {
        WebElement coolParagraph6 = driver.findElement(By.xpath("//*[@id='cool']"));
        String actualValue = coolParagraph6.getCssValue("background-color");
        System.out.println(coolParagraph6.getCssValue("background-color"));
        Assert.assertEquals("rgba(33, 150, 243, 1)", actualValue);
    }
    @Test
    public void fontSizeChecker(){
        WebElement crazyParagraph4Size = driver.findElement(By.cssSelector("#nonStandartParagraph > p.paragraph.crazy.w3-deep-purple"));
        System.out.println(crazyParagraph4Size.getCssValue("font-size"));
        WebElement coolParagraph6Family = driver.findElement(By.cssSelector("#cool"));
        System.out.println(coolParagraph6Family.getCssValue("font-family"));
    }

    @Test
    public void functionalBrowser(){
        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.manage().window().maximize();


    }
}
