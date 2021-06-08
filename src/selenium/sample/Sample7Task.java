package selenium.sample;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



public class Sample7Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        //Sleep for 2.5 seconds
        Thread.sleep(2500);
        //Close browser
        driver.quit();
    }

    @Test
    public void clickOnCheckbox() throws InterruptedException {


        WebElement checkbox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        checkbox2.click();
        Thread.sleep(2000);
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());

        WebElement checkBox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));
        checkBox3.click();
        Assert.assertTrue(checkBox3.isSelected());
        Thread.sleep(2000);
        checkBox3.click();
        Assert.assertFalse(checkBox3.isSelected());
    }




    @Test
    public void selectDate2() throws InterruptedException {
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, 10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());  // 08/15/2020


        WebElement datePickerTxtBox = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        datePickerTxtBox.click();
        for(int i =0 ; i<10; i++)
        {
            Thread.sleep(500);
            //WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            WebElement nextMonthBtn = driver.findElement(By.xpath("//span[text()='Next']"));  // 10 months ahead
            nextMonthBtn.click();
        }
        WebElement date15 = driver.findElement(By.xpath("//a[text()='15']"));
        date15.click();
        String actualResults = datePickerTxtBox.getAttribute("value");
        Assert.assertEquals(result,actualResults);

    }


}
