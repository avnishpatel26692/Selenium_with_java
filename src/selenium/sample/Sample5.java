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
        Thread.sleep(2500);
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

        toConfOrDenyBtn.click();  // click that button
        alert = driver.switchTo().alert();  //switch to alert window
        alert.dismiss(); // press Cancel button
        WebElement msg1 = driver.findElement(By.id("textForAlerts")); // define the element with dismiss message from the screen
        expectedValue = "You have dared to deny me!!!"; // value we expected
        actualValue = msg1.getText(); // get actual text
        Assert.assertEquals(expectedValue, actualValue); //compare expected and actual results

    }

    @Test
    public void popUpToEnterNumber()
    {
        // Case when we press Ok
        String number = "20000";
        WebElement clickToEnterNumberBtn = driver.findElement(By.className("w3-khaki")); //define the button to click by a className
        clickToEnterNumberBtn.click();  // click that button
        Alert alert = driver.switchTo().alert(); // switching to alert pop-up window
        alert.sendKeys(number); // enter our string value
        alert.accept(); // press OK
        String actualValue = driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertTrue(actualValue.contains(number));

        // Case when we press Cancel
        number = "";
        clickToEnterNumberBtn.click();  // click that button
        Alert alert1 = driver.switchTo().alert(); // switching to alert pop-up window
        alert1.sendKeys(number); // enter our string value
        alert1.dismiss(); // press Cancel
        actualValue = driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertTrue(actualValue == number);
    }
}
