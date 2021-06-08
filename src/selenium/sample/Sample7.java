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

public class Sample7 {

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
    }

    @Test
    public void selectingCheckboxes() throws InterruptedException {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for(WebElement elementName : checkboxes) //Enhanced for loop
        {
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
    public void clickOnRadioBtn() {
        WebElement radioBtn1 = driver.findElement(By.xpath("//input[@name='vfb-7' and @value='Option 1']"));
        WebElement radioBtn2 = driver.findElement(By.cssSelector("input[name='vfb-7'][value='Option 2']"));
        radioBtn1.click();
        Assert.assertTrue(radioBtn1.isSelected());
        radioBtn2.click();
        Assert.assertTrue(radioBtn2.isSelected());
        Assert.assertFalse(radioBtn1.isSelected());
    }

    @Test
    public void selectRadioButtons() throws InterruptedException {
        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement radio : radioBtns)
        {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Thread.sleep(2000);
            Assert.assertTrue(radio.isSelected());
        }
    }

    @Test
    public void selectValueFromDropdown() throws InterruptedException {
        WebElement dropDownBox = driver.findElement(By.cssSelector("select#vfb-12"));
        Select dropdownSelect = new Select(dropDownBox);
        Thread.sleep(2000);
        // Select by Visible text
        dropdownSelect.selectByVisibleText("Option 2");
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        //Select by Value
        dropdownSelect.selectByValue("value3");
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        //Select by index
        dropdownSelect.selectByIndex(1);
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
        Thread.sleep(2000);
    }

    @Test
    public void selectDate() throws InterruptedException {
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -78);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());  // 12/15/2014

        WebElement datePickerTxtBox = driver.findElement(By.id("vfb-8"));
        datePickerTxtBox.click();
        for(int i =0 ; i<78; i++)
        {
            Thread.sleep(100);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]/a"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result,actualResults);
    }

}