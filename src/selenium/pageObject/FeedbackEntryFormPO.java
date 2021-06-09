package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FeedbackEntryFormPO {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameTxtBox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> languageCheckboxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> genreRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement dropdownBox;

    @FindBy(how = How.XPATH, using = "//textarea[@name='comment']")
    private WebElement commentArea;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement sendBtn;

    public String getNameTxtBox() {
        return nameTxtBox.getText();
    }

    public String getAgeTxtBox() {
        return ageTxtBox.getText();
    }

    public List<WebElement> getLanguageCheckboxes() {
        return languageCheckboxes;
    }

    public WebElement getCommentArea() {
        return commentArea;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public void enterName(String name) {
        nameTxtBox.clear();
        nameTxtBox.sendKeys(name);
    }

    public void enterAge(String age) {
        ageTxtBox.clear();
        ageTxtBox.sendKeys(age);
    }

    public void selectLanguageCheckbox(int index) {
        languageCheckboxes.get(index).click();
    }

    public void selectGenreRadioBtn(int index) {
        genreRadioBtn.get(index).click();
    }

    public boolean radioBtnIsSelected(int index) {
        return genreRadioBtn.get(index).isSelected();
    }

    public String getSelectHowDoYouLikeUsDropdownOption() {
        Select dropdownSelect = new Select(dropdownBox);
        return dropdownSelect.getFirstSelectedOption().getText();
    }

    public void selectDropdownHowDoYouLikeUsOption(String text) {
        Select dropdownOption = new Select(dropdownBox);
        dropdownOption.selectByVisibleText(text);
    }

    public void selectCommentBox() {
        commentArea.click();
    }

    public void clickOnSendButton() {
        sendBtn.click();
    }
}
