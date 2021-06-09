package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedbackResultPO {

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "age")
    private WebElement age;

    @FindBy(how = How.ID, using = "language")
    private WebElement language;

    @FindBy(how = How.ID, using = "gender")
    private WebElement gender;

    @FindBy(how = How.ID, using = "option")
    private WebElement option;

    @FindBy(how = How.ID, using = "comment")
    private WebElement comment;

    @FindBy(how = How.CSS, using = ".w3-green")
    private WebElement yesButton;

    @FindBy(how = How.CSS, using = ".w3-red")
    private WebElement noButton;

    @FindBy(how = How.ID, using = "message")
    private WebElement thankYouForFeedbackMessage;


    public void clickOnYesButton() {
        yesButton.click();
    }

    public void clickOnNoButton() {
        noButton.click();
    }

    public String getName() {
        return name.getText();
    }

    public String getAge() {
        return age.getText();
    }

    public String getLanguage() {
        return language.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getOption() {
        return option.getText();
    }

    public String getComment() {
        return comment.getText();
    }

    public WebElement getYesButton() {
        return yesButton;
    }

    public WebElement getNoButton() {
        return noButton;
    }

    public String getThankYouForFeedbackMessage() {
        return thankYouForFeedbackMessage.getText();
    }
}
