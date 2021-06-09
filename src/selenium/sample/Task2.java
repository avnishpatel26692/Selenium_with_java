package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.PageObject.FeedBackPO;
import selenium.PageObject.GiveFeedBackPO;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static GiveFeedBackPO GiveFeedback;
    static FeedBackPO FeedBack;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().window().maximize();
        GiveFeedback = PageFactory.initElements(driver,GiveFeedBackPO.class);
        FeedBack = PageFactory.initElements(driver,FeedBackPO.class);

    }

    @After
    public void afterMethod() throws InterruptedException {
        //Close browser
        driver.quit();
    }

@Test
public void initialFeedbackPage() {
    Assert.assertTrue(GiveFeedback.getName().isEmpty());
    Assert.assertTrue(GiveFeedback.getAge().isEmpty());
    for (int i = 0; i <= 3; i++)
        Assert.assertFalse(GiveFeedback.getCheckboxes(i));
        Assert.assertTrue(GiveFeedback.getRadioButtons(2));
Assert.assertEquals("Choose your option",GiveFeedback.getDropDowns(1));
        String backGroundColor = GiveFeedback.getSendBtn().getCssValue("background-color");
        Assert.assertEquals("rgba(33, 150, 243, 1)",backGroundColor);
        String letterColor = GiveFeedback.getSendBtn().getCssValue("color");
        Assert.assertEquals("rgba(255, 255, 255, 1)",letterColor);}
   @Test
        public void emptyFeedbackPage() {
        Assert.assertTrue(GiveFeedback.getName().isEmpty());
        Assert.assertTrue(GiveFeedback.getAge().isEmpty());
        Assert.assertTrue(FeedBack.getName().isEmpty());
        Assert.assertTrue(FeedBack.getAge().isEmpty());
        Assert.assertTrue(FeedBack.getLanguage().isEmpty());
        Assert.assertEquals("null",FeedBack.getGenre());
        Assert.assertEquals("null",FeedBack.getOption());
      Assert.assertTrue(FeedBack.getComment().isEmpty());

      String YesBtnBackground = FeedBack.getYesBtn().getCssValue("background-color");
      Assert.assertEquals  ("rgb(76, 175, 80)",YesBtnBackground);
        String NoBtnBackground = FeedBack.getNoBtn().getCssValue("background-color");
        Assert.assertEquals  ("rgb(244, 67, 54)",NoBtnBackground);
    }
@Test
        public void feedbackPage(){
    FeedBack.enterName("Margarita");
    FeedBack.enterAge("60");
    GiveFeedback.getCheckboxes(1);
    GiveFeedback.getRadioButtons(1);
    GiveFeedback.getDropDowns(1);
    FeedBack.enterComment("Nothanx");
    Assert.assertEquals("Margarita",FeedBack.getName());
    Assert.assertEquals("60",FeedBack.getAge());
    Assert.assertEquals("French",GiveFeedback.getCheckboxes(1));
    Assert.assertEquals("female",GiveFeedback.getRadioButtons(1));
    Assert.assertEquals("Good",GiveFeedback.getDropDowns(1));
    Assert.assertEquals("Nothanx",FeedBack.getComment());

    String YesBtnBackground = FeedBack.getYesBtn().getCssValue("color");
    Assert.assertEquals  ("rgb(255, 255, 255)",YesBtnBackground);
    String NoBtnBackground = FeedBack.getNoBtn().getCssValue("color");
    Assert.assertEquals  ("rgb(255, 255, 255)",YesBtnBackground);


}}




