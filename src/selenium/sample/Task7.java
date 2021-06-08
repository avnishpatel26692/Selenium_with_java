package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



    public class Task7 {

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
        public void Byxpath(){
            WebElement el1 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
            System.out.println(el1.getText());


        }
        @Test
        public void ByCss(){
            WebElement el1 = driver.findElement(By.cssSelector("p.text#dummy"));
            System.out.println(el1.getText());


        }
        @Test
        public void ByCss1(){
            WebElement el1 = driver.findElement(By.cssSelector("input#buttonID"));
            System.out.println(el1.getAttribute("value"));


        }
        @Test
        public void Byxpath1(){
            WebElement el1 = driver.findElement(By.xpath("div[@id='test1']/p[2]"));
            System.out.println(el1.getText());


        }
        @Test
        public void Byxpathtext(){
            WebElement el1 = driver.findElement(By.xpath("//p[text()='unbelievable sample text']"));
            System.out.println(el1.getText());

        }

        @Test
        public void ByxpathContainstext(){
            WebElement el1 = driver.findElement(By.xpath("//p[contains(text(),'Test Text 4')]"));
            System.out.println(el1.getText());

        }





    }

