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
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
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
    public void ShowButton()
    {
        WebElement a1 = driver.findElement(By.id("show_text"));
        a1.click();
        WebElement a2 = driver.findElement(By.name("hide_text"));
        WebElement a3 = driver.findElement(By.id("show_me"));



//        validating Element is displayed on screen
        a1.click();
        Assert.assertTrue(a3.isDisplayed());
        Assert.assertTrue(a1.isEnabled());

        a2.click();
        Assert.assertFalse(a3.isDisplayed());
        a1.click();
        Assert.assertTrue(a3.isDisplayed());
        Assert.assertTrue(a3.getText().contains("I am here!"));

    }
    @Test
    public void MyTest2()
    {
        WebElement a1 = driver.findElement(By.name("vfb-5"));
        WebElement a2 = driver.findElement(By.id("result_button_text"));
        WebElement a3 = driver.findElement(By.id("result_text"));

        a1.clear();
        Assert.assertTrue(a1.isEnabled());
        a1.sendKeys("Hello World!");
        a2.click();
        Assert.assertTrue(a3.getText().contains("World"));


    }

}