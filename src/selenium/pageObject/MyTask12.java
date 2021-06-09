package selenium.pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



public class MyTask12 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static AgePageP0 agePageP0;
    static AgeSubmittedPO ageSubmittedPO;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/age.html");
        driver.manage().window().maximize();
        agePageP0 = PageFactory.initElements(driver,AgePageP0.class);
        ageSubmittedPO = PageFactory.initElements(driver,AgeSubmittedPO.class);

    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void scenario1(){
        agePageP0.Entername("ABC");
        agePageP0.Enterage("16");
        agePageP0.Submit();
        Assert.assertEquals("Hello, ABC, you are a teenager",ageSubmittedPO.getMessage());
    }

    @Test
    public void scenario2(){
        agePageP0.Enterage("5");
        agePageP0.Entername("ABC");
        agePageP0.Submit();
        Assert.assertEquals("Hello, ABC, you are a kid",ageSubmittedPO.getMessage());
    }

    @Test public void scenario3 ()
    {
        agePageP0.Entername("ABC");
        agePageP0.Submit();
        Assert.assertEquals("You haven't entered anything in age field",agePageP0.GetErrorMsg());
    }
    @Test public void scenario4 ()
    {
        agePageP0.Enterage("16");
        agePageP0.Submit();
        Assert.assertEquals("You haven't entered anything in name field",agePageP0.GetErrorMsg());
    }
    @Test public void scenario5 ()
    {
        agePageP0.Submit();
        Assert.assertEquals("You haven't entered anything in age field",agePageP0.GetErrorMsg());
    }



}


