
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

public class Sample8Task
{
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
    public void checkBackgroundColor()
    {
        // checking the 1st paragraph
        WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = Paragraph1Label.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualValue);

        //  checking the 2nd paragraph
        WebElement Paragraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = Paragraph2Label.getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", actualValue2);

        //  checking the 3rd paragraph
        WebElement Paragraph3Label = driver.findElement(By.xpath("//p[text()='paragraph 3']"));
        String actualValue3 = Paragraph3Label.getCssValue("background-color");
        //System.out.println(actualValue3);
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualValue3);

        //  checking the 4th paragraph
        WebElement Paragraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = Paragraph4Label.getCssValue("background-color");
        //System.out.println(actualValue4);
        Assert.assertEquals("rgba(103, 58, 183, 1)", actualValue4);

        //  checking the  6th paragraph
        WebElement Paragraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = Paragraph6Label.getCssValue("background-color");
        System.out.println(actualValue6);
        Assert.assertEquals("rgba(33, 150, 243, 1)", actualValue6);

    }

    @Test
    public void checkFontFamily()
    {
        // checking the 1st paragraph
        WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = Paragraph1Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue);

        //  checking the 2nd paragraph
        WebElement Paragraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = Paragraph2Label.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualValue2);

        //  checking the 4th paragraph
        WebElement Paragraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = Paragraph4Label.getCssValue("font-family");
        //System.out.println(actualValue4);
        Assert.assertEquals("Verdana, sans-serif", actualValue4);

        //  checking the  6th paragraph
        WebElement Paragraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = Paragraph6Label.getCssValue("font-family");
        System.out.println(actualValue6);
        Assert.assertEquals("Verdana, sans-serif", actualValue6);
    }

    @Test
    public void checkFontSize()
    {
        // checking the 1st paragraph
        WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = Paragraph1Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue);

        //  checking the 2nd paragraph
        WebElement Paragraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = Paragraph2Label.getCssValue("font-size");
        Assert.assertEquals("15px", actualValue2);

        //  checking the 4th paragraph
        WebElement Paragraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = Paragraph4Label.getCssValue("font-size");
        //System.out.println(actualValue4);
        Assert.assertEquals("15px", actualValue4);

        //  checking the  6th paragraph
        WebElement Paragraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = Paragraph6Label.getCssValue("font-size");
        //System.out.println(actualValue6);
        Assert.assertEquals("15px", actualValue6);
    }

}