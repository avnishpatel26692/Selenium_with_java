package selenium.sample.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePagePO {
    @FindBy(how = How.NAME, using = "name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTextBox;

    @FindBy (how = How.XPATH, using = "//button[text()='Submit']")
    private WebElement submitButton;

    @FindBy (how = How.CSS, using = "p.error")
    private WebElement errorMessage;

    public void enterName(String name){
        nameTextBox.clear();
        nameTextBox.sendKeys(name);
    }
    public void enterAge (String age){
        ageTextBox.sendKeys(age);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
