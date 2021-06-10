package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sample9_differentBrowsers {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver_91.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        //driver = new FirefoxDriver();

        //Internet explorer
        //System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        //driver = new InternetExplorerDriver();

        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().window().maximize();
    }

    @After
    public void afterMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
