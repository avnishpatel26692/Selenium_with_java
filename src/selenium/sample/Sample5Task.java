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

public class Sample5Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver web;

    @Before
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        web = new ChromeDriver();
        web.get("https://kristinek.github.io/site/examples/alerts_popups");
        web.manage().window().maximize();
    }

    @Test
    public void alertMethod(){
        WebElement element1 = web.findElement(By.className("w3-red"));
        element1.click();
        Alert alert = web.switchTo().alert();
        String e = "I am an alert box!";
        Assert.assertEquals(e,alert.getText());
        alert.dismiss();
    }

    @Test
    public void alertConformOrDenyMethod(){
        WebElement element1 = web.findElement(By.className("w3-teal"));
        element1.click();
        Alert alert = web.switchTo().alert();
        String e = "Press a button!";
        Assert.assertEquals(e,alert.getText());
        alert.accept();
        WebElement element2 = web.findElement(By.id("textForAlerts"));
        Assert.assertTrue(element2.isDisplayed());
        e = "Why on earth have you agreed to it?!";
        Assert.assertEquals(e,element2.getText());
        element1.click();
        alert = web.switchTo().alert();
        e = "Press a button!";
        Assert.assertEquals(e,alert.getText());
        alert.dismiss();
        Assert.assertTrue(element2.isDisplayed());
        e = "You have dared to deny me!!!";
        Assert.assertEquals(e,element2.getText());
    }

    @Test
    public void alertEnterNumberMethod(){
        WebElement element1 = web.findElement(By.className("w3-khaki"));
        element1.click();
        Alert alert = web.switchTo().alert();
        String e = "Please enter a number";
        Assert.assertEquals(e,alert.getText());
        alert.sendKeys("1");
        alert.accept();
        WebElement element2 = web.findElement(By.id("textForAlerts"));
        Assert.assertTrue(element2.isDisplayed());
        e = "Wrong! It is";
        Assert.assertTrue(element2.getText().contains(e));
    }

    @Test
    public void alertRedirectMethod(){
        WebElement element1 = web.findElement(By.className("w3-blue"));
        element1.click();
        Alert alert = web.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals("https://kristinek.github.io/site/examples/alerts_popups",web.getCurrentUrl());
        element1.click();
        alert = web.switchTo().alert();
        alert.accept();
        alert = web.switchTo().alert();
        String e = "Booooooooo!";
        Assert.assertEquals(e,alert.getText());
        alert.dismiss();
        Assert.assertEquals("https://kristinek.github.io/site/examples/alerted_page",web.getCurrentUrl());
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
