package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.FeedbackEntryFormPO;
import selenium.pageObject.FeedbackResultPO;

import java.util.List;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    WebDriver driver;

    static FeedbackEntryFormPO feedbackEntryFormPO;
    static FeedbackResultPO feedbackResultPO;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        feedbackEntryFormPO = PageFactory.initElements(driver, FeedbackEntryFormPO.class);
        feedbackResultPO = PageFactory.initElements(driver, FeedbackResultPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //TODO:
    //check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Genre"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters

    @Test
    public void initialFeedbackPage() {

        Assert.assertTrue(feedbackEntryFormPO.getNameTxtBox().isEmpty());
        Assert.assertTrue(feedbackEntryFormPO.getAgeTxtBox().isEmpty());

        List<WebElement> checkboxList = feedbackEntryFormPO.getLanguageCheckboxes();
        for (WebElement checkbox : checkboxList) {
            Assert.assertFalse(checkbox.isSelected());
        }

        boolean radioBtn1 = feedbackEntryFormPO.radioBtnIsSelected(0);
        Assert.assertFalse(radioBtn1);

        boolean radioBtn2 = feedbackEntryFormPO.radioBtnIsSelected(1);
        Assert.assertFalse(radioBtn2);

        boolean radioBtn3 = feedbackEntryFormPO.radioBtnIsSelected(2);
        Assert.assertTrue(radioBtn3);

        Assert.assertEquals("Choose your option", feedbackEntryFormPO.getSelectHowDoYouLikeUsDropdownOption());

        String sendButtonLetterColor = feedbackEntryFormPO.getSendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", sendButtonLetterColor);

        String sendButtonBackgroundColor = feedbackEntryFormPO.getSendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", sendButtonBackgroundColor);
    }

    //2 Test
//    TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

    @Test
    public void emptyFeedbackPage() {

        feedbackEntryFormPO.clickOnSendButton();
        Assert.assertTrue(feedbackResultPO.getName().isEmpty());
        Assert.assertTrue(feedbackResultPO.getAge().isEmpty());
        Assert.assertTrue(feedbackResultPO.getLanguage().isEmpty());
        String expected = "null";
        Assert.assertEquals(expected,feedbackResultPO.getGender());
        Assert.assertEquals(expected, feedbackResultPO.getOption());
        Assert.assertTrue(feedbackResultPO.getComment().isEmpty());

        String yesButtonBackgroundColor = feedbackResultPO.getYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesButtonBackgroundColor);

        String yesButtonLetterColor = feedbackResultPO.getYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesButtonLetterColor);

        String noButtonBackgroundColor = feedbackResultPO.getNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noButtonBackgroundColor);

        String noButtonLetterColor = feedbackResultPO.getNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noButtonLetterColor);
    }

    //3 Test
    //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

    @Test
    public void feedbackPage() {
        feedbackEntryFormPO.enterName("Ilze");
        feedbackEntryFormPO.enterAge("30");
        feedbackEntryFormPO.selectLanguageCheckbox(0);
        feedbackEntryFormPO.selectGenreRadioBtn(1);
        feedbackEntryFormPO.selectDropdownHowDoYouLikeUsOption("Good");
        feedbackEntryFormPO.selectCommentBox();
        feedbackEntryFormPO.getCommentArea().sendKeys("This is test");
        feedbackEntryFormPO.clickOnSendButton();

        Assert.assertEquals("Ilze", feedbackResultPO.getName());
        Assert.assertEquals("30", feedbackResultPO.getAge());
        Assert.assertEquals("English", feedbackResultPO.getLanguage());
        Assert.assertEquals("female", feedbackResultPO.getGender());
        Assert.assertEquals("Good", feedbackResultPO.getOption());
        Assert.assertEquals("This is test", feedbackResultPO.getComment());

        String yesButtonBackgroundColor = feedbackResultPO.getYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesButtonBackgroundColor);

        String yesButtonLetterColor = feedbackResultPO.getYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesButtonLetterColor);

        String noButtonBackgroundColor = feedbackResultPO.getNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noButtonBackgroundColor);

        String noButtonLetterColor = feedbackResultPO.getNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noButtonLetterColor);

        feedbackResultPO.clickOnYesButton();
        Assert.assertEquals("Thank you, Ilze, for your feedback!", feedbackResultPO.getThankYouForFeedbackMessage());
    }
}
