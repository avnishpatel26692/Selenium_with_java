package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTask5 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
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
    public void Popupmsg1 ()
{
WebElement redbutt = driver.findElement(By.className("w3-red"));
redbutt.click();
Alert alert = driver.switchTo().alert();
String alertmsg =alert.getText();
String Expected = "I am an alert box!";
Assert.assertEquals(Expected,alertmsg);
alert.accept();
}
 @Test
    public void Popupmsg2()
 {
     WebElement popup1 = driver.findElement(By.className("w3-teal"));
     popup1.click();
     Alert popupwindow = driver.switchTo().alert();
     String popupmsg = popupwindow.getText();
     popupwindow.dismiss();
     Assert.assertTrue(popupmsg.contains("Press "));
     WebElement a3 = driver.findElement(By.id("textForAlerts"));
     String expected = "You have dared to deny me!!!";
     Assert.assertEquals(expected,a3.getText());



 }

    @Test
    public void PopupEnter ()
    {
        WebElement button = driver.findElement(By.className("w3-khaki"));
        button.click();
        String n = "12";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(n);
        alert.accept();
        WebElement a2 = driver.findElement(By.id("textForAlerts"));
        String Expected = "Wrong";
        Assert.assertTrue(a2.getText().contains(Expected));


    }

    @Test
    public void LastPopUp(){
        WebElement n1 = driver.findElement(By.className("w3-blue"));
        n1.click();
        Alert alert = driver.switchTo().alert();
        String ex = alert.getText();
        alert.accept();
        String expected = ex;
        Assert.assertEquals(ex,"Want to see an alerted page?!");
        Alert alert2 = driver.switchTo().alert();
        String ex1 = alert2.getText();
        String Expected1 = "Booooooooo!";
        Assert.assertEquals(Expected1,ex1);


    }


}