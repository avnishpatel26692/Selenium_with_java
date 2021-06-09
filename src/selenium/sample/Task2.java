package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pageObject.FeedbackPO;
import selenium.pageObject.GiveFeedbackPO;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedbackPO giveFeedbackPage;
    static FeedbackPO feedbackPage;

    @Before
    public void beforeMethod() {

        //Define driver
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");

        driver.manage().window().maximize();
        giveFeedbackPage = PageFactory.initElements(driver, GiveFeedbackPO.class);
        feedbackPage = PageFactory.initElements(driver, FeedbackPO.class);
    }


    //2 Page classes - GiveFeedbackPO & FeedbackPO

    //1st Test
    @Test
    public void initialFeedbackPage() {
        Assert.assertTrue(giveFeedbackPage.getName().isEmpty());
        Assert.assertTrue(giveFeedbackPage.getAge().isEmpty());
        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedbackPage.checkCheckboxChecked(i));
        }
        Assert.assertTrue(giveFeedbackPage.checkRadioButtonSelected(2));
        Assert.assertEquals("Choose your option", giveFeedbackPage.checkOptionSelected());
        Assert.assertTrue( giveFeedbackPage.getComment().isEmpty());
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedbackPage.getButtonBGColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPage.getButtonTextColor());
    }

    //2nd Test
    @Test
    public void emptyFeedbackPage() {
        giveFeedbackPage.clickSendButton();
        Assert.assertTrue(feedbackPage.getName().isEmpty());
        Assert.assertTrue(feedbackPage.getAge().isEmpty());
        Assert.assertTrue(feedbackPage.getLanguage().isEmpty());
        Assert.assertEquals("null", feedbackPage.getGender());
        Assert.assertEquals("null", feedbackPage.getOption());
        Assert.assertTrue(feedbackPage.getComment().isEmpty());
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedbackPage.getYesButtonBGColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPage.getYesButtonTextColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedbackPage.getNoButtonBGColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPage.getNoButtonTextColor());
    }

    //3rd Test
    @Test
    public void feedbackPage() {
        //1st page
        giveFeedbackPage.setName("ABC");
        Assert.assertEquals("ABC", giveFeedbackPage.getName());
        giveFeedbackPage.setAge("16");
        Assert.assertEquals("16", giveFeedbackPage.getAge());
        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedbackPage.checkCheckboxChecked(i));
            giveFeedbackPage.checkCheckbox(i);
            Assert.assertTrue(giveFeedbackPage.checkCheckboxChecked(i));
        }
        Assert.assertTrue(giveFeedbackPage.checkRadioButtonSelected(2));
        giveFeedbackPage.selectRadioButton(0);
        Assert.assertFalse(giveFeedbackPage.checkRadioButtonSelected(2));
        Assert.assertTrue(giveFeedbackPage.checkRadioButtonSelected(0));
        giveFeedbackPage.selectRadioButton(1);
        Assert.assertTrue(giveFeedbackPage.checkRadioButtonSelected(1));
        Assert.assertFalse(giveFeedbackPage.checkRadioButtonSelected(0));
        giveFeedbackPage.selectRadioButton(2);
        Assert.assertFalse(giveFeedbackPage.checkRadioButtonSelected(2));
        Assert.assertTrue(giveFeedbackPage.checkRadioButtonSelected(1));
        giveFeedbackPage.selectOptionFromDropdown(1);
        Assert.assertEquals("Good", giveFeedbackPage.checkOptionSelected());
        giveFeedbackPage.setComment("This is a comment");
        Assert.assertEquals("This is a comment", giveFeedbackPage.getComment());
        giveFeedbackPage.clickSendButton();
        //2nd page
        Assert.assertEquals("ABC",feedbackPage.getName());
        Assert.assertEquals("16", feedbackPage.getAge());
        Assert.assertEquals("English,French,Spanish,Chinese", feedbackPage.getLanguage());
        Assert.assertEquals("female", feedbackPage.getGender());
        Assert.assertEquals("Good", feedbackPage.getOption());
        Assert.assertEquals("This is a comment", feedbackPage.getComment());
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedbackPage.getYesButtonBGColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPage.getYesButtonTextColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedbackPage.getNoButtonBGColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPage.getNoButtonTextColor());
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }
}
