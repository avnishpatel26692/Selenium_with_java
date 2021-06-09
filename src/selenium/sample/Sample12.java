package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pageObject.AgePagePO;
import selenium.pageObject.AgeSubmittedPO;


public class Sample12 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static AgePagePO agePage;
    static AgeSubmittedPO ageSubmittedPage;

    @Before
    public void beforeMethod() {

        //Define driver
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age.html");
        driver.manage().window().maximize();
        agePage = PageFactory.initElements(driver, AgePagePO.class);
        ageSubmittedPage = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

    //Enter name , enter age = 40, click on Submit button, validate message = 'Hello, ABC, you are an adult'
    @Test
    public void checkForAdult() {
        agePage.enterName("ABC");
        agePage.enterAge("40");
        agePage.clickOnSubmitButton();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are an adult", actualMessage);
    }

    //Enter name , enter age = 16, click on Submit button, validate message = 'Hello, ABC, you are a teenager'
    @Test
    public void checkForTeenager() {
        agePage.enterName("ABC");
        agePage.enterAge("16");
        agePage.clickOnSubmitButton();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are a teenager", actualMessage);
    }

    //Enter name , enter age = 5, click on Submit button, validate message = 'Hello, ABC, you are a kid'
    @Test
    public void checkForKid() {
        agePage.enterName("ABC");
        agePage.enterAge("5");
        agePage.clickOnSubmitButton();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are a kid", actualMessage);
    }

    //Enter name ABC and click on submit button, validate error message
    @Test
    public void validateErrorMessage() {
        agePage.enterName("ABC");
        agePage.clickOnSubmitButton();
        String actualMessage = agePage.getErrorMessage();
        Assert.assertEquals("You haven't entered anything in age field", actualMessage);
    }

    //Enter age 20 and click on submit button, validate error message
    @Test
    public void validateErrorMessage2() {
        agePage.enterAge("40");
        agePage.clickOnSubmitButton();
        String actualMessage = agePage.getErrorMessage();
        Assert.assertEquals("You haven't entered anything in name field", actualMessage);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }
}
