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

public class Sample7_checkbox_radioBtn_dropdown_calendar {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
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
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
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
    }

    @Test
    public void selectCheckBox() throws InterruptedException {
        List<WebElement> checkBox = driver.findElements(By.cssSelector("“.w3-check[type='checkbox']"));
        for (WebElement option : checkBox) {
            Assert.assertFalse(option.isSelected());
            option.click();
            Thread.sleep(2000);
            Assert.assertTrue(option.isSelected());
            Thread.sleep(2000);
        }
        WebElement option3 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        Assert.assertFalse(option3.isSelected());
        option3.click();

        Assert.assertTrue(option3.isSelected());

        WebElement option = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        Assert.assertTrue(option.isSelected());
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
        for (WebElement radio : radioBtns) {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Thread.sleep(2000);
            Assert.assertTrue(radio.isSelected());
        }
    }

    @Test
    public void selectRadioButton1() throws InterruptedException {
        List<WebElement> radioBtns = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for (WebElement btn: radioBtns) {
            Assert.assertFalse(btn.isSelected());
            btn.click();
            Assert.assertTrue(btn.isSelected());
        }
//        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type=radio']"));
        WebElement option2 = driver.findElement(By.cssSelector("input[id='vfb-7-2'"));
        Thread.sleep(2000);
        Assert.assertFalse(option2.isSelected());
        option2.click();
        Assert.assertTrue(option2.isSelected());
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
    public void chooseDateViaCalendar() throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -5);
        String result = new SimpleDateFormat("MM/11/yyyy").format(cal.getTime());

        WebElement dateBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        dateBox.getAttribute("value");
        dateBox.click();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }
        WebElement date11 = driver.findElement(By.xpath("//a[text()='11']"));
        date11.click();
        String actualResults = dateBox.getAttribute("value");
        Assert.assertEquals(result, actualResults);
    }

        //not working yet
    @Test
    public void chooseDateViaTextBox() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());
        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result, actualResults);
    }
}
