package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPO {
    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private WebElement backbutton;

    public String getMessage() {
      return   message.getText();
    }

    public void ClickOnBckButt() {
        backbutton.click();
    }



}
