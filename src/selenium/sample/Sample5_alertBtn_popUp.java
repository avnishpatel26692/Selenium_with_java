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

public class Sample5_alertBtn_popUp {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void clickOnAlertButton() {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-red"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss();
        String expect = "I am an alert box!";

        Assert.assertEquals(expect, alertMsg);
    }

    @Test
    public void confirmationPopUp() {
        WebElement toConfOrDenyButton = driver.findElement(By.className("w3-teal"));
        toConfOrDenyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement msg = driver.findElement(By.id("textForAlerts"));
        String expect = "Why on earth have you agreed to it?!";
        String actual = msg.getText();

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void confirmationPopUpCancelVersion() {
        WebElement toConfOrDenyButton = driver.findElement(By.className("w3-teal"));
        toConfOrDenyButton.click();
        Alert alert = driver.switchTo().alert();

        alert.dismiss();
        WebElement msg1 = driver.findElement(By.id("textForAlerts"));
        String expectCancelVersion = "You have dared to deny me!!!";
        String actualCancelVersion = msg1.getText();

        Assert.assertEquals(expectCancelVersion, actualCancelVersion);
    }

    @Test
    public void popUpToEnterNumber(){
        String number = "20";
        WebElement clickToEnterNumberButton = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumberButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(number);
        alert.accept();
        String actual = driver.findElement(By.id("textForAlerts")).getText();

        Assert.assertTrue(actual.contains(number));
    }

    @Test
    public void popUpToEnterNumberCancel(){
        WebElement clickToEnterNumberButton = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumberButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String expected = "";
        String actual = driver.findElement(By.id("textForAlerts")).getText();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void goToAlertedPageCancel(){
        WebElement goToAlertedPageBtn = driver.findElement(By.className("w3-blue"));
        goToAlertedPageBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String expected = "So you desided to say? Good!";
        String actual = driver.findElement(By.id("textForAlerts")).getText();

        Assert.assertEquals(expected, actual);
    }
}
