package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/locators");

        System.out.println(driver.findElement(By.id("heading_1")).getText());

        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value"));

        for(WebElement e : driver.findElements(By.className("text"))){
            System.out.println(e.getText());
        }

        Thread.sleep(5000); //Wait 5 seconds

        driver.close();
    }
}
