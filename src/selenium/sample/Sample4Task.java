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
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }


    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }


    @Test
    public void clickALink() {
        WebElement link1 = driver.findElement(By.id("homepage_link"));
        link1.click();
        WebElement linkPage1label = driver.findElement(By.id("h1"));
        String expectedValue = "This is a home page";
        String actualValue = linkPage1label.getText();

        Assert.assertEquals("Unable redirect to new link page", expectedValue, actualValue);
    }


    @Test
    public void clickOnButton() {
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        showButton.click();
        WebElement textLabel = driver.findElement(By.id("show_me"));

        Assert.assertTrue(textLabel.isDisplayed());

        hideButton.click();

        Assert.assertFalse(textLabel.isDisplayed());
        Assert.assertFalse(hideButton.isEnabled());
        Assert.assertTrue(showButton.isEnabled());
    }


    @Test
    public void enterTextInTextBox() {
        WebElement textBox = driver.findElement(By.name("vfb-5"));
        textBox.clear();
        textBox.sendKeys("Automation testing");
        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expectedValue = "Automation testing";
        String actualValue = resultText.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void enterNumberInTextBox() {
        WebElement textBox = driver.findElement(By.name("vfb-5"));
        textBox.clear();
        textBox.sendKeys("777");
        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expectedValue = "777";
        String actualValue = resultText.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));

    }

}
