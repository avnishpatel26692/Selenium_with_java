package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {

    @FindBy(how = How.CSS, using = "span#name")
    private WebElement name2Textbox;

    @FindBy(how = How.ID, using = "age")
    private WebElement age2Textbox;

    @FindBy(how = How.ID, using = "language")
    private WebElement lang2Textbox;

    @FindBy(how = How.ID, using = "gender")
    private WebElement gender2Textbox;

    @FindBy(how = How.ID, using = "option")
    private WebElement option2Textbox;

    @FindBy(how = How.ID, using = "comment")
    private WebElement comment2Textbox;

    @FindBy(how = How.CSS, using = ".w3-green")
    private WebElement yesButton;

    @FindBy(how = How.CSS, using = ".w3-red")
    private WebElement noButton;


    public String getNameValue()
    {
        return name2Textbox.getText();
    }

    public String getAgeValue()
    {
        return age2Textbox.getText();
    }

    public String get2LangValue()
    {
        return lang2Textbox.getText();
    }

    public String getGenderValue()
    {
        return gender2Textbox.getText();
    }

    public String getOptionValue()
    {
        return option2Textbox.getText();
    }

    public String getComment()
    {
        return comment2Textbox.getText();
    }

    public WebElement yesButton()
    {
        return yesButton;
    }

    public WebElement noButton()
    {
        return noButton;
    }

}
