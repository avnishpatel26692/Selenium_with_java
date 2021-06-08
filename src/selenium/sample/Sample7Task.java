package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Sample7Task {
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
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }


    @Test
    public void selectCheckBox() {
        List<WebElement> checkBox = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement box : checkBox) {
            Assert.assertFalse(box.isSelected());
            box.click();
            Assert.assertTrue(box.isSelected());
            box.click();
        }

        WebElement box1 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        Assert.assertFalse(box1.isSelected());
        box1.click();
        Assert.assertTrue(box1.isSelected());
    }

    @Test
    public void selectRadioButton() {
        List<WebElement> radioButton = driver.findElements(By.cssSelector(".w3-check[type=radio]"));
        for (WebElement button : radioButton) {
            Assert.assertFalse(button.isSelected());
            button.click();
            Assert.assertTrue(button.isSelected());
            button.click();
        }

        WebElement button = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(button.isSelected());
        button.click();
        Assert.assertTrue(button.isSelected());
    }

    @Test
    public void chooseDateViaCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());

        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();

        WebElement datePickerTxtBox1 = driver.findElement(By.xpath(""));

        for (int i = 0; i < 10; i++) {
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result, actualResults);
    }

//}
// Task not finished yet

    // Below are examples
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


}
