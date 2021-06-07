package selenium.sample;

//import jdk.internal.org.objectweb.asm.ClassReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
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
    public void FieldToEnterSmallNumber() {
        WebElement numberField = driver.findElement(By.id("numb"));
        numberField.sendKeys("40");
        WebElement submitBtn = driver.findElement(By.className("w3-orange"));
        submitBtn.click();
        WebElement errorMsg = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too small";
        String actualValue = errorMsg.getText();
        Assert.assertEquals(expectedValue,actualValue);

    }
    @Test
    public void FieldToEnterBigNumber() {
        WebElement numberField1 = driver.findElement(By.id("numb"));
        numberField1.sendKeys("150");
        WebElement submitBtn1 = driver.findElement(By.className("w3-orange"));
        submitBtn1.click();
        WebElement errorMsg1 = driver.findElement(By.id("ch1_error"));
        String expectedValue = "Number is too big";
        String actualValue = errorMsg1.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }
    @Test
    public void correctSquareRootWithoutRemainder () {
        WebElement numberField3 = driver.findElement(By.id("numb"));
        numberField3.sendKeys("100");
        WebElement submitBtn1 = driver.findElement(By.className("w3-orange"));
        submitBtn1.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();
        String expectedValue = "Square root of 100 is 10.00";
        Assert.assertEquals(expectedValue, alertMsg);
    }
@Test
    public void correctSquareRootWithRemainder () {
    WebElement numberField4 = driver.findElement(By.id("numb"));
    numberField4.sendKeys("60");
    WebElement submitBtn1 = driver.findElement(By.className("w3-orange"));
    submitBtn1.click();
    Alert alert1 = driver.switchTo().alert();
    String alert1Msg = alert1.getText();
    alert1.accept();
    String expectedValue = "Square root of 60 is 7.75";
    Assert.assertEquals(expectedValue, alert1Msg);
}}











