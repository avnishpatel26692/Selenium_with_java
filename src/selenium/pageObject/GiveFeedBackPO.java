package selenium.pageObject;

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
    private List<WebElement> languageCheckBoxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> genderRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUsDrop;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public String getName(){
        return nameTextBox.getText();
    }
    public void setName(String name){
        nameTextBox.sendKeys(name);
    }
    public String getAge(){
        return ageTextBox.getText();
    }
    public void setAge(String age){
        ageTextBox.sendKeys(age);
    }
    public boolean getLanguageCheckBoxStatus(int index){
        return languageCheckBoxes.get(index).isSelected();
    }
    public void selectCheckbox(int index){
        languageCheckBoxes.get(index).click();
    }
    public boolean getRadioBtnStatus(int index){
        return genderRadioBtn.get(index).isSelected();
    }
    public void selectRadioBtn(int index) {
        genderRadioBtn.get(index).click();
    }
    public String getSelectedDropDownOption()
    {
        Select dropdown = new Select(likeUsDrop);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectDropdownOption(String option)
    {
        Select dropdown = new Select(likeUsDrop);
        dropdown.selectByVisibleText(option);
    }

    public String getComment()
    {
        return commentTextbox.getText();
    }

    public void setComment(String comment)
    {
        commentTextbox.sendKeys(comment);
    }

    public WebElement sendBtn()
    {
        return sendBtn;
    }

    }


