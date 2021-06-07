package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
        //driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/");

        //get title and url from a page that is being tested
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //set time how long the tested page will be open
        Thread.sleep(4000);

        //to close the browser
        // .close closes 1 browser, .quit closes all browsers
        driver.close();
        driver.quit();
    }
}
