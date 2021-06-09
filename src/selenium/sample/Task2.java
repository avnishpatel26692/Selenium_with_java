package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.GiveFeedBackPO;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO giveFeedBackPO;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPO.class);
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
    }




}
