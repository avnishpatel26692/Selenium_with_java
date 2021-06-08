package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void selectCheckBox() {
        List<WebElement> checkBoxOpt = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement elementName : checkBoxOpt) //Enhanced for loop
        {
            Assert.assertFalse(elementName.isSelected());
            elementName.click();
            Assert.assertTrue(elementName.isSelected());
            elementName.click();
            Assert.assertFalse(elementName.isSelected());
        }
    }

    @Test
    public void selectRadioButton(){
        List<WebElement> radioButton = driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement radioBut : radioButton)
        {
            Assert.assertFalse(radioBut.isSelected());
            radioBut.click();
            Assert.assertTrue(radioBut.isSelected());
        }
    }

    @Test
    public void chooseDateViaCalendar(){
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("08/15/2020").format(cal.getTime());  // 08/15/2020

        WebElement dateBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        dateBox.click();
        for(int i =0 ; i<10; i++)
        {
            WebElement previousMonth = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonth.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = dateBox.getAttribute("value");
        Assert.assertEquals(result,actualResults);

    }
    @Test
    public void chooseDateViaTextBox(){
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("12/15/2014").format(cal.getTime());  // 08/15/2020

        WebElement dateTextBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        dateTextBox.click();
        dateTextBox.sendKeys(result);

        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = dateTextBox.getAttribute("value");
        Assert.assertEquals(result,actualResults);

    }
}