package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {
    @FindBy(how = How.ID, using = "message")
    private WebElement msg;

    @FindBy(how = How.XPATH, using="//button[@type='button']")
    private WebElement button;

    public String msg(){
        return msg.getText();
    }

    public void back(){
        button.click();
    }
}
