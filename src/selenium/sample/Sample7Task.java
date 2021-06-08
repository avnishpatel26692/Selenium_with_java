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
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sample7Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "//lib//";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
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
    public void checkBox(){
        WebElement option1 = driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        WebElement option2 = driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement option3 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        WebElement button = driver.findElement(By.xpath("//button[@id='result_button_checkbox']"));
        WebElement result = driver.findElement(By.xpath("//p[@id='result_checkbox']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 1"));
        option2.click();
        Assert.assertTrue(option2.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 2"));
        option3.click();
        Assert.assertTrue(option3.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 3"));
    }

    @Test
    public void radioButton(){
        WebElement option1 = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
        WebElement option2 = driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement option3 = driver.findElement(By.xpath("//input[@id='vfb-7-3']"));
        WebElement button = driver.findElement(By.xpath("//button[@id='result_button_ratio']"));
        WebElement result = driver.findElement(By.xpath("//p[@id='result_radio']"));

        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
        Assert.assertFalse(option3.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 1"));

        option2.click();
        Assert.assertFalse(option1.isSelected());
        Assert.assertTrue(option2.isSelected());
        Assert.assertFalse(option3.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 2"));

        option3.click();
        Assert.assertFalse(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
        Assert.assertTrue(option3.isSelected());
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 3"));
    }

    @Test
    public void selectValueFromDropDown(){
        WebElement select_list = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        WebElement button = driver.findElement(By.xpath("//button[@id='result_button_select']"));
        WebElement result = driver.findElement(By.xpath("//p[@id='result_select']"));
        Select select = new Select(select_list);

        select.selectByVisibleText("Option 1");
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 1"));
        select.selectByValue("value2");
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 2"));

        select.selectByIndex(3);
        button.click();
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("Option 3"));
    }

    @Test
    public void selectCheckBox(){
        for(WebElement e : driver.findElements(By.cssSelector(".w3-check[type='checkbox']"))){
            Assert.assertFalse(e.isSelected());
            e.click();
            Assert.assertTrue(e.isSelected());
            e.click();
            Assert.assertFalse(e.isSelected());
        }
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        Assert.assertFalse(option3.isSelected());
        option3.click();
        Assert.assertTrue(option3.isSelected());
    }

    @Test
    public void selectRadioButton(){
        for(WebElement e : driver.findElements(By.cssSelector(".w3-check[type='radio']"))){
            Assert.assertFalse(e.isSelected());
            e.click();
            Assert.assertTrue(e.isSelected());
        }
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(option2.isSelected());
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }

    @Test
    public void chooseDateViaCalendar(){
        WebElement e1 = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-10);
        String date = new SimpleDateFormat("MM/15/yyyy").format(calendar.getTime());

        e1.click();

        for(int i = 0; i < 10; i++) {
            WebElement e2 = driver.findElement(By.xpath("//span[text()='Prev']"));
            WebElement e3 = driver.findElement(By.xpath("//span[text()='Next']"));
            e2.click();
        }

        WebElement day = driver.findElement(By.xpath("//a[text()='15']"));
        day.click();
        Assert.assertEquals(e1.getAttribute("value"),date);
    }

    @Test
    public void chooseDateViaTextBox(){
        WebElement e1 = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        e1.clear();
        e1.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014",e1.getAttribute("value"));
    }
}

