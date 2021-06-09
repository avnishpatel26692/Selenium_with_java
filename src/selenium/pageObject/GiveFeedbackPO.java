package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedbackPO {

    @FindBy(how = How.NAME, using = "name")
    private WebElement nameBox;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageBox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> languageBox;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> radioBox;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement howDoYouLikeDropdown;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentField;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Send')]")
    private WebElement submitButton;


    public String getName() {
        return nameBox.getText();
    }

    public String setName(String name) {
        nameBox.sendKeys(name);
        return name;
    }


    public String getAge() {
        return ageBox.getText();
    }

    public String setAge(String age) {
        ageBox.sendKeys(age);
        return age;
    }


    public boolean getLanguageButtonStatus(int index) {
        return languageBox.get(index).isSelected();
    }

    public void chooseCheckbox(int index) {
        languageBox.get(index).click();
    }


    public boolean getRadioButtonStatus(int index) {
        return radioBox.get(index).isSelected();
    }

    public void chooseRadioButton(int index) {
        radioBox.get(index).click();
    }


    public String getSelDropDown() {
        Select dropdown = new Select(howDoYouLikeDropdown);
        return dropdown.getFirstSelectedOption().getText();
    }


    public void chooseSelDropDown(String option) {
        Select dropdown = new Select(howDoYouLikeDropdown);
        dropdown.selectByVisibleText(option);
    }

    public String getComment() {
        return commentField.getText();
    }

    public void setComment(String comment) {
        commentField.sendKeys(comment);
    }


    public WebElement submitButton() {
        return submitButton;
    }

}
