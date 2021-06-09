package selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class FeedBackPO {
    @FindBy(how = How.ID, using = "name")
    private static WebElement nameTextbox;

    @FindBy(how = How.ID, using = "age")
    private static WebElement ageTextbox;

    @FindBy(how = How.ID, using = "language")
    private static WebElement languageCheckbox;

    @FindBy(how = How.ID, using = "gender")
    private static WebElement genderRadioBtn;

    @FindBy(how = How.ID, using = "option")
    private static WebElement howDoYouLikeUsDropDown;

    @FindBy(how = How.ID, using = "comment")
    private static WebElement commentTextBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Yes']")
    private static WebElement yesBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='No']")
    private static WebElement noBtn;

    public static String checkName(){
        return nameTextbox.getText();
    }

    public static String checkAge() {
        return ageTextbox.getText();
    }

    public static String checkLanguage(){
        return languageCheckbox.getText();
    }

    public static String checkGender(){
        return genderRadioBtn.getText();
    }

    public static String checkLikeUs(){
        return howDoYouLikeUsDropDown.getText();
    }

    public static String checkComment(){
        return commentTextBox.getText();
    }


    public static WebElement getYesBtn(){
        return yesBtn;
    }
    public void clickYesBtn(){
        yesBtn.click();
    }

    public static WebElement getNoBtn() {
        return noBtn;
    }
    public void clickNoBtn(){
        noBtn.click();
    }

}