package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FeedBackPO {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameTextbox1;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTextbox1;

    @FindBy(how = How.ID, using = "language")
    private WebElement language;

    @FindBy(how = How.ID, using = "gender")
    private WebElement gender;

    @FindBy(how = How.ID, using = "option")
    private WebElement opinion;

    @FindBy(how = How.ID, using = "comment")
    private WebElement commentTextbox1;

    @FindBy(how = How.XPATH, using = "//button[contains(@onclick, 'openFeedback')]")
    private WebElement greenButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@onclick, 'history.back')]")
    private WebElement redButton;


    public String getName() {
        return nameTextbox1.getText();
    }

    public String getAge() {
        return ageTextbox1.getText();
    }

    public String getLanguage() {
        return language.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getOption() {
        return opinion.getText();
    }

    public String getComment() {
        return commentTextbox1.getText();
    }

    public WebElement getGreenButton() {
        return greenButton;
    }

    public WebElement getRedButton() {
        return redButton;
    }

}
