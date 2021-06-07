package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Test {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {

        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");

//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        // by element id
        System.out.println("Find element by ID:");
        System.out.println("heading_1: "+driver.findElement(By.id("heading_1")).getText());
        System.out.println();

        // by name
        System.out.println("Find element by name:");
        //System.out.println(driver.findElement(By.name("randomButton1")).getText());
        System.out.println("randomButton2: "+driver.findElement(By.name("randomButton2")).getAttribute("value"));
        System.out.println();

        // by class
        System.out.println("Find element by class:");
        System.out.println("unbelievable: "+driver.findElement(By.className("unbelievable")).getText());
        System.out.println();

        //By Tagname
        List<WebElement> pTag = driver.findElements(By.tagName("p"));
        System.out.println("Number of P tags found: "+ pTag.size());
        System.out.println();
        System.out.println("Find element by p tag:");
        //1st element
        for (int i = 0;i< pTag.size();i++) {
            System.out.println((i+1)+". "+pTag.get(i).getText());
        }
        Thread.sleep(2000);
        driver.quit();
    }
}

