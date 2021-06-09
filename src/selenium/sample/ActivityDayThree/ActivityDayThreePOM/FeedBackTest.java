package selenium.sample.ActivityDayThree.ActivityDayThreePOM;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class FeedBackTest {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedBackPO;
    static FinalMessagePO finalMessagePO;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedBackPO = PageFactory.initElements(driver, FeedBackPO.class);
        finalMessagePO = PageFactory.initElements(driver, FinalMessagePO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO



    //check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Genre"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters
    @Test
    public void initialFeedbackPage() {
        //Verify Name is blank
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());

        //Verify Age is blank
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());

        // Verify checkboxes are not checked
        for (int i = 0; i <= 3; i++) {
            Assert.assertFalse(giveFeedBackPO.getLanguageCheckbox(i));
        }

        //Verify "Don't Know" gender is selected
        Assert.assertTrue(giveFeedBackPO.getRadioBtnStatus(2));

        //"Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedDropDownOption());

        //Check Send button is having blue Background color
        String backGroundColor = giveFeedBackPO.sendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)", backGroundColor);

        //Check Send button is having while letters
        String letterColor = giveFeedBackPO.sendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", letterColor);
    }

    //2 Test
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//        (green with white letter and red with white letters)
    @Test
    public void emptyFeedbackPage() {
        giveFeedBackPO.sendBtn().click();
        Assert.assertTrue(feedBackPO.getName().isEmpty());
        Assert.assertTrue(feedBackPO.getAge().isEmpty());
        Assert.assertTrue(feedBackPO.getLanguage().isEmpty());
        String expected = "null";
        Assert.assertEquals(expected, feedBackPO.getGender());
        Assert.assertEquals(expected, feedBackPO.getOption());
        Assert.assertTrue(feedBackPO.getComment().isEmpty());
        WebElement yesbutton = feedBackPO.getYesbutton();
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesbutton.getCssValue("background-color"));
        WebElement nobutton = feedBackPO.getNobutton();
        Assert.assertEquals("rgba(244, 67, 54, 1)", nobutton.getCssValue("background-color"));
        String yesbuttonLetter = feedBackPO.getYesbutton().getCssValue("text-decoration-color");
        Assert.assertEquals("rgb(255, 255, 255)", yesbuttonLetter);
        String nobuttonLetter = feedBackPO.getNobutton().getCssValue("text-decoration-color");
        Assert.assertEquals("rgb(255, 255, 255)", nobuttonLetter);

    }


//3 Test
////         fill the whole form, click "Send"
////         check fields are filled correctly

    @Test
    public void feedbackPage() throws InterruptedException {
        giveFeedBackPO.setName("Bob");
        giveFeedBackPO.setAge("25");
        giveFeedBackPO.selectLanguageCheckbox(2);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectDropdownOption("Why me?");
        giveFeedBackPO.setComment("ManyThanksToAvnishForHisHelp");
        Thread.sleep(3000);
        giveFeedBackPO.clickSendBtn();


        Assert.assertEquals("Bob", feedBackPO.getName());
        Assert.assertEquals("25", feedBackPO.getAge());
        Assert.assertEquals("Spanish", feedBackPO.getLanguage());
        Assert.assertEquals("male", feedBackPO.getGender());
        Assert.assertEquals("Why me?", feedBackPO.getOption());
        Assert.assertEquals("ManyThanksToAvnishForHisHelp", feedBackPO.getComment());
        WebElement yesbutton = feedBackPO.getYesbutton();
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesbutton.getCssValue("background-color"));
        WebElement nobutton = feedBackPO.getNobutton();
        Assert.assertEquals("rgba(244, 67, 54, 1)", nobutton.getCssValue("background-color"));
        String yesbuttonLetter = feedBackPO.getYesbutton().getCssValue("text-decoration-color");
        Assert.assertEquals("rgb(255, 255, 255)", yesbuttonLetter);
        String nobuttonLetter = feedBackPO.getNobutton().getCssValue("text-decoration-color");
        Assert.assertEquals("rgb(255, 255, 255)", nobuttonLetter);

        Thread.sleep(1000);
        feedBackPO.getYesbutton().click();


        Thread.sleep(3000);
        Assert.assertEquals(finalMessagePO.getMessage().getText(),"Thank you, Bob, for your feedback!");
//check button colors
//(green with white letter and red with white letters)

        String messageLetter = finalMessagePO.getMessage().getCssValue("text-decoration-color");
        Assert.assertEquals("rgb(255, 255, 255)", messageLetter);
        String messageBackground = finalMessagePO.getMessage().getCssValue("background-color");
        Assert.assertEquals("rgba(0, 0, 0, 0)", messageBackground);
    }
}


