package selenium.sample.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {

    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement yourName;

    @FindBy(how = How.ID, using = "age")
    private WebElement yourAge;

    @FindBy(how = How.ID, using = "language")
    private WebElement yourLanguage;

    @FindBy(how = How.ID, using = "gender")
    private WebElement yourGender;

    @FindBy(how = How.ID, using = "option")
    private WebElement yourOption;

    @FindBy(how = How.ID, using = "comment")
    private WebElement yourComment;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
    private WebElement yesButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'No')]")
    private WebElement noButton;

    public String getYourName() {
        return yourName.getText();
    }
    public String getYourAge() {
        return yourAge.getText();

    }
    public String getYourLanguage() {
        return yourLanguage.getText();

    }

    public String getYourGenre() {
        return yourGender.getText();

    }

    public String getYourOption() {
        return yourOption.getText();

    }
    public String getYourComment() {
        return yourComment.getText();

    }
    public WebElement sendYesButton() {
        return yesButton;
    }

    public WebElement sendNoButton() {
        return noButton;
    }



}
