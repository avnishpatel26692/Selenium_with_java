package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePO {

    @FindBy(how = How.NAME, using = "name")
    private WebElement homePageLabel;

    public void clickOnHomePageLabel() {
        homePageLabel.click();
    }

}
