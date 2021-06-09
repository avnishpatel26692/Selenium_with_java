package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.text.html.Option;
import java.util.List;

public class FeedBackPO {
    @FindBy(how = How.ID, using = "name")
    private WebElement Name;
    @FindBy(how = How.ID, using = "age")
    private WebElement Age;
    @FindBy(how = How.ID, using = "language")
    private WebElement Language;
    @FindBy(how = How.ID, using = "gender")
    private WebElement Genre;
    @FindBy(how = How.ID, using = "option")
    private WebElement Option;
    @FindBy(how = How.ID, using = "comment")
    private WebElement Comment;

    @FindBy(how = How.XPATH, using = "//button[text()='Yes']")
    private WebElement YesBtn;
    @FindBy(how = How.XPATH, using = "//button[text()='No']")
    private WebElement NoBtn;
    public void enterName(String name)
    {
        Name.sendKeys(name);
    }
    public void enterComment(String name){
        Comment.sendKeys();
    }
    public String getName()
    {
        return Name.getText();
    }
    public void enterAge(String name)
    {
        Age.sendKeys(name);}

    public String getAge()
    {
        return Age.getText();
    }
    public String getLanguage()
    {
        return Language.getText();
    }
    public String getGenre()
    {
        return Genre.getText();
    }
    public String getOption()
    {
        return Option.getText();
    }

    public String getComment()
    {
        return Comment.getText();
    }
    public WebElement getYesBtn()
    {
        return YesBtn;
    }
    public WebElement getNoBtn(){
    return NoBtn;
    }}
//button[text()='No']