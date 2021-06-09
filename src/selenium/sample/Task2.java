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
import pageObject.FeedBackPO;
import pageObject.GiveFeedBackPO;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedBackPO;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver,GiveFeedBackPO.class);
        feedBackPO = PageFactory.initElements(driver,FeedBackPO.class);

    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO

    //1 Test
    @Test
    public void initialFeedbackPage()
    {
        //TODO:
        //check that all field are empty and no tick are clicked
        //"Don't know" is selected in "Genre"
        //"Choose your option" in "How do you like us?"
        //check that the button send is blue with white letters
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());
        for(int i = 0; i<=3; i++){
            Assert.assertFalse(giveFeedBackPO.getLanguageCheckboxes(i));
        }
        Assert.assertTrue(giveFeedBackPO.getRadioBtn(2));
        Assert.assertEquals("Choose your option",giveFeedBackPO.getDropDown());
        String backGroundColor = giveFeedBackPO.getSendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)",backGroundColor);
        String letterColor = giveFeedBackPO.getSendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColor);

    }

    //2 Test
    @Test
    public void emptyFeedbackPage()
    {
        //TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        giveFeedBackPO.clickOnSubmitBtn();

        Assert.assertTrue(feedBackPO.getName().isEmpty());
        Assert.assertTrue(feedBackPO.getAge().isEmpty());
        Assert.assertTrue(feedBackPO.getLanguage().isEmpty());
        Assert.assertEquals("null",feedBackPO.getGender());
        Assert.assertEquals("null",feedBackPO.getOption());
        Assert.assertTrue(feedBackPO.getComment().isEmpty());

        String backGroundColorYes = feedBackPO.getBtnYes().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColorYes);
        String letterColorYes = feedBackPO.getBtnYes().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorYes);

        String backGroundColorNo = feedBackPO.getBtnNo().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColorNo);
        String letterColorNo = feedBackPO.getBtnNo().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColorNo);
    }

    //3 Test
    @Test
    public void feedbackPage() {
        //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        giveFeedBackPO.setName("Kristiana");
        giveFeedBackPO.setAge("21");
        giveFeedBackPO.setLanguageCheckboxes(1);
        giveFeedBackPO.setGenderRadioBtn(1);
        giveFeedBackPO.setDropDown("Good");
        giveFeedBackPO.setCommentTxtBox("Testing");
        giveFeedBackPO.clickOnSubmitBtn();

        Assert.assertEquals("Kristiana",feedBackPO.getName());
        Assert.assertEquals("21",feedBackPO.getAge());
        Assert.assertEquals("French",feedBackPO.getLanguage());
        Assert.assertEquals("female",feedBackPO.getGender());
        Assert.assertEquals("Good",feedBackPO.getOption());
        Assert.assertEquals("Testing",feedBackPO.getComment());

        String backGroundColorYes = feedBackPO.getBtnYes().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColorYes);
        String letterColorYes = feedBackPO.getBtnYes().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColorYes);

        String backGroundColorNo = feedBackPO.getBtnNo().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColorNo);
        String letterColorNo = feedBackPO.getBtnNo().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColorNo);

        feedBackPO.clickBtnYes();

//        Assert.assertEquals("Thank you, Kristiana, for your feedback!", );


    }
}
