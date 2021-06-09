package selenium.sample.pageObject;

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
    private WebElement howDoYouLikeUsDropDown;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public String getName()
    {
        return nameTextbox.getText();
    }

    public String setName(String name)
    {
        nameTextbox.sendKeys(name);
        return name;
    }

    public String getAge()
    {
        return ageTextbox.getText();
    }

    public String setAge(String age)
    {
        ageTextbox.sendKeys(age);
        return age;
    }

    public boolean getLanguageCheckBoxStatus(int index)
    {
        return languageCheckboxes.get(index).isSelected();
    }

    public void selectCheckbox(int index)
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
        Select dropdown = new Select(howDoYouLikeUsDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectDropdownOption(String option)
    {
        Select dropdown = new Select(howDoYouLikeUsDropDown);
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