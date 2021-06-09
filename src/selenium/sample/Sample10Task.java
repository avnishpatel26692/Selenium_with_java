package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sample10Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/sync");
        web.manage().window().maximize();
    }

    @Test
    public void threadSleepWait(){
        try {
            Thread.sleep(10000);
            WebElement element = web.findElement(By.xpath("//p"));
        }
        catch(Exception e){};
    }

    @Test
    public void implicitWait(){
        web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = web.findElement(By.xpath("//p[text()='dev magic']"));
    }

    @Test
    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(web,10);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style","color: rgb(119, 119, 119)"));
    }

    @Test
    public void explicitWait2(){
        WebDriverWait wait = new WebDriverWait(web,10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='changes color']")));
    }

    @Test
    public void explicitWait3(){
        WebDriverWait wait = new WebDriverWait(web,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@style='color: rgb(119, 119, 119);']")));
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
