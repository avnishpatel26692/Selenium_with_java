package selenium.sample.ActivityDayThree.ActivityDayThreePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTextbox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']" )
    private List<WebElement> languageCheckboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> genderRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement commentDropDown;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public String getName()
    {
        return nameTextbox.getText();
    }

    public void setName(String name)
    {
        nameTextbox.sendKeys(name);
    }

    public String getAge()
    {
        return ageTextbox.getText();
    }

    public void setAge(String age)
    {
        ageTextbox.sendKeys(age);
    }

    public boolean getLanguageCheckbox(int index)
    {
        return languageCheckboxes.get(index).isSelected();
    }

    public void selectLanguageCheckbox(int index)
    {
        languageCheckboxes.get(index).click();
    }

    public boolean getRadioBtnStatus(int index)
    {
        return genderRadioBtn.get(index).isSelected();
    }

    public void selectRadioBtn(int index)
    {
        genderRadioBtn.get(index).click();
    }

    public String getSelectedDropDownOption()
    {
        Select dropdown = new Select(commentDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectDropdownOption(String option)
    {
        Select dropdown = new Select(commentDropDown);
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

    public void clickSendBtn(){
            sendBtn.click();
                    }

    public WebElement sendBtn()
    {
        return sendBtn;
    }


}