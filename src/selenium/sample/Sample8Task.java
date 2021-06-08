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
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void verifyBackgroundColor() {
        WebElement BackgroundColor1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualColor1 = BackgroundColor1.getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", BackgroundColor1.getCssValue("background-color"));

        WebElement BackgroundColor2 = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
        String actualColor2 = BackgroundColor2.getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", BackgroundColor2.getCssValue("background-color"));

        WebElement BackgroundColor3 = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
        String actualColor3 = BackgroundColor3.getCssValue("background-color");
        Assert.assertEquals("rgba(103, 58, 183, 1)", actualColor3);

        WebElement BackgroundColor4 = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
        String actualColor4 = BackgroundColor4.getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", actualColor4);

        WebElement BackgroundColor5 = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
        String actualColor5 = BackgroundColor5.getCssValue("background-color");
        Assert.assertEquals("rgba(233, 30, 99, 1)", actualColor5);


        System.out.println(BackgroundColor1.getCssValue("background-color"));
        System.out.println(BackgroundColor2.getCssValue("background-color"));
        System.out.println(BackgroundColor3.getCssValue("background-color"));
        System.out.println(BackgroundColor4.getCssValue("background-color"));
        System.out.println(BackgroundColor5.getCssValue("background-color"));
    }


    @Test
    public void verifyFontFamily1() {
        WebElement element1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualFontFamily1 = element1.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily1);

        WebElement element2 = driver.findElement(By.cssSelector("p.w3-green"));
        String actualFontFamily2 = element2.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily2);

        WebElement element3 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontFamily3 = element3.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily3);

        WebElement element4 = driver.findElement(By.cssSelector("p.w3-blue"));
        String actualFontFamily4 = element4.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily4);

        WebElement element5 = driver.findElement(By.cssSelector("p.w3-pink"));
        String actualFontFamily5 = element5.getCssValue("font-family");
        Assert.assertEquals("Verdana, sans-serif", actualFontFamily5);


        System.out.println(element1.getCssValue("font-family"));
        System.out.println(element2.getCssValue("font-family"));
        System.out.println(element3.getCssValue("font-family"));
        System.out.println(element4.getCssValue("font-family"));
        System.out.println(element5.getCssValue("font-family"));
    }


    @Test
    public void verifyFontSize() {
        WebElement size1 = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
        String actualFontSize1 = size1.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize1);

        WebElement size2 = driver.findElement(By.cssSelector("p.w3-green"));
        String actualFontSize2 = size2.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize2);

        WebElement size3 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        String actualFontSize3 = size3.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize3);

        WebElement size4 = driver.findElement(By.cssSelector("p.w3-blue"));
        String actualFontSize4 = size4.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize4);

        WebElement size5 = driver.findElement(By.cssSelector("p.w3-pink"));
        String actualFontSize5 = size5.getCssValue("font-size");
        Assert.assertEquals("15px", actualFontSize5);

        System.out.println(size1.getCssValue("font-size"));
        System.out.println(size2.getCssValue("font-size"));
        System.out.println(size3.getCssValue("font-size"));
        System.out.println(size4.getCssValue("font-size"));
        System.out.println(size5.getCssValue("font-size"));
    }


    @Test
    public void browserFunctionalities() throws InterruptedException {
        driver.navigate().to("https://kristinek.github.io/site/");
        Thread.sleep(2500);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2500);
        driver.manage().window().setSize(new Dimension((900), (1200)));
        driver.navigate().to("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.navigate().forward();
        Thread.sleep(2500);
        driver.navigate().refresh();
    }

}
