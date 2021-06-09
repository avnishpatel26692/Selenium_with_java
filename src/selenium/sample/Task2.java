package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageObject.feedBack;
import selenium.pageObject.giveFeedBack;
import java.util.List;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;
    static giveFeedBack giveFeedBack;
    static feedBack feedBack;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/tasks/provide_feedback");
        web.manage().window().maximize();
        giveFeedBack = PageFactory.initElements(web, giveFeedBack.class);
        feedBack = PageFactory.initElements(web, feedBack.class);
    }

    @After
    public void afterMethod() {
            try {
                Thread.sleep(2500);
            }
            catch(Exception e){};
            web.close();
        }


    //2 PageObject class GiveFeedBackPO & FeedBackPO

    //1 Test
    @Test
    public void initialFeedbackPage() {
        giveFeedBack.isEmpty();
        giveFeedBack.checkButton();

    }

    //2 Test
    @Test
    public void emptyFeedbackPage()
    {
        //TODO:

//         click "Send" without entering any data
        giveFeedBack.isEmpty();
        giveFeedBack.submit();

//         check fields are empty or null
        feedBack.isEmpty();
//         check button colors
//         (green with white letter and red with white letters)
        feedBack.checkButtons();
    }

    //3 Test
    @Test
    public void feedbackPage()
    {

//         check fields are filled correctly
        giveFeedBack.enterName("Eldar");
        giveFeedBack.enterAge(24);
        giveFeedBack.chooseLanguage("English, Spanish");
        giveFeedBack.chooseGender("male");
        giveFeedBack.chooseOption(4);
        giveFeedBack.addComment("Hallo, how are you?");

        String name = giveFeedBack.getName();
        String age = giveFeedBack.getAge();
        List<String> languages = giveFeedBack.getLanguages();
        String gender = giveFeedBack.getGender();
        String option = giveFeedBack.getOption();
        String comment = giveFeedBack.getComment();

        giveFeedBack.submit();

        Assert.assertEquals(name,feedBack.resultName());
        Assert.assertEquals(age,feedBack.resultAge());
        for(String e : languages){
            Assert.assertTrue(feedBack.resultLanguage().contains(e));
        }
        Assert.assertEquals(gender,feedBack.resultGender());
        Assert.assertEquals(option,feedBack.resultOption());
        Assert.assertEquals(comment,feedBack.resultComment());
//         check button colors
//         (green with white letter and red with white letters)
        feedBack.checkButtons();
    }




}