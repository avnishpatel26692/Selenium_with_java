package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



public class MyTask8 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void Checkbox(){
        List<WebElement> Checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement option : Checkbox){
            Assert.assertFalse(option.isSelected());
            option.click();
            Assert.assertTrue(option.isSelected());
            option.click();

        }
        Assert.assertFalse(Checkbox.get(2).isSelected());
        Checkbox.get(2).click();
        Assert.assertTrue(Checkbox.get(2).isSelected());



    }
    @Test
    public void Radiobox() throws InterruptedException {
        List<WebElement> Radiobox = driver.findElements(By.xpath("//input[@type='radio']"));
        for(WebElement option : Radiobox)
        {
            Assert.assertFalse(option.isSelected());
            option.click();
            Thread.sleep(2000);
            Assert.assertTrue(option.isSelected());

        }
        Assert.assertFalse(Radiobox.get(1).isSelected());
        Radiobox.get(1).click();
        WebElement option2 = driver.findElement(By.cssSelector("input#vfb-7-2"));
        Assert.assertTrue(option2.isSelected());
//


    }
    @Test
    public void Calendar() throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());

        WebElement x1 = driver.findElement(By.xpath("//input[@id='vfb-8']"));
        x1.click();
        WebElement x2 = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
        for (int i = 0;i<10;i++)
        {
            Thread.sleep(500);
            WebElement prevBut = driver.findElement(By.cssSelector("a.ui-datepicker-prev"));
            prevBut.click();
        }
        WebElement Datefifteen = driver.findElement(By.xpath("//a[text()='15']"));
        Datefifteen.click();
        WebElement Resultbut = driver.findElement(By.cssSelector("#result_button_date"));
        Resultbut.click();
        WebElement Resultdate = driver.findElement(By.cssSelector("#result_date"));
        String expected = "You entered date: 08/15/2020";
        Assert.assertEquals(expected,Resultdate.getText());





    }


    @Test
    public void Calendar1() throws InterruptedException {
        WebElement field = driver.findElement(By.cssSelector("input#vfb-8"));
        field.clear();
        field.sendKeys("12/15/2014");
        WebElement Resultbut = driver.findElement(By.cssSelector("#result_button_date"));
        Resultbut.click();
        WebElement Resultdate = driver.findElement(By.cssSelector("#result_date"));
        String expected = "You entered date: 08/15/2020";
        Assert.assertEquals(expected, Resultdate.getText());
    }







}

