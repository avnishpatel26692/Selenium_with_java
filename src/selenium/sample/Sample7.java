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
import java.util.concurrent.TimeUnit;

public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
//        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.get("https://kristinek.github.io/site/examples/actions");

    }

    @Test
    public void selectValueFromDropdown() throws InterruptedException {
        WebElement dropDownBox = driver.findElement(By.cssSelector("select#vfb-12"));
        Select dropDownSelect = new Select(dropDownBox);
        Thread.sleep(2000);
        dropDownSelect.selectByVisibleText("Option 2");
        Thread.sleep(2000);

//        dropDownSelect.selectByValue("value 3");
//        System.out.println(dropDownSelect.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//
//        dropDownSelect.selectByIndex(1);
//        System.out.println(dropDownSelect.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
    }

    @Test
    public void selectingCheckBoxes() throws InterruptedException {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement elementName : checkboxes){
            Assert.assertFalse(elementName.isSelected());
            elementName.click();
            Thread.sleep(2000);
            Assert.assertTrue(elementName.isSelected());
            elementName.click();
            Assert.assertFalse(elementName.isSelected());
            Thread.sleep(2000);
        }
    }

    @Test
    public void selectRadioButtons() throws InterruptedException {
        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement radio : radioBtns){
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Thread.sleep(2000);
            Assert.assertTrue(radio.isSelected());
        }
    }

    @Test
    public void selectDate() throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());

        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();
        for(int i=0; i<10; i++){
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResult = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result, actualResult);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }
}