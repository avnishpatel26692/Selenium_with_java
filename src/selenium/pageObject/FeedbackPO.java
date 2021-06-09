package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedbackPO {

    @FindBy(how = How.XPATH, using = "//span[@id='name']")
    private WebElement nameLabel;

    @FindBy(how = How.XPATH, using = "//span[@id='age']")
    private WebElement ageLabel;

    @FindBy(how = How.XPATH, using = "//span[@id='language']")
    private WebElement languageLabel;

    @FindBy(how = How.XPATH, using = "//span[@id='gender']")
    private WebElement genderLabel;

    @FindBy(how = How.XPATH, using = "//span[@id='option']")
    private WebElement optionLabel;

    @FindBy(how = How.XPATH, using = "//span[@id='comment']")
    private WebElement commentLabel;

    @FindBy(how = How.CLASS_NAME, using = "w3-green") //w3-btn w3-green w3-xlarge
    private WebElement yesButton;

    @FindBy(how = How.CLASS_NAME, using = "w3-red")
    private WebElement noButton;

    public String getName() {
        //return nameLabel.getAttribute("text");
        return nameLabel.getText();
    }

    public String getAge() {
        return ageLabel.getText();
    }

    public String getLanguage() {
        return languageLabel.getText();
    }

    public String getGender() {
        return genderLabel.getText();
    }

    public String getOption() {
        return optionLabel.getText();
    }

    public String getComment() {
        return commentLabel.getText();
    }

    public String getYesButtonBGColor() {
        return yesButton.getCssValue("background-color");
    }

    public String getYesButtonTextColor() {
        return yesButton.getCssValue("color");
    }

    public String getNoButtonBGColor() {
        return noButton.getCssValue("background-color");
    }

    public String getNoButtonTextColor() {
        return noButton.getCssValue("color");
    }

}
