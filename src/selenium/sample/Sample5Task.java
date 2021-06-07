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

public class Sample5Task {
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
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void clickOnAlertButton() {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-red"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.dismiss(); // alert.accept(); can use this as well
        String expectedValue = "I am an alert box!";
        Assert.assertEquals(expectedValue, alertMessage);
    }

    @Test
    public void clickOnAlertButtonAccept() {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-btn"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept(); // alert.accept(); can use this as well
        String expectedValue = "I am an alert box!";
        Assert.assertEquals(expectedValue, alertMessage);
    }

    @Test
    public void confirmationPopUp () {
        WebElement toConfOrDenyButton = driver.findElement(By.className("w3-teal"));
        toConfOrDenyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String expectedValue = "Why on earth have you agreed to it?!";
        String actualValue = message.getText();
        Assert.assertEquals(expectedValue, actualValue);
        ///// click on alert and use dismiss method and validate the message
    }

    @Test
    public void confirmationPopUpCancellation() {
        WebElement toConfOrDenyButton = driver.findElement(By.className("w3-teal"));
        toConfOrDenyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String expectedValue = "You have dared to deny me!!!";
        String actualValue = message.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void popUpToEnterNumber () {
        String number = "20";
        WebElement clickToEnterNumberButton = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumberButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(number);
        alert.accept();
        String actualValue = driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertTrue(actualValue.contains(number));
    }

    @Test
    public void popUpToCancelEnteredNumber() {
        WebElement clickToEnterNumberButton = driver.findElement(By.className("w3-round-xlarge"));
        clickToEnterNumberButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.id("textForAlerts"));
        String expectedValue = " ";
        String actualValue = " ";
        Assert.assertEquals(expectedValue, actualValue);
    }



}
