package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.PageObject.FeedBackPO;
import selenium.PageObject.GiveFeedBackPO;

import java.util.List;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;
    static GiveFeedBackPO giveFeedBackPO;
    static FeedBackPO feedBackPO;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/tasks/provide_feedback");
        web.manage().window().maximize();
        giveFeedBackPO = PageFactory.initElements(web, GiveFeedBackPO.class);
        feedBackPO = PageFactory.initElements(web, FeedBackPO.class);
    }

    @Test
    public void initialFeedbackPage()
    {
        //TODO:
        //check that all field are empty and no tick are clicked
        //"Don't know" is selected in "Genre"
        //"Choose your option" in "How do you like us?"
        giveFeedBackPO.isEmpty();
        //check that the button send is blue with white letters
        giveFeedBackPO.checkButton();
    }

    @Test
    public void emptyFeedbackPage()
    {
        //TODO:
//         click "Send" without entering any data
        giveFeedBackPO.isEmpty();
        giveFeedBackPO.submit();
//         check fields are empty or null
        feedBackPO.isEmpty();
//         check button colors
//         (green with white letter and red with white letters)
        feedBackPO.checkButtons();
    }

    @Test
    public void feedbackPage()
    {
        //TODO:
//         fill the whole form, click "Send"
        giveFeedBackPO.enterName("Daniils");
        giveFeedBackPO.enterAge(20);
        giveFeedBackPO.chooseLanguage("English, French");
        giveFeedBackPO.chooseGender("male");
        giveFeedBackPO.chooseOption(2);
        giveFeedBackPO.addComment("This comment is made for testing");

        String name = giveFeedBackPO.getName();
        String age = giveFeedBackPO.getAge();
        List<String> languages = giveFeedBackPO.getLanguages();
        String gender = giveFeedBackPO.getGender();
        String option = giveFeedBackPO.getOption();
        String comment = giveFeedBackPO.getComment();

        giveFeedBackPO.submit();

//         check fields are filled correctly
        Assert.assertEquals(name,feedBackPO.resultName());
        Assert.assertEquals(age,feedBackPO.resultAge());
        for(String e : languages){
            Assert.assertTrue(feedBackPO.resultLanguage().contains(e));
        }
        Assert.assertEquals(gender,feedBackPO.resultGender());
        Assert.assertEquals(option,feedBackPO.resultOption());
        Assert.assertEquals(comment,feedBackPO.resultComment());
//         check button colors
//         (green with white letter and red with white letters)
        feedBackPO.checkButtons();
    }

    @After
    public void afterMethod(){
        try {
            Thread.sleep(2500);
        }
        catch(Exception e){};
        web.close();
    }
}