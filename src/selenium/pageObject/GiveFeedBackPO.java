package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPO {

    @FindBy(how = How.ID,using = "fb_name")
    private static WebElement nameTextbox;

    @FindBy(how = How.ID, using = "fb_age")
    private static WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private static List<WebElement> languageCheckbox;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private static List<WebElement> genderRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private static WebElement howDoYouLikeUsDropDown;

    @FindBy(how = How.NAME, using = "comment")
    private static WebElement commentTextbox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement sendBtn;

    public static void setLanguageCheckbox(List<WebElement> languageCheckbox) {
        GiveFeedBackPO.languageCheckbox = languageCheckbox;
    }

    public static void setGenderRadioBtn(List<WebElement> genderRadioBtn) {
        GiveFeedBackPO.genderRadioBtn = genderRadioBtn;
    }

    public String getName(){
        return nameTextbox.getText();
    }

    public static void setName(String name){
        nameTextbox.sendKeys(name);
    }

    public String getAge(){
        return ageTextbox.getText();
    }
    public static void setAge(String age) {
        ageTextbox.sendKeys(age);
    }

    public boolean getLanguageCheckBoxStatus(int index) {
        return languageCheckbox.get(index).isSelected();
    }

    public static void selectCheckbox(int index) {
        languageCheckbox.get(index).click();
    }

    public boolean getRadioBtnStatus(int index) {
        return genderRadioBtn.get(index).isSelected();
    }

    public static void selectRadioBtn(int index) {
        genderRadioBtn.get(index).click();
    }

    public static String getSelectedDropDownOption() {
        Select dropdown = new Select(howDoYouLikeUsDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public static void selectDropdownOption(String option) {
        Select dropdown = new Select(howDoYouLikeUsDropDown);
        dropdown.selectByVisibleText(option);
    }

    public  String getComment(){
        return commentTextbox.getText();
    }

    public static void setComment(String comment){
        commentTextbox.sendKeys(comment);
    }

    public static WebElement sendBtn(){
        return sendBtn;
    }
}
