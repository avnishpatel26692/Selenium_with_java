package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTextBox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> languageCheckboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> genderRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement howDoULikeUsDropDown;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTxtBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public void setName(String name) { nameTextBox.clear();nameTextBox.sendKeys(name); }
    public String getName(){
        return nameTextBox.getText();
    }

    public void setAge(String age) { ageTextBox.clear();ageTextBox.sendKeys(age);}
    public String getAge(){
        return ageTextBox.getText();
    }

    public void setLanguageCheckboxes(int index) {languageCheckboxes.get(index).click();}
    public boolean getLanguageCheckboxes(int index)
    { return languageCheckboxes.get(index).isSelected(); }

    public void setGenderRadioBtn(int index) {genderRadioBtn.get(index).click();}
    public boolean getRadioBtn(int index)
    { return genderRadioBtn.get(index).isSelected(); }

    public void setDropDown(String option) { Select dropdown = new Select(howDoULikeUsDropDown);
        dropdown.selectByVisibleText(option); }
    public String getDropDown() { Select dropdown = new Select(howDoULikeUsDropDown);
        return dropdown.getFirstSelectedOption().getText(); }

    public void setCommentTxtBox(String comment){commentTxtBox.sendKeys(comment);}
    public String getCommentTxtBox(){return commentTxtBox.getText();}

    public void clickOnSubmitBtn()
    { sendBtn.click();}

    public WebElement getSendBtn(){
        return sendBtn;
    }


}
