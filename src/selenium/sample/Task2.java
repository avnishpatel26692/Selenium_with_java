package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

    //2 PageObject class GiveFeedBackPO & FeedBackPO

    //1 Test
    @Test
    public void initialFeedbackPage()
    {
        //TODO:
         //check that all field are empty and no tick are clicked
         //"Don't know" is selected in "Genre"
         //"Choose your option" in "How do you like us?"
         //check that the button send is blue with white letters
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
