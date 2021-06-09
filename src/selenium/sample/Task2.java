package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.FeedBackPO;
import selenium.pageObject.GiveFeedBackPO;


public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "//lib//";
    WebDriver driver;
    static FeedBackPO feedBack;
    static GiveFeedBackPO giveFeedBack;
    private FeedBackPO feedBackPO;


    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBack = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedBack = PageFactory.initElements(driver, FeedBackPO.class);

    }


    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO

    //1 Test
    @Test
    public void initialFeedbackPage() {
        //TODO:
        //check that all field are empty and no tick are clicked
        //"Don't know" is selected in "Genre"
        //"Choose your option" in "How do you like us?
        // check that the button send is blue with white letters

            Assert.assertTrue(giveFeedBack.getName().isEmpty());
            Assert.assertTrue(giveFeedBack.getAge().isEmpty());

            for (int i = 0; i <= 3; i++) {
                Assert.assertFalse(giveFeedBack.getLanguageCheckBoxStatus(i));
            }

            Assert.assertTrue(giveFeedBack.getRadioBtnStatus(2));
            Assert.assertEquals("Choose your option", giveFeedBack.getSelectedDropDownOption());

            String backGroundColor = giveFeedBack.sendBtn().getCssValue("background-color");
            Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

            String letterColor = giveFeedBack.sendBtn().getCssValue("color");
            Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);

        }


        //2 Test
    @Test
    public void emptyFeedbackPage() {
            //TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        GiveFeedBackPO.sendBtn().click();
        String actualMessage = FeedBackPO.checkName();
        Assert.assertEquals("", actualMessage);
        String actualMessage1 = FeedBackPO.checkAge();
        Assert.assertEquals("", actualMessage1);
        String actualMessage2 = FeedBackPO.checkLanguage();
        Assert.assertEquals("", actualMessage2);
        String actualMessage3 = FeedBackPO.checkGender();
        Assert.assertEquals("null", actualMessage3);
        String actualMessage4 = FeedBackPO.checkLikeUs();
        Assert.assertEquals("null", actualMessage4);
        String actualMessage5 = FeedBackPO.checkComment();
        Assert.assertEquals("", actualMessage5);

        Assert.assertEquals("rgba(76, 175, 80, 1)",FeedBackPO.getYesBtn().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",FeedBackPO.getYesBtn().getCssValue("color"));
        Assert.assertEquals("rgba(244, 67, 54, 1)",FeedBackPO.getNoBtn().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",FeedBackPO.getNoBtn().getCssValue("color"));
    }


        //3 Test
    @Test
    public void feedbackPage()
        {
            //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

            GiveFeedBackPO.setName("Elena");
            GiveFeedBackPO.setAge("31");
            GiveFeedBackPO.selectCheckbox(1);
            GiveFeedBackPO.selectRadioBtn(2);
            GiveFeedBackPO.selectDropdownOption("Good");
            GiveFeedBackPO.setComment("Hello Wednesday");
            GiveFeedBackPO.sendBtn().click();

            String actualMessage = FeedBackPO.checkName();
            Assert.assertEquals("Elena", actualMessage);
            String actualMessage1 = FeedBackPO.checkAge();
            Assert.assertEquals("31", actualMessage1);
            String actualMessage2 = FeedBackPO.checkLanguage();
            Assert.assertEquals("English", actualMessage2);
            String actualMessage3 = FeedBackPO.checkGender();
            Assert.assertEquals("female", actualMessage3);
            String actualMessage4 = FeedBackPO.checkLikeUs();
            Assert.assertEquals("Good", actualMessage4);
            String actualMessage5 = FeedBackPO.checkComment();
            Assert.assertEquals("Hello Wednesday", actualMessage5);

            Assert.assertEquals("rgba(76, 175, 80, 1)",FeedBackPO.getYesBtn().getCssValue("background-color"));
            Assert.assertEquals("rgba(255, 255, 255, 1)",FeedBackPO.getYesBtn().getCssValue("color"));
            Assert.assertEquals("rgba(244, 67, 54, 1)",FeedBackPO.getNoBtn().getCssValue("background-color"));
            Assert.assertEquals("rgba(255, 255, 255, 1)",FeedBackPO.getNoBtn().getCssValue("color"));
        }

}
