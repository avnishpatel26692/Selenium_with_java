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

import selenium.PageObject.AgePagePO;
import selenium.PageObject.AgeSubmittedPO;

public class Sample12Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;
    static AgePagePO agePagePO;
    static AgeSubmittedPO ageSubmittedPO;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/age.html");
        web.manage().window().maximize();
        agePagePO = PageFactory.initElements(web,AgePagePO.class);
        ageSubmittedPO = PageFactory.initElements(web,AgeSubmittedPO.class);
    }

    @Test
    public void scenario1(){
        agePagePO.enterName("ABC");
        agePagePO.enterAge("40");
        agePagePO.submit();
        Assert.assertEquals("Hello, ABC, you are an adult",ageSubmittedPO.msg());
    }

    @Test
    public void scenario2(){
        agePagePO.enterName("ABC");
        agePagePO.submit();
        Assert.assertEquals("You haven't entered anything in age field",agePagePO.errorMsg());
    }

    @Test
    public void scenario3(){
        agePagePO.enterAge("20");
        agePagePO.submit();
        Assert.assertEquals("You haven't entered anything in name field",agePagePO.errorMsg());
    }

    @Test
    public void scenario4(){
        agePagePO.enterName("ABC");
        agePagePO.enterAge("16");
        agePagePO.submit();
        Assert.assertEquals("Hello, ABC, you are a teenager",ageSubmittedPO.msg());
    }

    @Test
    public void scenario5(){
        agePagePO.enterName("ABC");
        agePagePO.enterAge("0");
        agePagePO.submit();
        Assert.assertEquals("Hello, ABC, you are a kid",ageSubmittedPO.msg());
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
