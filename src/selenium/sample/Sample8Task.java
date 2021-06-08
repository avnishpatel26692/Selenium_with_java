package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample8Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/tasks/locators_different");
        web.manage().window().maximize();
    }

    @Test
    public void Style(){
        WebElement paragraph1 = web.findElement(By.xpath("//p[text()='paragraph 1']"));
        WebElement paragraph2 = web.findElement(By.xpath("//p[contains(@class,'w3-green')]"));
        WebElement paragraph4 = web.findElement(By.xpath("//p[contains(@class,'crazy')]"));
        WebElement paragraph6 = web.findElement(By.xpath("//p[@id='cool']"));
        WebElement paragraph7 = web.findElement(By.xpath("//p[contains(@class,'lucky')]"));

        Assert.assertEquals("rgba(0, 0, 0, 0)",paragraph1.getCssValue("background-color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)",paragraph2.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)",paragraph4.getCssValue("background-color"));
        Assert.assertEquals("rgba(33, 150, 243, 1)",paragraph6.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)",paragraph7.getCssValue("background-color"));

        Assert.assertEquals("Verdana, sans-serif",paragraph1.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",paragraph2.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",paragraph4.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",paragraph6.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",paragraph7.getCssValue("font-family"));

        Assert.assertEquals("15px",paragraph1.getCssValue("font-size"));
        Assert.assertEquals("15px",paragraph2.getCssValue("font-size"));
        Assert.assertEquals("15px",paragraph4.getCssValue("font-size"));
        Assert.assertEquals("15px",paragraph6.getCssValue("font-size"));
        Assert.assertEquals("15px",paragraph7.getCssValue("font-size"));
    }

    @Test
    public void Browser(){
        web.navigate().to("https://kristinek.github.io/site/examples/locators");
        web.navigate().back();
        web.navigate().forward();
        web.navigate().refresh();
        web.manage().window().setSize(new Dimension(1920,1080));
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
