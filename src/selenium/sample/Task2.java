package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.FeedBackPO;
import selenium.pageObject.GiveFeedbackPO;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static FeedBackPO FeedBackPO;
    static GiveFeedbackPO GiveFeedbackPO;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        GiveFeedbackPO = PageFactory.initElements(driver, GiveFeedbackPO.class);
        FeedBackPO = PageFactory.initElements(driver, FeedBackPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & GiveFeedbackPO

    //1 Test
    //TODO:
    //check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Genre"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters

    @Test
    public void firstFeedbackPage() {
        Assert.assertTrue(GiveFeedbackPO.getName().isEmpty());
        Assert.assertTrue(GiveFeedbackPO.getAge().isEmpty());

        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(GiveFeedbackPO.getLanguageButtonStatus(i));
        }

        Assert.assertTrue(GiveFeedbackPO.getRadioButtonStatus(2));
        Assert.assertEquals("Choose your option", GiveFeedbackPO.getSelDropDown());
        String buttonBackgroundColor = GiveFeedbackPO.submitButton().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", buttonBackgroundColor);
        String buttonTextColor = GiveFeedbackPO.submitButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", buttonTextColor);

    }

    //2 Test
    @Test
    public void emptyFeedbackPage() {
        //TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        GiveFeedbackPO.submitButton().click();

        Assert.assertTrue(FeedBackPO.getName().isEmpty());
        Assert.assertTrue(FeedBackPO.getAge().isEmpty());
        Assert.assertEquals("", FeedBackPO.getLanguage());
        Assert.assertEquals("null", FeedBackPO.getGenre());
        Assert.assertEquals("null", FeedBackPO.getOption());
        Assert.assertEquals("", FeedBackPO.getComment());

        String yesBackGroundColor = FeedBackPO.sendYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesBackGroundColor);

        String yesLetterColor = FeedBackPO.sendYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesLetterColor);

        String noBackGroundColor = FeedBackPO.sendNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", noBackGroundColor);

        String noLetterColor = FeedBackPO.sendNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", noLetterColor);

    }

    //3 Test
    @Test
    public void feedbackPage() {
        //TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

        String name = GiveFeedbackPO.setName("Veronika");
        String age = GiveFeedbackPO.setAge("39");
        GiveFeedbackPO.chooseCheckbox(0);
        GiveFeedbackPO.chooseRadioButton(1);
        GiveFeedbackPO.chooseSelDropDown("Why me?");
        GiveFeedbackPO.setComment("Quite hard to do it alone, but interesting!");
        GiveFeedbackPO.submitButton().click();
        Assert.assertEquals(name, FeedBackPO.getName());
        Assert.assertEquals(age, FeedBackPO.getAge());
        Assert.assertEquals("English", FeedBackPO.getLanguage());
        Assert.assertEquals("female", FeedBackPO.getGenre());
        Assert.assertEquals("Why me?", FeedBackPO.getOption());
        Assert.assertEquals("Quite hard to do it alone, but interesting!", FeedBackPO.getComment());

        String xBackGroundColor = FeedBackPO.sendYesButton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", xBackGroundColor);

        String xLetterColor = FeedBackPO.sendYesButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", xLetterColor);

        String yBackGroundColor = FeedBackPO.sendNoButton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", yBackGroundColor);

        String yLetterColor = FeedBackPO.sendNoButton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yLetterColor);


    }


}
