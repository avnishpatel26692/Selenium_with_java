package selenium.pageObject;

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

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> Checkboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> RadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement DropDown;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public String getName() {
        return nameTextbox.getText();
    }

    public void setName(String name) {
        nameTextbox.sendKeys(name);
    }

    public String getAge() {
        return ageTextbox.getText();
    }

    public void setAge(String age) {
        ageTextbox.sendKeys(age);
    }

    public boolean getCheckBoxStatus(int index) {
        return Checkboxes.get(index).isSelected();
    }

    public void selectCheckbox(int index) {
        Checkboxes.get(index).click();
    }

    public boolean getRadioBtnStatus(int index) {
        return RadioBtn.get(index).isSelected();
    }

    public void selectRadioBtn(int index) {
        RadioBtn.get(index).click();
    }

    public String getSelectedDropDownOption() {
        Select dropdown = new Select(DropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectDropdownOption(String option) {
        Select dropdown = new Select(DropDown);
        dropdown.selectByVisibleText(option);
    }

    public String getComment() {
        return commentTextbox.getText();
    }

    public void setComment(String comment) {
        commentTextbox.sendKeys(comment);
    }

    public WebElement sendBtn() {
        return sendBtn;
    }

    public void cliclOnSendBtn() {
        sendBtn.click();
    }

}