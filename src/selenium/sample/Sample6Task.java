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
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().window().maximize();
    }

    @Test
    public void findXpath()
    {
        WebElement element = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(element.getText());

        //2nd example
        WebElement element1 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(element1.getText());
        //*[@id="dummy"]
        //html/body/div[3]/p[3]
    }

    @Test
    public void findCSSSelector()
    {
        WebElement element2 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(element2.getText());

        //2nd example
        WebElement element3 = driver.findElement(By.cssSelector("div#test1> .test"));
        System.out.println(element3.getText());

        WebElement element4 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(element4.getText());}


    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }


}
