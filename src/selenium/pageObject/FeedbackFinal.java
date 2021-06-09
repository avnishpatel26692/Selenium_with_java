package selenium.pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FeedbackFinal{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GetFeedback getFeedback;
    static GiveFeedback giveFeedback;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        getFeedback = PageFactory.initElements(driver,GetFeedback.class);
        giveFeedback = PageFactory.initElements(driver,GiveFeedback.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO

    //1 Test
    @Test
    public void FeedbackPageEmpty()
    {
        Assert.assertTrue(giveFeedback.getName().isEmpty());
        Assert.assertTrue(giveFeedback.getAge().isEmpty());
        for(int i = 0;i<4;i++)
             Assert.assertFalse(giveFeedback.getcheckboxes(i));
        for(int i = 0;i<2;i++)
            Assert.assertFalse(giveFeedback.getradiobuttons(i));
        Assert.assertTrue(giveFeedback.getradiobuttons(2));
        Assert.assertEquals("Choose your option",giveFeedback.getDropDown());
        Assert.assertTrue(giveFeedback.getTextArea().isEmpty());
        Assert.assertEquals("rgba(33, 150, 243, 1)",giveFeedback.submit().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",giveFeedback.submit().getCssValue("color"));

    }

    //2 Test
    @Test
    public void emptyFeedbackPage()
    {
        giveFeedback.submit().click();
        Assert.assertTrue(getFeedback.getName().isEmpty());
        Assert.assertTrue(getFeedback.getAge().isEmpty());
        Assert.assertTrue(getFeedback.getComment().isEmpty());
        Assert.assertEquals("null",getFeedback.getOption());
        Assert.assertTrue(getFeedback.getLanguage().isEmpty());
        Assert.assertEquals("null",getFeedback.getGender());
        Assert.assertEquals("rgba(76, 175, 80, 1)",getFeedback.Yesbutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedback.Yesbutton().getCssValue("color"));
        Assert.assertEquals("rgba(244, 67, 54, 1)",getFeedback.Nobutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedback.Nobutton().getCssValue("color"));

    }

    //3 Test
    @Test
    public void feedbackPage()
    {
        giveFeedback.setName("Kirils");
        giveFeedback.setAge("27");
        giveFeedback.setTextarea("Hello World!");
        giveFeedback.Checkboxes(1);
        giveFeedback.selectDropdown("Bad");
        giveFeedback.radioButtons(1);
        giveFeedback.submit().click();

        Assert.assertEquals("Kirils",getFeedback.getName());
        Assert.assertEquals("27",getFeedback.getAge());
        Assert.assertEquals("Hello World!",getFeedback.getComment());
        Assert.assertEquals("French",getFeedback.getLanguage());
        Assert.assertEquals("female",getFeedback.getGender());
        Assert.assertEquals("Bad",getFeedback.getOption());

        Assert.assertEquals("rgba(76, 175, 80, 1)",getFeedback.Yesbutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedback.Yesbutton().getCssValue("color"));
        Assert.assertEquals("rgba(244, 67, 54, 1)",getFeedback.Nobutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",getFeedback.Nobutton().getCssValue("color"));




        //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
    }




}