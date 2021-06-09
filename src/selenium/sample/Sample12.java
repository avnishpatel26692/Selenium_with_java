package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pageObject.agePage;
import selenium.pageObject.ageSubmitted;


    public class Sample12 {

        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        WebDriver driver;
        static agePage agePage;
        static ageSubmitted ageSubmitted;

        @Before
        public void beforeMethod() {

            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
            driver = new ChromeDriver();
            driver.get("https://kristinek.github.io/site/examples/age.html");
            driver.manage().window().maximize();
            agePage = PageFactory.initElements(driver, agePage.class);
            ageSubmitted = PageFactory.initElements(driver, ageSubmitted.class);
        }

        @Test
        public void checkForAdult() {
            agePage.enterName("ABC");
            agePage.enterAge("36");
            agePage.clickOnSubmitButton();
            String actualMessage = ageSubmitted.getMessage();
            Assert.assertEquals("Hello, ABC, you are an adult", actualMessage);
        }

        @Test
        public void checkForTeenager() {
            agePage.enterName("ABC");
            agePage.enterAge("16");
            agePage.clickOnSubmitButton();
            String actualMessage = ageSubmitted.getMessage();
            Assert.assertEquals("Hello, ABC, you are a teenager", actualMessage);
        }

        @Test
        public void checkForKid() {
            agePage.enterName("ABC");
            agePage.enterAge("5");
            agePage.clickOnSubmitButton();
            String actualMessage = ageSubmitted.getMessage();
            Assert.assertEquals("Hello, ABC, you are a kid", actualMessage);
        }

        @Test
        public void validateErrorMessage() {
            agePage.enterName("Eldar");
            agePage.clickOnSubmitButton();
            String actualMessage = agePage.getErrorMessage();
            Assert.assertEquals("You haven't entered anything in age field", actualMessage);
        }

        @Test
        public void validateErrorMessage2() {
            agePage.enterAge("66");
            agePage.clickOnSubmitButton();
            String actualMessage = agePage.getErrorMessage();
            Assert.assertEquals("You haven't entered anything in name field", actualMessage);
        }

        @After
        public void afterMethod() throws InterruptedException {
            //Close browser
            driver.quit();
        }
    }

