package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement backBtn;

    public String getMessage()
    {
        return message.getText();
    }

    public void clickOnBack()
    {
        backBtn.click();
    }



}
