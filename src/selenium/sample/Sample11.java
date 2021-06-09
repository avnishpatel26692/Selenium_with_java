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

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/loading_color");
        web.manage().window().maximize();
    }

    @Test
    public void waitTask(){
        WebElement button = web.findElement(By.xpath("//button[@id='start_green']"));
        WebDriverWait wait = new WebDriverWait(web, 10);

        button.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
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
