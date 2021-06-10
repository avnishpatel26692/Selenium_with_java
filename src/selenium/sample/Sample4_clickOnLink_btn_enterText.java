package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4_clickOnLink_btn_enterText {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void clickALink() {
        WebElement link = driver.findElement(By.id("homepage_link"));
        link.click();
        WebElement linkPage1Label = driver.findElement(By.id("h1"));
        String expected = "This is a home page";
        String actual = linkPage1Label.getText();
        Assert.assertEquals("Unable to redirect  to new link page", expected, actual);
    }

    @Test
    public void clickOnButton() {
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        showButton.click();
        WebElement textLabel = driver.findElement(By.id("show_me"));

        //validating Element is displayed on screen
        Assert.assertTrue(textLabel.isDisplayed());

        hideButton.click();
        Assert.assertFalse(textLabel.isDisplayed());

        Assert.assertTrue(showButton.isEnabled());
    }

    @Test
    public void enterTextInTextBox() {
        WebElement textBox = driver.findElement(By.name("vfb-5"));
        textBox.clear(); // clear the field value
        String testString = "I am learning";
        textBox.sendKeys(testString);
        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expected = testString;
        String actual = resultText.getText();

        Assert.assertTrue(actual.contains(expected));

    }
}
