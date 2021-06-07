package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/actions");
        web.manage().window().maximize();
    }

    @Test
    public void clickALink(){
        WebElement element = web.findElement(By.id("link1"));
        element.click();
        String v = web.findElement(By.id("h1")).getText();
        String e = "Link Page 1";
        Assert.assertEquals(e,v);
    }

    @Test
    public void clickOnButton(){
        WebElement element1 = web.findElement(By.id("show_text"));
        WebElement element2 = web.findElement(By.name("hide_text"));
        WebElement element3 = web.findElement(By.id("show_me"));
        element1.click();
        Assert.assertFalse(element1.isEnabled());
        Assert.assertTrue(element2.isEnabled());
        Assert.assertTrue(element3.isDisplayed());
        element2.click();
        Assert.assertTrue(element1.isEnabled());
        Assert.assertFalse(element2.isEnabled());
        Assert.assertFalse(element3.isDisplayed());
    }

    @Test
    public void textInput(){
        WebElement element1 = web.findElement(By.id("text"));
        WebElement element2 = web.findElement(By.id("result_text"));
        WebElement element3 = web.findElement(By.id("result_button_text"));
        element1.clear();
        element1.sendKeys("Some text for test");
        element3.click();
        String v = element2.getText();
        String e = "Some text for test";
        Assert.assertTrue(v.contains(e));
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
