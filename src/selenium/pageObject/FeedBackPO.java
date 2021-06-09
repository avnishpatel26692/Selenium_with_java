package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPO {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameLine;
    @FindBy(how = How.ID, using = "age")
    private WebElement ageLine;
    @FindBy(how = How.ID, using = "language")
    private WebElement languageLine;
    @FindBy(how = How.ID, using = "gender")
    private WebElement genderLine;
    @FindBy(how = How.ID, using = "option")
    private WebElement likeUsLine;
    @FindBy(how = How.ID, using = "comment")
    private WebElement commentLine;
    @FindBy(how = How.XPATH, using = "//button[text()='Yes']")
    private WebElement yesBtn;
    @FindBy(how = How.XPATH, using = "//button[text()='No']")
    private WebElement noBtn;

    public String checkName(){
        return nameLine.getText();
    }
    public String checkAge() {
        return ageLine.getText();
    }
    public String checkLanguage(){
        return languageLine.getText();
    }
    public String checkGender(){
        return genderLine.getText();
    }
    public String checkLikeUsLine(){
        return likeUsLine.getText();
    }
    public String checkComment(){
        return commentLine.getText();
    }
    public WebElement yesButton(){
        return yesBtn;
    }
    public void clickYesBtn(){
        yesBtn.click();
    }
    public WebElement noButton() {
        return noBtn;
    }
    public void clickNoBtn(){
        noBtn.click();
    }



}
