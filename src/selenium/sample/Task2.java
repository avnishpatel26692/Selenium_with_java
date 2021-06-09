package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.AgePagePO;
import selenium.pageObject.AgeSubmittedPO;
import selenium.pageObject.GiveFeedBackPO;
import selenium.pageObject.FeedBackPO;

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

        Assert.assertTrue(giveFeedPage.getRadioButtonStatus(2));

        Assert.assertEquals("Choose your option", giveFeedPage.getSelectedDropDownOption());

        String backGroundColor = giveFeedPage.sendButton().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

        String letterColor = giveFeedPage.sendButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);


    }

    @Test
    public void scenario2() {
        giveFeedPage.sendButton().click();
        Assert.assertTrue(feedPage.getYourName().isEmpty());
        Assert.assertTrue(feedPage.getYourAge().isEmpty());
        Assert.assertEquals("", feedPage.getYourLanguage());
        Assert.assertEquals("null", feedPage.getYourGender());
        Assert.assertEquals("null", feedPage.getYourOption());
        Assert.assertEquals("", feedPage.getYourComment());

        String yesBackGroundColor = feedPage.sendButtonYes().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesBackGroundColor);

        String yesLetterColor = feedPage.sendButtonYes().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesLetterColor);

        String noBackGroundColor = feedPage.sendButtonNo().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noBackGroundColor);

        String noLetterColor = feedPage.sendButtonNo().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noLetterColor);


    }

    @Test
    public void scenario3() {
        String name = giveFeedPage.setName("Joshua");
        String age = giveFeedPage.setAge("37");
        giveFeedPage.selectCheckbox(0);
        giveFeedPage.selectRadioButton(0);
        giveFeedPage.selectDropdownOption("Good");
        giveFeedPage.setComment("Per aspera ad astra");
        giveFeedPage.sendButton().click();
        Assert.assertEquals(name, feedPage.getYourName());
        Assert.assertEquals(age, feedPage.getYourAge());
        Assert.assertEquals("English", feedPage.getYourLanguage());
        Assert.assertEquals("male", feedPage.getYourGender());
        Assert.assertEquals("Good", feedPage.getYourOption());
        Assert.assertEquals("Per aspera ad astra", feedPage.getYourComment());

        String yesBackGroundColor = feedPage.sendButtonYes().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesBackGroundColor);

        String yesLetterColor = feedPage.sendButtonYes().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesLetterColor);

        String noBackGroundColor = feedPage.sendButtonNo().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noBackGroundColor);

        String noLetterColor = feedPage.sendButtonNo().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noLetterColor);


    }

}