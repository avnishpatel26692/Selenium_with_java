package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.AgePagePO;
import pageObject.AgeSubmittedPO;

public class Sample12Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static AgePagePO agePage;
    static AgeSubmittedPO ageSubmittedPage;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().window().maximize();
        agePage = PageFactory.initElements(driver, AgePagePO.class);
        ageSubmittedPage = PageFactory.initElements(driver, AgeSubmittedPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //Enter name, enter age, click on button, validate message
    @Test
    public void scenario1(){
        agePage.enterName("ABC");
        agePage.enterAge("40");
        agePage.clickOnSubmitBtn();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are an adult",actualMessage);
    }

    @Test
    public void scenario2(){
        agePage.enterName("ABC");
        agePage.clickOnSubmitBtn();
        String actualMessage = agePage.getErrorMsg();
        Assert.assertEquals("You haven't entered anything in age field", actualMessage);
    }

    @Test
    public void scenario3(){
        agePage.enterAge("40");
        agePage.clickOnSubmitBtn();
//        String actualMessage = agePage.getErrorMsg();
        Assert.assertEquals("You haven't entered anything in name field",agePage.getErrorMsg());
    }

    @Test
    public void scenario4(){
        agePage.enterName("ABC");
        agePage.enterAge("15");
        agePage.clickOnSubmitBtn();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are a teenager",actualMessage);
    }

    @Test
    public void scenario5(){
        agePage.enterName("ABC");
        agePage.enterAge("3");
        agePage.clickOnSubmitBtn();
        String actualMessage = ageSubmittedPage.getMessage();
        Assert.assertEquals("Hello, ABC, you are a kid",actualMessage);
    }



}
