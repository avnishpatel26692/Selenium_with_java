package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");







        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.id("buttonId")).getAttribute("name"));
        System.out.println(driver.findElement(By.className("text")).getText());

        WebElement heading1 = driver.findElement(By.id("heading_1"));
        heading1.getText();

        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println(pTag.size()); // How much <P> tags in whole page
        System.out.println(pTag.get(1).getText());



        Thread.sleep(5000);

        driver.quit();
    }
}
