package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.GiveFeedBackPO;
import pageObject.FeedBackPO;

public class Day3Sample2Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedback;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPO.class);
        feedback = PageFactory.initElements(driver, FeedBackPO.class);
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO


    //TODO:
    //check that all field are empty and no tick are clicked
    //"Don't know" is selected in "Genre"
    //"Choose your option" in "How do you like us?"
    //check that the button send is blue with white letters
    @Test
    public void initialFeedbackPage()
    {
        //Verify Name is blank
        Assert.assertTrue(giveFeedBackPO.getName().isEmpty());

        //Verify Age is blank
        Assert.assertTrue(giveFeedBackPO.getAge().isEmpty());

        // Verify checkboxes are not checked
        for(int i = 0; i <= 3; i++)
        {
            Assert.assertFalse(giveFeedBackPO.getLanguageCheckBoxStatus(i));
        }

        //Verify "Don't Know" gender is selected
        Assert.assertTrue(giveFeedBackPO.getRadioBtnStatus(2));

        //"Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedDropDownOption());

        //Check Send button is having blue Background color
        String backGroundColor = giveFeedBackPO.sendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)",backGroundColor);

        //Check Send button is having while letters
        String letterColor = giveFeedBackPO.sendBtn().getCssValue("color");
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
        giveFeedBackPO.sendBtn().click();
        Assert.assertTrue(feedback.getName().isEmpty());
        Assert.assertTrue(feedback.getAge().isEmpty());
        Assert.assertTrue(feedback.getComment().isEmpty());
        Assert.assertTrue(feedback.getLang().isEmpty());
        Assert.assertEquals("null", feedback.getGen());
        Assert.assertEquals("null", feedback.getOption());


        String yBackGroCol = feedback.sendYbutton().getCssValue("background-color");
        Assert.assertEquals("rgba(76, 175, 80, 1)", yBackGroCol);

        String yLetCol = feedback.sendYbutton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", yLetCol);

        String nBackGroCol = feedback.sendNbutton().getCssValue("background-color");
        Assert.assertEquals("rgba(244, 67, 54, 1)", nBackGroCol);

        String nLetCol = feedback.sendNbutton().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)", nLetCol);


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
        giveFeedBackPO.setName("Ilja");
        giveFeedBackPO.setAge("27");
        giveFeedBackPO.setComment("The person who love cats!");
        giveFeedBackPO.selectCheckbox(0);
        giveFeedBackPO.selectDropdownOption("Good");
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.sendBtn().click();

        Assert.assertEquals("Ilja",feedback.getName());
        Assert.assertEquals("27",feedback.getAge());
        Assert.assertEquals("The person who love cats!",feedback.getComment());
        Assert.assertEquals("English",feedback.getLang());
        Assert.assertEquals("male",feedback.getGen());
        Assert.assertEquals("Good",feedback.getOption());

        Assert.assertEquals("rgba(76, 175, 80, 1)",feedback.sendYbutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",feedback.sendYbutton().getCssValue("color"));
        Assert.assertEquals("rgba(244, 67, 54, 1)",feedback.sendNbutton().getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",feedback.sendNbutton().getCssValue("color"));




    }




}