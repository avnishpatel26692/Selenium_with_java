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

public class Sample8Task {
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
        WebElement e1 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize = e1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize);
        System.out.println(e1.getCssValue("font-family"));
        System.out.println(e1.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)",e1.getCssValue("background-color") );
        System.out.println(e1.getCssValue("padding-left"));
    }

    @Test
    public void verifyBackgroundColor()
    {
        WebElement par7 = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue = par7.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
    }

    @Test
    public void browserFunctionalities() throws InterruptedException {
        Thread.sleep(2500);
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
    public void checkBackgroundColor()
    {

        WebElement par1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = par1.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualValue);

        WebElement par2 = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = par2.getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", actualValue2);

        WebElement par3 = driver.findElement(By.xpath("//p[text()='paragraph 3']"));
        String actualValue3 = par3.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualValue3);

        WebElement par4 = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = par4.getCssValue("background-color");
        Assert.assertEquals("rgba(103, 58, 183, 1)", actualValue4);

        WebElement par7 = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue7 = par7.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue7);

    }

    @Test
    public void checkFontFamily()
    {

        WebElement par1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = par1.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue);

        WebElement par2 = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = par2.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue2);

        WebElement par4 = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = par4.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue4);

        WebElement par6 = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = par6.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue6);

    }

    @Test
    public void checkFontSize()
    {
        WebElement par1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = par1.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue);

        WebElement par2 = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = par2.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue2);

        WebElement par4 = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = par4.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue4);

        WebElement par6 = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = par6.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue6);
    }

}