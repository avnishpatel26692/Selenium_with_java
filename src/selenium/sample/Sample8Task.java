package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample8Task {

        static String libWithDriversLocation = System.getProperty("user.dir") + "//lib//";
        WebDriver driver;

        @Before
        public void beforeMethod() {
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
            driver = new ChromeDriver();
            driver.get("https://kristinek.github.io/site/tasks/locators_different");
            driver.manage().window().maximize();
        }

        @After
        public void afterMethod() throws InterruptedException {
            //Sleep for 2.5 seconds
            Thread.sleep(2500);
            //Close browser
            driver.quit();
        }

        //Task: Test needs to be cover:
//validate for paragraph 1,2,4,6 & 7
//Check Background color
//check font family
//check font size

        // Paragraph 1
        @Test
        public void Paragraph1() {
            WebElement Paragraph1Label = driver.findElement(By.xpath("//p[text()='paragraph 1']"));
            String actualBGColor = Paragraph1Label.getCssValue("background-color");
            Assert.assertEquals("rgba(0, 0, 0, 0)", actualBGColor);
            String actualFontFamily = Paragraph1Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
            String actualFontSize = Paragraph1Label.getCssValue("font-size");
            Assert.assertEquals("15px", actualFontSize);
        }

        // Paragraph 2
        @Test
        public void Paragraph2() {
            WebElement luckyParagraph2Label = driver.findElement(By.xpath("//p[text()='paragraph 2']"));
            String actualValue = luckyParagraph2Label.getCssValue("background-color");
            Assert.assertEquals("rgba(76, 175, 80, 1)", actualValue);
            String actualFontFamily = luckyParagraph2Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
            String actualFontSize = luckyParagraph2Label.getCssValue("font-size");
            Assert.assertEquals("15px", actualFontSize);
        }

        //  Paragraph 4
        @Test
        public void Paragraph4() {
            WebElement luckyParagraph4Label = driver.findElement(By.xpath("//p[text()='crazy paragraph 4']"));
            String actualValue = luckyParagraph4Label.getCssValue("background-color");
            Assert.assertEquals("rgba(103, 58, 183, 1)", actualValue);
            String actualFontFamily = luckyParagraph4Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
            String actualFontSize = luckyParagraph4Label.getCssValue("font-size");
            Assert.assertEquals("15px", actualFontSize);
        }

        //  Paragraph 6
        @Test
        public void Paragraph6BGColor() {
            WebElement coolParagraph6Label = driver.findElement(By.xpath("//p[text()='cool paragraph 6']"));
            String actualValue = coolParagraph6Label.getCssValue("background-color");
            Assert.assertEquals("rgba(33, 150, 243, 1)", actualValue);
            String actualFontFamily = coolParagraph6Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
            String actualFontSize = coolParagraph6Label.getCssValue("font-size");
            Assert.assertEquals("15px", actualFontSize);
        }

        //  Paragraph 7
        @Test
        public void Paragraph7BGColor() {
            WebElement luckyParagraph7Label = driver.findElement(By.xpath("//p[text()='lucky paragraph 7']"));
            String actualValue = luckyParagraph7Label.getCssValue("background-color");
            Assert.assertEquals("rgba(233, 30, 99, 1)", actualValue);
            String actualFontFamily = luckyParagraph7Label.getCssValue("font-family");
            Assert.assertEquals("Verdana, sans-serif", actualFontFamily);
            String actualFontSize = luckyParagraph7Label.getCssValue("font-size");
            Assert.assertEquals("15px", actualFontSize);
        }
}
