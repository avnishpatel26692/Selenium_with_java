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
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @Test
    public void clickALink() {
        WebElement Homepagelink = driver.findElement(By.id("homepage_link"));
        Homepagelink.click();
        WebElement linkHomePage1Label = driver.findElement(By.id("h1"));
        String expectedValue = "This is a home page";
        String actualValue = linkHomePage1Label.getText();

        Assert.assertEquals("Unable to redirect to new link page", expectedValue, actualValue);
    }

    @Test
    public void clickOnButton(){
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
    public void enterTextInTextArea(){
        WebElement textAre = driver.findElement(By.name("vfb-10"));
        textAre.clear();
        textAre.sendKeys("Automation Testing in Text Area");
        WebElement resultButton = driver.findElement(By.id("result_button_text_area"));
        resultButton.click();
        WebElement resultText = driver.findElement(By.id("result_text_area"));
        String expectedValue = "Automation Testing in Text Area";
        String actualValue = resultText.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }
}



