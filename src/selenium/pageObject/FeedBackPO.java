package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameResult;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageResult;

    @FindBy(how = How.ID, using = "language")
    private WebElement languageResult;

    @FindBy(how = How.ID, using = "gender")
    private WebElement genderResult;

    @FindBy(how = How.ID, using = "option")
    private WebElement optionResult;

    @FindBy(how = How.ID, using = "comment")
    private WebElement commentResult;

    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement bthYes;

    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement btnYes;

    @FindBy(how = How.CLASS_NAME, using = "w3-red")
    private WebElement btnNo;


    public String getName() {
        return nameResult.getText();

    }

    public String getAge() {
        return ageResult.getText();

    }

    public String getLanguage() {
        return languageResult.getText();
    }

    public String getRadioBtnStatus() {
        return genderResult.getText();

    }

    public String getSelectedDropDownOption() {
        return optionResult.getText();

    }

    public String getOption() {
        return optionResult.getText();
    }

    public String getComment() {
        return commentResult.getText();

    }

    public WebElement btnYes() {
        return btnYes;
    }

    public WebElement btnNo() {
        return btnNo;
    }

    public void clickOnNo() {
        btnNo.click();
    }


    public void clickOnYes() {
        btnYes.click();
    }

}


