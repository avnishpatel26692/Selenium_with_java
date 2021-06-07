package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        WebDriver driver = new ChromeDriver();

//         To open url
        driver.get("https://kristinek.github.io/site/");

//       To print the title of the page in the test result
        System.out.println(driver.getTitle());

//       To print the current url of the opened page
        System.out.println(driver.getCurrentUrl());

//       Sets seconds how long the browsers is opened. Here = 5 sec
        Thread.sleep(5000);

//       To close the browser "close" closes the recent one opened on the desk. "Quit" = closes all opened browsers.
        driver.close();

    }

}
