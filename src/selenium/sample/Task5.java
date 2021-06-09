package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.FeedBackPO;
import selenium.pageObject.GiveFeedBackPO;

public class Task5 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedBackPO;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedBackPO = PageFactory.initElements(driver, FeedBackPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //Test1
    @Test
    public void initialFeedbackPage() {

        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());

        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedBackPO.getLanguageCheckBoxStatus(i));
        }
        for (int i = 0; i <= 1; i++) {
            Assert.assertFalse(giveFeedBackPO.getRadioBtnStatus(i));
        }
        Assert.assertTrue(giveFeedBackPO.getRadioBtnStatus(2));


        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption());


        String backGroundColor = giveFeedBackPO.sendButton().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

        String letterColor = giveFeedBackPO.sendButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
    }


    //Test2
    @Test
    public void emptyFields() {
        giveFeedBackPO.sendButton().click();
        Assert.assertTrue(feedBackPO.getName().isEmpty());
        Assert.assertTrue(feedBackPO.getAge().isEmpty());
        Assert.assertTrue(feedBackPO.getLanguage().isEmpty());
        Assert.assertEquals("null", feedBackPO.getGender());
        Assert.assertEquals("null", feedBackPO.getOption());
        Assert.assertTrue(feedBackPO.getComment().isEmpty());


        String backGroundColour = feedBackPO.getGreenButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", backGroundColour);
        String backGroundColour2 = feedBackPO.getRedButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", backGroundColour2);
    }

    //Test3
    @Test
    public void colourbutton() {
        giveFeedBackPO.setName("Artur");
        giveFeedBackPO.setAge("30");
        giveFeedBackPO.selectCheckbox(0);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectOption("Good");
        giveFeedBackPO.setComment("Have a good day!");
        giveFeedBackPO.sendButton().click();

        Assert.assertEquals("Artur", feedBackPO.getName());
        Assert.assertEquals("30", feedBackPO.getAge());
        Assert.assertEquals("English", feedBackPO.getLanguage());
        Assert.assertEquals("male", feedBackPO.getGender());
        Assert.assertEquals("Good", feedBackPO.getOption());
        Assert.assertEquals("Have a good day!", feedBackPO.getComment());


        //check button colors
        String backGroundColour = feedBackPO.getGreenButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", backGroundColour);
        String backGroundColour2 = feedBackPO.getRedButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", backGroundColour2);

    }


}