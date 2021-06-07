package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample4 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/actions");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void clickALink() {
        WebElement link = driver.findElement(By.id("link1"));
        link.click();
        WebElement linkPage1Label = driver.findElement(By.id("h1"));
        String expectedValue = "Link Page 1";
        String actualValue = linkPage1Label.getText();
        Assert.assertEquals("Unable to redirect to new link page", expectedValue, actualValue);
    }

    @Test
    public void clickOnButton() {
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        showButton.click();
        WebElement textLabel = driver.findElement(By.id("show_me"));

        //Validating element is displayed on screen
        Assert.assertTrue(textLabel.isDisplayed());

        hideButton.click();
        Assert.assertFalse(textLabel.isDisplayed()); // To check whether the element is displayed or not
        Assert.assertFalse(hideButton.isEnabled()); // To check whether the element is enabled or not
        Assert.assertTrue(showButton.isEnabled());
    }

    @Test
    public void enterTextInTextBox() {
        WebElement textBox  = driver.findElement(By.name("vfb-5"));
        textBox.clear(); //Clear the field value
        textBox.sendKeys("Automation Testing");

        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expectedValue = "Automation Testing";
        String actualText = resultText.getText();

        Assert.assertTrue(actualText.contains(expectedValue));
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}

