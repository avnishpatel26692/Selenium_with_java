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

    ///Test needs to be cover:
    //validate for paragraph 1,2,4,6 & 7
    //Check Background color
    //check font family
    //check font size

    @Test
    public void checkBackgroundColor(){
        WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualValue = Paragraph1Label.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", actualValue);}
    @Test
        public void checkBackgroundColor2(){
        WebElement Paragraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualValue2 = Paragraph2Label.getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", actualValue2);}
    @Test
        public void checkBackgroundColor4(){
        WebElement Paragraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualValue4 = Paragraph4Label.getCssValue("background-color");
        Assert.assertEquals("rgba(103, 58, 183, 1)", actualValue4);}
    @Test
        public void checkBackgroundColor6(){
        WebElement Paragraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualValue6 = Paragraph6Label.getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", actualValue6);}
    @Test
        public void checkBackgroundColor7(){
        WebElement luckParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualValue7 = luckParagraph7Label.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue7);}

    @Test
        public void checkFontFamily(){
            WebElement FontFam1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
            String actualValue = FontFam1Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif",actualValue);

            WebElement FontFam2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
            String actualValue2 = FontFam2Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif",actualValue2);

            WebElement FontFam4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
            String actualValue4 = FontFam4Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif",actualValue4);

            WebElement FontFam6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
            String actualValue6 = FontFam6Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif",actualValue6);

            WebElement FontFam7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
            String actualValue7 = FontFam7Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif",actualValue7);
        }
    @Test
        public void checkFontSize(){
            WebElement FontSize1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
            String actualValue = FontSize1Label.getCssValue("font-size");
            Assert.assertEquals("15px",actualValue);

            WebElement FontSize2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
            String actualValue2 = FontSize2Label.getCssValue("font-size");
            Assert.assertEquals("15px",actualValue2);

            WebElement FontSize4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
            String actualValue4 = FontSize4Label.getCssValue("font-size");
            Assert.assertEquals("15px",actualValue4);

            WebElement FontSize6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
            String actualValue6 = FontSize6Label.getCssValue("font-size");
            Assert.assertEquals("15px",actualValue6);

            WebElement FontSize7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
            String actualValue7 = FontSize7Label.getCssValue("font-size");
            Assert.assertEquals("15px",actualValue7);

        }

    }

