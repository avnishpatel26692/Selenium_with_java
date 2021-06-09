package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        Thread.sleep(2000);
        //Close browser
        driver.quit();
    }

    @Test   //Test1
    public void initialFeedbackPage(){
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());

        for(int i=0; i<=3; i++){
            Assert.assertFalse(giveFeedBackPO.getLanguageCheckBoxStatus(i));
        }

        Assert.assertTrue(giveFeedBackPO.getRadioBtnStatus(2));

        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedDropDownOption());

        String backGroundColor = giveFeedBackPO.sendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)",backGroundColor);

        String letterColor = giveFeedBackPO.sendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColor);


    }

    @Test   //Test2
    public void emptyFeedbackPage(){
        giveFeedBackPO.sendBtn().click();
        String actualMessage = feedBackPO.checkName();
        Assert.assertEquals("", actualMessage);
        String actualMessage1 = feedBackPO.checkAge();
        Assert.assertEquals("", actualMessage1);
        String actualMessage2 = feedBackPO.checkLanguage();
        Assert.assertEquals("", actualMessage2);
        String actualMessage3 = feedBackPO.checkGender();
        Assert.assertEquals("null", actualMessage3);
        String actualMessage4 = feedBackPO.checkLikeUsLine();
        Assert.assertEquals("null", actualMessage4);
        String actualMessage5 = feedBackPO.checkComment();
        Assert.assertEquals("", actualMessage5);

        String backGroundColorYes = feedBackPO.yesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColorYes);
        String letterColorYes = feedBackPO.yesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorYes);

        String backGroundColorNo = feedBackPO.noButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColorNo);
        String letterColorNo = feedBackPO.noButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorNo);



    }

    @Test   //Test3
    public void feedbackPage(){

        giveFeedBackPO.setName("ABC");
        giveFeedBackPO.setAge("30");
        giveFeedBackPO.selectCheckbox(2);
        giveFeedBackPO.selectRadioBtn(1);
        giveFeedBackPO.selectDropdownOption("Good");
        giveFeedBackPO.setComment("ABC123");
        giveFeedBackPO.sendBtn().click();

        String actualMessage = feedBackPO.checkName();
        Assert.assertEquals("ABC", actualMessage);
        String actualMessage1 = feedBackPO.checkAge();
        Assert.assertEquals("30", actualMessage1);
        String actualMessage2 = feedBackPO.checkLanguage();
        Assert.assertEquals("Spanish", actualMessage2);
        String actualMessage3 = feedBackPO.checkGender();
        Assert.assertEquals("female", actualMessage3);
        String actualMessage4 = feedBackPO.checkLikeUsLine();
        Assert.assertEquals("Good", actualMessage4);
        String actualMessage5 = feedBackPO.checkComment();
        Assert.assertEquals("ABC123", actualMessage5);


        String backGroundColorYes = feedBackPO.yesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColorYes);
        String letterColorYes = feedBackPO.yesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorYes);

        String backGroundColorNo = feedBackPO.noButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColorNo);
        String letterColorNo = feedBackPO.noButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorNo);



    }
}
