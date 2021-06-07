package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Sample3 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void BegoreMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualsExampleCheck()
    {
        WebElement heading2 = driver.findElement(By.id("heading_2"));
        String expectedValue = "Heading 2 text";
        String actualValue = heading2.getText();
        Assert.assertEquals("Sorry, these values are not matching",expectedValue,actualValue);
    }

    @Test
    public void assertTrueExampleCheck()
    {
        WebElement button2 = driver.findElement(By.name("randomButton2"));
        String expectedValue = "This is also a button";
        String actualValue = button2.getAttribute("value");
        Assert.assertTrue(expectedValue.equalsIgnoreCase(actualValue));
    }

    @Test
    public void assertFalseCheck()  //check should false
    {
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "This is also a button";
        String actualValue = button1.getAttribute("value");
        Assert.assertFalse(expectedValue.equals(actualValue));
    }

    @Test
    public void assertFailCheck()
    {
        int salary = 1000;
        if (salary == 0){
            Assert.fail("You don't have any salary to evaluate");
        }
        if(salary<500) {
            Assert.fail("Your salary is below minimum");
        }
        System.out.println("Welcome!");
    }



    @After
    public void AfterTest() throws InterruptedException {
        sleep(2000);
        driver.quit();
    }





}
