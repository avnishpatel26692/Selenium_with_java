package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GetFeedback extends FeedbackFinal{

//    @FindBy(how = How.XPATH, using="//h2")
//    private String header;

    @FindBy(how = How.CSS, using="span#name")
    private WebElement name;

    @FindBy(how = How.CSS, using="span#age")
    private WebElement age;

    @FindBy(how = How.CSS, using="span#language")
    private WebElement language;

    @FindBy(how = How.CSS, using="span#gender")
    private WebElement gender;

    @FindBy(how = How.CSS, using="span#option")
    private WebElement option;

    @FindBy(how = How.CSS, using="span#comment")
    private WebElement comment;

    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement YesButton;
    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement Nobutton;

    public String getName(){
        return name.getText();

    }
    public String getAge(){
        return age.getText();
    }
    public String getLanguage(){
        return language.getText();
    }
    public String getGender(){
        return gender.getText();
    }
    public String getOption(){
        return option.getText();
    }
    public String getComment(){
        return comment.getText();
    }
    public WebElement Yesbutton(){
        return getFeedback.YesButton;
    }
    public WebElement Nobutton(){
        return getFeedback.Nobutton;
    }
}
