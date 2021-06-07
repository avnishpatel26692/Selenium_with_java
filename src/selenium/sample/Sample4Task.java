
package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
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
    public void clickALink()
    {
        WebElement link1 = driver.findElement(By.id("link1"));
        link1.click();
        WebElement linkPage1Label = driver.findElement(By.id("h1"));
        String expectedValue = "Link Page 1";
        String actualValue = linkPage1Label.getText();
        Assert.assertEquals("Unable redirect to new link page", expectedValue, actualValue);
    }

    @Test
    public void clickOnButton()
    {
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        showButton.click();
        WebElement textLabel = driver.findElement(By.id("show_me"));

        //validating Element is displayed on screen
        Assert.assertTrue(textLabel.isDisplayed());

        hideButton.click();
        Assert.assertFalse(textLabel.isDisplayed()); // To check whether element is displayed or not
        Assert.assertFalse(hideButton.isEnabled()); // To check whether element is enabled or not
        Assert.assertTrue(showButton.isEnabled());
    }

    @Test
    public void enterTextInTextBox()
    {
        WebElement textBox = driver.findElement(By.name("vfb-5"));
        textBox.clear(); //clear the field value
        textBox.sendKeys("Welcome to Automation Testing! I'm Janis");
        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expectedValue = "Automation Testing";
        String actualValue = resultText.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));
    }


}