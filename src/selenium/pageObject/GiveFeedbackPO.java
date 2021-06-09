package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedbackPO {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTextBox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTextBox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio']")
    private List<WebElement> radioButtons;

    @FindBy(how = How.XPATH, using = "//select[@class='w3-select']")
    private WebElement dropDownList;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentBox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement button;

    public String getName() {
        return nameTextBox.getAttribute("value");
    }

    public void setName(String name) {
        nameTextBox.sendKeys(name);
    }

    public String getAge() {
        return ageTextBox.getAttribute("value");
    }

    public void setAge(String age) {
        ageTextBox.sendKeys(age);
    }

    public boolean checkCheckboxChecked(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void checkCheckbox(int index) {
        checkboxes.get(index).click();
    }

    public boolean checkRadioButtonSelected(int index) {
        return radioButtons.get(index).isSelected();
    }

    public void selectRadioButton(int index) {
        radioButtons.get(index).click();
    }

    public String checkOptionSelected() {
        Select dropdown = new Select(dropDownList);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectOptionFromDropdown(int index) {
        Select dropdown = new Select(dropDownList);
        dropdown.selectByIndex(index);
    }

    public String getComment() {
        return commentBox.getAttribute("value");
    }

    public void setComment(String comment) {
        commentBox.sendKeys(comment);
    }

    public String getButtonBGColor() {
        return button.getCssValue("background-color");
    }

    public String getButtonTextColor() {
        return button.getCssValue("color");
    }

    public void clickSendButton() {
        button.click();
    }
}
