package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample3Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/locators");
        web.manage().window().maximize();
    }

    @Test
    public void assertEqualsMethod(){
        WebElement e = web.findElement(By.id("heading_1"));
        Assert.assertEquals("Heading 1",e.getText());
    }

    @Test
    public void assertTrueMethod(){
        String v = web.findElement(By.name("randomButton2")).getAttribute("value");
        String e = "This is also a button";
        Assert.assertTrue(e.equalsIgnoreCase(v));
    }

    @Test
    public void assertFalse(){
        String v = web.findElement(By.name("randomButton1")).getAttribute("value");
        String e = "This is not a button";
        Assert.assertFalse(e.equalsIgnoreCase(v));
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
