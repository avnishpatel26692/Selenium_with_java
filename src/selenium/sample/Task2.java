package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.pageObject.AgePagePO;
import selenium.sample.pageObject.AgeSubmitterPO;
import selenium.sample.pageObject.GiveFeedBackPO;
import selenium.sample.pageObject.FeedBackPO;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedPage;
    static FeedBackPO feedPage;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedPage = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedPage = PageFactory.initElements(driver, FeedBackPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test

    public void scenario1() {
        Assert.assertTrue(giveFeedPage.getName().isEmpty());
        Assert.assertTrue(giveFeedPage.getAge().isEmpty());
        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedPage.getLanguageCheckBoxStatus(i));
        }

        Assert.assertTrue(giveFeedPage.getRadioBtnStatus(2));

        Assert.assertEquals("Choose your option", giveFeedPage.getSelectedDropDownOption());

        String backGroundColor = giveFeedPage.sendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

        String letterColor = giveFeedPage.sendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);


    }

    @Test
    public void scenario2() {
        giveFeedPage.sendBtn().click();
        Assert.assertTrue(feedPage.getYourName().isEmpty());
        Assert.assertTrue(feedPage.getYourAge().isEmpty());
        Assert.assertEquals("", feedPage.getYourLanguage());
        Assert.assertEquals("null", feedPage.getYourGenre());
        Assert.assertEquals("null", feedPage.getYourOption());
        Assert.assertEquals("", feedPage.getYourComment());

        String yesBackGroundColor = feedPage.sendYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesBackGroundColor);

        String yesLetterColor = feedPage.sendYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesLetterColor);

        String noBackGroundColor = feedPage.sendNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noBackGroundColor);

        String noLetterColor = feedPage.sendNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noLetterColor);


    }

    @Test
    public void scenario3() {
        String name = giveFeedPage.setName("Jevgenijs");
        String age = giveFeedPage.setAge("22");
        giveFeedPage.selectCheckbox(0);
        giveFeedPage.selectRadioBtn(0);
        giveFeedPage.selectDropdownOption("Good");
        giveFeedPage.setComment("I do my best!");
        giveFeedPage.sendBtn().click();
        Assert.assertEquals(name, feedPage.getYourName());
        Assert.assertEquals(age, feedPage.getYourAge());
        Assert.assertEquals("English", feedPage.getYourLanguage());
        Assert.assertEquals("male", feedPage.getYourGenre());
        Assert.assertEquals("Good", feedPage.getYourOption());
        Assert.assertEquals("I do my best!", feedPage.getYourComment());

        String yesBackGroundColor = feedPage.sendYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesBackGroundColor);

        String yesLetterColor = feedPage.sendYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesLetterColor);

        String noBackGroundColor = feedPage.sendNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noBackGroundColor);

        String noLetterColor = feedPage.sendNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noLetterColor);


        }


    }
