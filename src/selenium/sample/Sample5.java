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
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(5000);
        //Close browser
        driver.quit();
    }

    @Test
    public void clickOnAlertButton()
    {
        WebElement toSummonAlertButton = driver.findElement(By.className("w3-red"));
        toSummonAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.dismiss(); // alert.accept();
        String expectedValue = "I am an alert box!";
        Assert.assertEquals(expectedValue, alertMsg);
    }

    @Test
    public void confirmationPopUp()
    {
        WebElement toConfOrDenyBtn = driver.findElement(By.className("w3-teal"));
        toConfOrDenyBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement msg = driver.findElement(By.id("textForAlerts"));
        String expectedValue = "Why on earth have you agreed to it?!";
        String actualValue = msg.getText();
        Assert.assertEquals(expectedValue, actualValue);
        //click on alert and use dismiss method and validate the message
    }

    @Test
    public void popUpToEnterNumber()
    {
        String number = "10";
        WebElement clickToEnterNumberBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumberBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(number);
        alert.accept();
        String actualValue = driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertTrue(actualValue.contains(number));

    }
}