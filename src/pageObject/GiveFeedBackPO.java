package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTextbox;

    @FindBy(how = How.CSS, using = "#fb_age")
    private WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> languageCheckBoxes;

    @FindBy(how = How.CSS, using = ".w3-radio") //select gender elements
    private List<WebElement> genderRadioButtons;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement optionList;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendButton;



    public String getNameValue()
    {
        return nameTextbox.getText();
    }
    public void setNameValue(String name)
    {
        nameTextbox.sendKeys(name);
    }

    public String getAgeValue()
    {
        return ageTextbox.getText();
    }

    public void setAgeValue(String age)
    {
        ageTextbox.sendKeys(age);
    }


    public void selectRadioBtn(int index)
    {
        genderRadioButtons.get(index).click();
    }


    public void selectCheckbox(int index)
    {
        languageCheckBoxes.get(index).click();
    }


    public boolean IsCheckbox()
    {
        boolean result = false;
        for(WebElement elementName : languageCheckBoxes) {
            if(elementName.isSelected()){
                result = true;
            }
        }
        return result;
    }

    public boolean isRadioSelected(int index)
    {
        return genderRadioButtons.get(index).isSelected();
    }

    public void selectRadioButton(int index)
    {
        genderRadioButtons.get(index).click();
    }

    public boolean isCheckBoxSelected(int index){
        return languageCheckBoxes.get(index).isSelected();
    }


    public String getSelectedOption()
    {
        Select dropdownList = new Select((WebElement) optionList);
        return dropdownList.getFirstSelectedOption().getText();
    }

    public void selectOption(String option)
    {
        Select dropdownList = new Select(optionList);
        dropdownList.selectByVisibleText(option);
    }


    public String getComment()
    {
        return commentTextbox.getText();
    }

    public void setComment(String comment)
    {
        commentTextbox.sendKeys(comment);
    }

    public WebElement sendButton()
    {
        return sendButton;
    }


}
