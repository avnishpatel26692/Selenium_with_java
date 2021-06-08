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

//        Test needs to be cover:
//        validate for paragraph 1,2,4,6 & 7
//
//        Check Background color
//        check font family
//        check font size
    }
    @Test
    public void paragraph1(){
        WebElement paragraph1Check = driver.findElement(By.xpath("//*[@id='standartParagraph']/p[1]"));
        String actualValue = paragraph1Check.getCssValue("background-color");
        String actualValueFontSize = paragraph1Check.getCssValue("font-size");
        String actualValueFontFamily = paragraph1Check.getCssValue("font-family");


        String expectedResult = "rgba(0, 0, 0, 0)";
        String expectedResultFontSize = "15px";
        String expectedResultFontFamily = "Verdana, sans-serif";


        System.out.println(paragraph1Check.getCssValue("background-color"));
        System.out.println(paragraph1Check.getCssValue("font-size"));
        System.out.println(paragraph1Check.getCssValue("font-family"));


        Assert.assertEquals(actualValue, expectedResult);
        Assert.assertEquals(actualValueFontSize, expectedResultFontSize);
        Assert.assertEquals(actualValueFontFamily, expectedResultFontFamily);
    }
    @Test
    public void paragraph2() {
        WebElement paragraph2Check = driver.findElement(By.xpath("//*[@id='standartParagraph']/p[2]"));
        String actualValue = paragraph2Check.getCssValue("background-color");
        String actualValueFontSize = paragraph2Check.getCssValue("font-size");
        String actualValueFontFamily = paragraph2Check.getCssValue("font-family");


        String expectedResult = "rgba(76, 175, 80, 1)";
        String expectedResultFontSize = "15px";
        String expectedResultFontFamily = "Verdana, sans-serif";


        System.out.println(paragraph2Check.getCssValue("background-color"));
        System.out.println(paragraph2Check.getCssValue("font-size"));
        System.out.println(paragraph2Check.getCssValue("font-family"));


        Assert.assertEquals(actualValue, expectedResult);
        Assert.assertEquals(actualValueFontSize, expectedResultFontSize);
        Assert.assertEquals(actualValueFontFamily, expectedResultFontFamily);
    }
    @Test
    public void paragraph4() {
        WebElement paragraph4Check = driver.findElement(By.xpath("//*[@id='nonStandartParagraph']/p[1]"));
        String actualValue = paragraph4Check.getCssValue("background-color");
        String actualValueFontSize = paragraph4Check.getCssValue("font-size");
        String actualValueFontFamily = paragraph4Check.getCssValue("font-family");


        String expectedResult = "rgba(103, 58, 183, 1)";
        String expectedResultFontSize = "15px";
        String expectedResultFontFamily = "Verdana, sans-serif";


        System.out.println(paragraph4Check.getCssValue("background-color"));
        System.out.println(paragraph4Check.getCssValue("font-size"));
        System.out.println(paragraph4Check.getCssValue("font-family"));


        Assert.assertEquals(actualValue, expectedResult);
        Assert.assertEquals(actualValueFontSize, expectedResultFontSize);
        Assert.assertEquals(actualValueFontFamily, expectedResultFontFamily);
    }
    @Test
    public void paragraph6() {
        WebElement paragraph6Check = driver.findElement(By.cssSelector("#cool"));
        String actualValue = paragraph6Check.getCssValue("background-color");
        String actualValueFontSize = paragraph6Check.getCssValue("font-size");
        String actualValueFontFamily = paragraph6Check.getCssValue("font-family");


        String expectedResult = "rgba(33, 150, 243, 1)";
        String expectedResultFontSize = "15px";
        String expectedResultFontFamily = "Verdana, sans-serif";


        System.out.println(paragraph6Check.getCssValue("background-color"));
        System.out.println(paragraph6Check.getCssValue("font-size"));
        System.out.println(paragraph6Check.getCssValue("font-family"));


        Assert.assertEquals(actualValue, expectedResult);
        Assert.assertEquals(actualValueFontSize, expectedResultFontSize);
        Assert.assertEquals(actualValueFontFamily, expectedResultFontFamily);
    }
    @Test
    public void paragraph7() {
        WebElement paragraph7Check = driver.findElement(By.cssSelector("#nonStandartParagraph > p.paragraph.lucky.w3-pink"));
        String actualValue = paragraph7Check.getCssValue("background-color");
        String actualValueFontSize = paragraph7Check.getCssValue("font-size");
        String actualValueFontFamily = paragraph7Check.getCssValue("font-family");

        String expectedResult = "rgba(233, 30, 99, 1)";
        String expectedResultFontSize = "15px";
        String expectedResultFontFamily = "Verdana, sans-serif";

        System.out.println(paragraph7Check.getCssValue("background-color"));
        System.out.println(paragraph7Check.getCssValue("font-size"));
        System.out.println(paragraph7Check.getCssValue("font-family"));

        Assert.assertEquals(actualValue, expectedResult);
        Assert.assertEquals(actualValueFontSize, expectedResultFontSize);
        Assert.assertEquals(actualValueFontFamily, expectedResultFontFamily);

    }


}
