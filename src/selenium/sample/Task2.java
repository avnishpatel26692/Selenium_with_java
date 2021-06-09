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

public class Task2 {

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
        Thread.sleep(1000);
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO


    //TODO:
    //check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Gender"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters
    @Test
    public void initialFeedbackPage() {
        //CHeck all fields are empty
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());


        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());


        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedBackPO.getCheckBoxStatus(i));
        }

        //Check "Don't know" is selected in "Gender"
        Assert.assertTrue(giveFeedBackPO.getRadioBtnStatus(2));

        //"Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedDropDownOption());

        //check that the button send is blue with white letters
        String backGroundColor = giveFeedBackPO.sendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

        String letterColor = giveFeedBackPO.sendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
    }

    //2 Test
//    @Test
//    public void emptyFeedbackPage() {
//        //TODO:
////         click "Send" without entering any data
////         check fields are empty or null
////         check button colors
////         (green with white letter and red with white letters)
//    }

    @Test
//     check fields are empty or null


    public void emptyFeedbackPage() {
        giveFeedBackPO.cliclOnSendBtn();
        Assert.assertTrue(feedBackPO.getName().isEmpty());
        Assert.assertTrue(feedBackPO.getAge().isEmpty());
        Assert.assertTrue(feedBackPO.getLanguage().isEmpty());

        String actualDropDown = feedBackPO.getSelectedDropDownOption();
        Assert.assertEquals("null", actualDropDown);

        String actualOption = feedBackPO.getOption();
        Assert.assertEquals("null", actualOption);

        Assert.assertTrue(feedBackPO.getComment().isEmpty());

        //   check button colors (green with white letter and red with white letters)

        String backGroundColorbtnbtnYes = feedBackPO.btnYes().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", backGroundColorbtnbtnYes);

        String letterColorbtnYes = feedBackPO.btnYes().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColorbtnYes);

        String letterColorbtnNo = feedBackPO.btnNo().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColorbtnNo);

        String backGroundColorbtnNo = feedBackPO.btnNo().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", backGroundColorbtnNo);
    }


    //3 Test
    @Test
    public void feedbackPage() {
        //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
    }


}