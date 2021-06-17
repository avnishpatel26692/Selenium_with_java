package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.FeedBackPO;
import pageObject.GiveFeedBackPO;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO FeedBackPO;


    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver,GiveFeedBackPO.class);
        FeedBackPO = PageFactory.initElements(driver, FeedBackPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }


    @Test
    public void initialFeedbackPage()
    {
        //TODO:
        //check that all field are empty and no tick are clicked
        //"Don't know" is selected in "Genre"
        //"Choose your option" in "How do you like us?"
        //check that the button send is blue with white letters


        Assert.assertTrue(giveFeedBackPO.getNameValue().isEmpty());
        Assert.assertTrue(giveFeedBackPO.getAgeValue().isEmpty());

        Assert.assertFalse(giveFeedBackPO.IsCheckbox());  // no checkboxes are selected
        Assert.assertTrue(giveFeedBackPO.isRadioSelected(2));  // "Don't know"

        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption());// "Choose your option'

        Assert.assertEquals("", giveFeedBackPO.getComment());// comment is empty


        // compare background color
        String backGroundColor = giveFeedBackPO.sendButton().getCssValue("background-color"); // get background color of the button
        Assert.assertEquals("rgba(33, 150, 243, 1)",backGroundColor); // compare with blue

        // compare text color
        String textColor = giveFeedBackPO.sendButton().getCssValue("color"); // get text color (it should be white)
        Assert.assertEquals("rgba(255, 255, 255, 1)",textColor); // compare with white

    }


    @Test
    public void emptyFeedbackPage()
    {
        giveFeedBackPO.sendButton().click();
        Assert.assertEquals("",FeedBackPO.getNameValue());
        Assert.assertEquals("",FeedBackPO.getAgeValue());
        Assert.assertEquals("",FeedBackPO.get2LangValue());
        Assert.assertEquals("null",FeedBackPO.getGenderValue());
        Assert.assertEquals("null",FeedBackPO.getOptionValue());
        Assert.assertEquals("",FeedBackPO.getComment());

        String backGroundColor = FeedBackPO.yesButton().getCssValue("background-color"); // get background color of the Yes button
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColor); // compare with green

        // compare text color
        String textColor = FeedBackPO.yesButton().getCssValue("color"); // get text color (it should be white)
        Assert.assertEquals("rgba(255, 255, 255, 1)",textColor); // compare with white

        backGroundColor = FeedBackPO.noButton().getCssValue("background-color"); // get background color of the No button
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColor); // compare with red



        textColor = FeedBackPO.noButton().getCssValue("color"); // get text color (it should be white)
        Assert.assertEquals("rgba(255, 255, 255, 1)",textColor); // compare with white

    }

    @Test
    public void feedbackPage()
    {

        giveFeedBackPO.setNameValue("ABC");
        giveFeedBackPO.setAgeValue("30");
        giveFeedBackPO.selectCheckbox(0);  // english
        giveFeedBackPO.selectRadioButton(0); //male
        giveFeedBackPO.selectOption("Good");
        giveFeedBackPO.setComment("comment");
        giveFeedBackPO.sendButton().click();

        Assert.assertEquals("ABC", FeedBackPO.getNameValue());
        Assert.assertEquals("30", FeedBackPO.getAgeValue());
        Assert.assertEquals("English", FeedBackPO.get2LangValue());
        Assert.assertEquals("male", FeedBackPO.getGenderValue());
        Assert.assertEquals("Good", FeedBackPO.getOptionValue());
        Assert.assertEquals("comment", FeedBackPO.getComment());

        String backGroundColor = FeedBackPO.yesButton().getCssValue("background-color"); // get background color of the button
        Assert.assertEquals("rgba(76, 175, 80, 1)",backGroundColor); // compare with green


        String textColor = FeedBackPO.yesButton().getCssValue("color"); // get text color (it should be white)
        Assert.assertEquals("rgba(255, 255, 255, 1)",textColor); // compare with white

        backGroundColor = FeedBackPO.noButton().getCssValue("background-color"); // get background color of the button
        Assert.assertEquals("rgba(244, 67, 54, 1)",backGroundColor); // compare with red

        // compare text color
        textColor = FeedBackPO.noButton().getCssValue("color"); // get text color (it should be white)
        Assert.assertEquals("rgba(255, 255, 255, 1)",textColor); // compare with white

    }
    }
