package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavBarPO {
    @FindBy(how= How.XPATH,using="//a[@href='/site/']")
    private WebElement homeButton;

    public void Home(){
        homeButton.click();
    }
}
