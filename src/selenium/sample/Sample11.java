package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.pageObject.AgeSubmitterPO;
import selenium.sample.pageObject.AgePagePO;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static AgePagePO agePage;
    static AgeSubmitterPO ageSubmitterPage;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age.html");
        driver.manage().window().maximize();
        agePage = PageFactory.initElements(driver, AgePagePO.class);
        ageSubmitterPage = PageFactory.initElements(driver, AgeSubmitterPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void scenario1(){
        agePage.enterName("ABC");
        agePage.enterAge("30");
        agePage.clickOnSubmitButton();
        String actualMessage = ageSubmitterPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are an adult", actualMessage);
    }

    //Enter name = ABC and submit, validate

    @Test
    public void scenario2(){
        agePage.enterName("ABC");
        agePage.enterAge("");
        agePage.clickOnSubmitButton();
        String actualMessage = agePage.getErrorMessage();
        Assert.assertEquals("You haven't entered anything in age field", actualMessage);
    }

    @Test
    public void scenario3(){
        agePage.enterAge("20");
        agePage.clickOnSubmitButton();
        Assert.assertEquals("You haven't entered anything in name field", agePage.getErrorMessage());
    }

    @Test
    public void scenario4(){
        agePage.enterName("ABC");
        agePage.enterAge("16");
        agePage.clickOnSubmitButton();
        String actualMessage = ageSubmitterPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are a teenager", actualMessage);
    }
    @Test
    public void scenario5(){
        agePage.enterName("ABC");
        agePage.enterAge("5");
        agePage.clickOnSubmitButton();
        Assert.assertEquals("Hello, ABC, you are a kid", ageSubmitterPage.getMessage());
    }
}
