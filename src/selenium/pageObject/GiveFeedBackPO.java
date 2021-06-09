package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {

    @FindBy(how = How.ID, using = "fb_name" )
    private WebElement nameTextbox;

    @FindBy(how = How.ID, using = "fb_age" )
    private WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']" )
    private List<WebElement> checkboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']" )
    private List<WebElement> radio;

    @FindBy(how = How.ID, using = "like_us" )
    private WebElement opinion;

    @FindBy(how = How.NAME, using = "comment" )
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_form']/form/button" )
    private WebElement sendButton;

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

    public boolean getLanguageCheckBoxStatus(int index)
    {
        return checkboxes.get(index).isSelected();
    }

    public void selectCheckbox(int index)
    {
        checkboxes.get(index).click();
    }

    public boolean getRadioBtnStatus(int index)
    {
        return radio.get(index).isSelected();
    }

    public void selectRadioBtn(int index)
    {
        radio.get(index).click();
    }

    public String getSelectedOption()
    {
        Select dropdown = new Select(opinion);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectOption(String option)
    {
        Select dropdown = new Select(opinion);
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

    public WebElement sendButton()
    {
        return sendButton;
    }

}