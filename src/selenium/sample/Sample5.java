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

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void clickOnAlertButton() {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-red"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.dismiss();//alert.accept;
        String expectedValue = "I am an alert box!";
        Assert.assertEquals(expectedValue, alertMessage);


    }

    @Test
    public void clickOnOffAlertButton() {
        WebElement toConfirmDenyButton = driver.findElement(By.className("w3-teal"));
        toConfirmDenyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String expectedValue = "Why on earth have you agreed to it?!";
        String actualValue = message.getText();
        Assert.assertEquals(expectedValue, actualValue);
        //click on 2nd alert, and get message
    }

    @Test
    public void enterTextAlert() {
        String text = "1234";
        WebElement toEnterAnumber = driver.findElement(By.className("w3-khaki"));
        toEnterAnumber.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String actualValue = message.getText();
        Assert.assertTrue(actualValue.contains(text));
    }

    @Test
    public void popUpMessage() {
        WebElement toGoAlertedPage = driver.findElement(By.className("w3-blue"));
        toGoAlertedPage.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.accept();
        WebElement pageAlerted = driver.findElement(By.id("heading"));
        pageAlerted.getText();
        String expectedResult = "This page is alerted";
        String actualResult = pageAlerted.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void popUpMsgDecline() {
        WebElement toGoAlertedPage = driver.findElement(By.className("w3-blue"));
        toGoAlertedPage.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement pageStay = driver.findElement(By.id("textForAlerts"));
        pageStay.getText();
        String expectedResult = "So you desided to say? Good!";
        String actualResult = pageStay.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void enterNoTextAlert() {
        String text = "";
        WebElement toEnterAnumber = driver.findElement(By.className("w3-khaki"));
        toEnterAnumber.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String actualValue = message.getText();
        Assert.assertTrue(actualValue.contains(text));
    }
}