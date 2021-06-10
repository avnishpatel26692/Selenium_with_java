package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.AgePagePO;
import selenium.pageObject.AgeSubmittedPO;

public class Sample12_formTesting_withPO {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    static AgePagePO agePage;
    static AgeSubmittedPO ageSubmittedPage;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().window().maximize();

        //lai inicializētu visu klasi un visus tās elementus
        agePage = PageFactory.initElements(driver, AgePagePO.class);
        ageSubmittedPage = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //enter name, enter age, click on submit and validate message 'Hello, ABC, you are an adult
    @Test
    public void scenario1() {
        agePage.enterName("ABC");
        agePage.enterAge("40");
        agePage.clickOnSubmitBtn();
        String actualMessage = ageSubmittedPage.getMessage();

        Assert.assertEquals("Hello, ABC, you are an adult", actualMessage);
    }

    //Enter name = ABC and click on submit button and validate error message "You haven't entered anything in age field"
    @Test
    public void scenario2() {
        agePage.enterName("ABC");
        agePage.clickOnSubmitBtn();
        String actualMessage = agePage.getErrorMsg();

        Assert.assertEquals("You haven't entered anything in age field", actualMessage);
    }

    //Enter age = 20 and click on submit button and validate error message "You haven't entered anything in name field"
    @Test
    public void scenario3() {
        agePage.enterAge("20");
        agePage.clickOnSubmitBtn();
        String actualMessage = agePage.getErrorMsg();

        Assert.assertEquals("You haven't entered anything in name field", actualMessage);
    }

    // Enter Name= ABC, Enter age = 16, click on submit button and validate message 'Hello, ABC, you are a teenager"
    @Test
    public void scenario4() {
        agePage.enterName("ABC");
        agePage.enterAge("16");
        agePage.clickOnSubmitBtn();
        String actual = ageSubmittedPage.getMessage();

        Assert.assertEquals("Hello, ABC, you are a teenager", actual);
    }

    // Enter Name= ABC, Enter age = 5, click on submit button and validate message 'Hello, ABC, you are a kid"
    @Test
    public void scenario5() {
        agePage.enterName("ABC");
        agePage.enterAge("5");
        agePage.clickOnSubmitBtn();
        String actual = ageSubmittedPage.getMessage();

        Assert.assertEquals("Hello, ABC, you are a kid", actual);
    }
}