package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;


    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }


    @Test
    public void findXpath(){
        WebElement element1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element1.getText());
    }

    @Test
    public void findXPath2(){
        WebElement element2 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(element2.getText());
    }

    @Test
    public void findXPath3 (){
        WebElement element2a = driver.findElement(By.xpath("//p[@class='Test']")); // fill the path
        System.out.print(element2a.getText());
    }


    @Test
    public void findCSSSelectorByName(){
        WebElement element3 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(element3.getText());
    }


    @Test
    public void findCSSSelectorByName2(){
        WebElement element4 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(element4.getText());
    }

    @Test
    public void findCSSSelectorByName3() {
        WebElement element5 = driver.findElement(By.cssSelector("")); // fill the css path
        System.out.print(element5.getText());
    }


}
