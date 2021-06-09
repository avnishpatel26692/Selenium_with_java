package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {

    @FindBy(how = How.CSS, using="span#name")
    private WebElement name;

    @FindBy(how = How.ID, using = "age")
    private WebElement age;

    @FindBy(how = How.ID, using = "language")
    private WebElement lang;

    @FindBy(how = How.ID, using = "gender")
    private WebElement gen;

    @FindBy(how = How.ID, using = "option")
    private WebElement option;

    @FindBy(how = How.ID, using = "comment")
    private WebElement comment;

    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement ybutton;

    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement nbutton;

    public String getName() {
        return name.getText();
    }
    public String getAge() {
        return age.getText();

    }
    public String getLang() {
        return lang.getText();

    }

    public String getGen() {
        return gen.getText();

    }

    public String getOption() {
        return option.getText();

    }
    public String getComment() {
        return comment.getText();

    }
    public WebElement sendYbutton() {
        return ybutton;
    }

    public WebElement sendNbutton() {
        return nbutton;
    }



}