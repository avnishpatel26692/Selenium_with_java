package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.xml.stream.events.Comment;
import java.util.List;

public class GiveFeedBackPO {
    @FindBy(how = How.NAME, using = "name" )
    private WebElement nameTextbox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> RadioButtons;

    @FindBy(how = How.CLASS_NAME, using = "w3-select")
    private List<WebElement> DropDowns;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement CommentTextField;

    @FindBy(how = How.CLASS_NAME, using = "w3-btn-block w3-blue w3-section")
    private WebElement SendBtn;


    public void enterName(String name) {
        nameTextbox.clear();
        nameTextbox.sendKeys(name);
    }
    public String getName() {
        return nameTextbox.getText();}

    public void enterAge(String age)
    {
        ageTextbox.sendKeys(age);
    }
    public String getAge(){
        return ageTextbox.getText();
    }

    public void Checkbox(int index){
        checkboxes.get(index).click();

    }

    public boolean getCheckboxes(int index) {
        return checkboxes.get(index).isSelected();
    }
    public void RadioButtons (int index) {
        RadioButtons.get(index).click();
    }
    public boolean getRadioButtons (int index) {
        return RadioButtons.get(index).isSelected();
    }
    public void DropDowns (int index) {
        DropDowns.get(index).click();
    }
    public boolean getDropDowns (int index) {
        return DropDowns.get(index).isSelected();
    }
        public void CommentTextField(String Comment){
            CommentTextField.sendKeys(Comment);
        }
        public void clickOnSendBtn()
        {
            SendBtn.click();
        }
        public WebElement getSendBtn(){
        return SendBtn;
        }


}
