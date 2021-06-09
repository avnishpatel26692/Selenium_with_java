package selenium.sample.ActivityDayThree.ActivityDayThreePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {

    @FindBy(how = How.CSS, using = "span#name")
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

    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement yesbutton;

    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement nobutton;


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

    public WebElement getYesbutton() {
        return yesbutton;
    }


    public WebElement getNobutton() {
        return nobutton;
    }


}

