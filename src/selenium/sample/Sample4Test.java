package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample4Test {

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
        WebElement link1 = driver.findElement(By.id("homepage_link"));
        link1.click();
        WebElement linkPage1Label = driver.findElement(By.id("h1"));
        String expectedValue = "This is a home page";
        String actualValue = linkPage1Label.getText();
        Assert.assertEquals("Unable redirect to new link page", expectedValue, actualValue);
    }

    @Test
    public void clickOnButton()
    {
        // define buttons
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));
        // click Show button
        showButton.click();

        WebElement textLabel = driver.findElement(By.id("show_me"));

        //validating if the Element is displayed on screen
        Assert.assertTrue(textLabel.isDisplayed()); // we expect "I am here!" message here

        hideButton.click();
        Assert.assertFalse(textLabel.isDisplayed()); // To check whether element is displayed or not
        Assert.assertFalse(hideButton.isEnabled()); // To check whether element is enabled or not
        Assert.assertTrue(showButton.isEnabled());
    }

    @Test
    public void enterTextInTextBox()
    {
        WebElement textBox = driver.findElement(By.name("vfb-5")); // text box
        textBox.clear(); //clear the field value first
        textBox.sendKeys("This text is generated for testing"); //printing the text
        WebElement resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click(); // click Result button
        WebElement resultText = driver.findElement(By.id("result_text"));
        String expectedValue = "This text is generated for testing";
        String actualValue = resultText.getText();

        textBox.clear(); //clear the field value again
        textBox.sendKeys("We run test again"); //printing the text
        resultButton = driver.findElement(By.id("result_button_text"));
        resultButton.click(); // click Result button
        resultText = driver.findElement(By.id("result_text"));
        expectedValue = "We run test again";
        actualValue = resultText.getText();

        Assert.assertTrue(actualValue.contains(expectedValue));
    }
}
