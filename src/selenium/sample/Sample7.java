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
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;


public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/actions");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
    public void clickOnRadioButton() throws InterruptedException {
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@name='vfb-7' and @value='Option 1']"));
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[name='vfb-7'][value='Option 2']"));
        radioButton1.click();
        Assert.assertTrue(radioButton1.isSelected());
        Thread.sleep(2000);
        radioButton2.click();
        Assert.assertTrue(radioButton2.isSelected());
        Assert.assertFalse(radioButton1.isSelected());
    }

    @Test
    public void selectRadioButtons() throws InterruptedException {
        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement radio : radioBtns) {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Thread.sleep(2000);
            Assert.assertTrue(radio.isSelected());
        }
    }

    @Test
    public void selectValueFromDropDown() throws InterruptedException {
        WebElement dropDownBox = driver.findElement(By.cssSelector("select#vfb-12"));
        Select dropDownSelect = new Select(dropDownBox);
        Thread.sleep(2000);
        //Select value Option 2 by visible text
        dropDownSelect.selectByVisibleText("Option 2");
        Thread.sleep(2000);

        System.out.println(dropDownSelect.getFirstSelectedOption());

        //Select by value
        dropDownSelect.selectByValue("value3");
        Thread.sleep(2000);

        //Select by index
        dropDownSelect.selectByIndex(1);
        Thread.sleep(2000);
    }

    @Test
    public void selectingCheckboxes() throws InterruptedException {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[types='checkbox']"));
        for (WebElement elementName : checkboxes) { //Enhanced for loop
            Assert.assertFalse(elementName.isSelected());
            elementName.click();
            Assert.assertTrue(elementName.isSelected());
            Thread.sleep(2000);
        }
    }

    @Test
    public void selectDate() throws InterruptedException {
        Calendar cal = Calendar.getInstance(); //Get today's date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());  // 08/15/2020

        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();

        }

        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result, actualResults);
    }

    @Test
    public void selectCheckBox() throws InterruptedException {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement elementName : checkboxes) //Enhanced for loop
        {
            Assert.assertFalse(elementName.isSelected());
            elementName.click();
            Thread.sleep(2000);
            Assert.assertTrue(elementName.isSelected());
            elementName.click();
            Assert.assertFalse(elementName.isSelected());
            Thread.sleep(2000);
        }
        WebElement option3CheckBox = driver.findElement(By.cssSelector(".w3-check[value='Option 3']"));
        Assert.assertFalse(option3CheckBox.isSelected());
        option3CheckBox.click();
        Assert.assertTrue(option3CheckBox.isSelected());
    }

    @Test
    public void selectRadioButton() throws InterruptedException {
        List<WebElement> radioBtns = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for(WebElement radio : radioBtns) {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Thread.sleep(2000);
            Assert.assertTrue(radio.isSelected());
            radio.click();
        }

        WebElement option2RadioButton = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(option2RadioButton.isSelected());
        option2RadioButton.click();
        Assert.assertTrue(option2RadioButton.isSelected());
    }

    @Test
    public void chooseDateViaCalendar() throws InterruptedException {
        Calendar cal = Calendar.getInstance(); //Get today's date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());  // Go 10 months back

        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();

        WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.className("ui-datepicker-prev"));
            previousMonthBtn.click();

        }

        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result, actualResults);
    }

    @Test
    public void chooseDateViaTextBox() throws InterruptedException {
        WebElement element = driver.findElement(By.id("vfb-8"));
        String expectedValue = "12/15/2014";
        element.clear();
        element.sendKeys(expectedValue);
        Thread.sleep(500);
        String realValue = element.getAttribute("value");
        Assert.assertEquals(expectedValue, realValue);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
