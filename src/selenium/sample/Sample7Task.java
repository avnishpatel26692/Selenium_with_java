package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Sample7Task {

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
    public void clickOnCheckbox() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        Thread.sleep(2000);
        checkbox1.click();
        Assert.assertFalse(checkbox1.isSelected());
        Thread.sleep(2000);
        WebElement checkbox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        checkbox2.click();
        Thread.sleep(2000);
        WebElement checkbox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));
        checkbox3.click();
        Thread.sleep(2000);
    }

     @Test
    public void clickOnRadioBtn() throws InterruptedException {
        WebElement radioBtn1 = driver.findElement(By.xpath("//input[@name='vfb-7' and @value='Option 1']"));
        radioBtn1.click();
        Assert.assertTrue(radioBtn1.isSelected());
        Thread.sleep(2000);
        WebElement radioBtn2 = driver.findElement(By.cssSelector("input[name='vfb-7'][value='Option 2']"));
        radioBtn2.click();
        Assert.assertTrue(radioBtn2.isSelected());
        Assert.assertFalse(radioBtn1.isSelected());
        Thread.sleep(2000);
         WebElement radioBtn3 = driver.findElement(By.cssSelector("input[name='vfb-7'][value='Option 3']"));
         radioBtn3.click();
         Assert.assertTrue(radioBtn3.isSelected());
         Assert.assertFalse(radioBtn2.isSelected());
         Thread.sleep(2000);
    }

    @Test
    public void selectDate() throws InterruptedException {
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());
        WebElement calendar = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        calendar.click();
        for(int i =0 ; i<10; i++)
        {
            Thread.sleep(5);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = calendar.getAttribute("value");
        Assert.assertEquals(result,actualResults);
    }
    @Test
    public void chooseDateViaTextBox(){
        WebElement e = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        e.clear();
        e.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014",e.getAttribute("value"));
    }

}