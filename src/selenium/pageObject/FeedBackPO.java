package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {


    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement Name;

    @FindBy(how = How.ID, using = "age")
    private WebElement Age;

    @FindBy(how = How.ID, using = "language")
    private WebElement Language;

    @FindBy(how = How.ID, using = "gender")
    private WebElement Gender;

    @FindBy(how = How.ID, using = "option")
    private WebElement Option;

    @FindBy(how = How.ID, using = "comment")
    private WebElement Comment;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
    private WebElement yesButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'No')]")
    private WebElement noButton;

    public String getName() {
        return Name.getText();
    }

    public String getAge() {
        return Age.getText();

    }

    public String getLanguage() {
        return Language.getText();

    }

    public String getGenre() {
        return Gender.getText();

    }

    public String getOption() {
        return Option.getText();

    }

    public String getComment() {
        return Comment.getText();

    }

    public WebElement sendYesButton() {
        return yesButton;
    }

    public WebElement sendNoButton() {
        return noButton;
    }


}
