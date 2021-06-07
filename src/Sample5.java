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

import java.util.concurrent.TimeUnit;

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/alerts_popups");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void clickOnAlertButton() {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-red"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept(); //Or alert.dismiss();
        String expectedValue = "I am an alert box!";
        Assert.assertEquals(expectedValue, alertMsg);
    }

    @Test
    public void confirmationPopUp() {
        WebElement toCOnfOrDenyBtn = driver.findElement(By.className("w3-teal"));
        toCOnfOrDenyBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement msg = driver.findElement(By.id("textForAlerts"));
        String expectedValue = "Why on earth have you agreed to it?!";
        String actualValue = msg.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void popUpWithConfirmation() {
        String number = "20";
        WebElement clickToEnterNumberBtn = driver.findElement(By.className("w3-blue"));
        clickToEnterNumberBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.accept();
        String expectedMessage = "This page is alerted";
        String actualValue = driver.findElement(By.id("heading")).getText();
        Assert.assertEquals(expectedMessage, actualValue);


    }

    @Test
    public void popUpToEnterNumber() {
        String number = "20";
        WebElement clickToEnterNumberBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumberBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(number);
        alert.accept();
        String actualValue = driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertTrue(actualValue.contains(number));

    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}