package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
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
    public void findXpath(){
        WebElement e = web.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(e.getText());
    }

    @Test
    public void findCSSpath(){
        WebElement e = web.findElement(By.cssSelector("div#nonStandartText>.amazing"));
        System.out.println(e.getText());
    }

    @Test
    public void findElementByXPath(){
        WebElement e = web.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(e.getText());
        e = web.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(e.getText());
    }

    @Test
    public void findElementByCssName(){
        WebElement e = web.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(e.getText());
        e = web.findElement(By.cssSelector(".text#dummy"));
        System.out.println(e.getText());
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
