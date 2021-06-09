package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePagePO {

    @FindBy(how = How.NAME, using = "name")
    private WebElement nameTxtBox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTxtBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Submit']")
    private WebElement submitBtn;

    @FindBy(how = How.CSS, using = "p.error")
    private WebElement errorMesg;

    public void enterName(String name) {
        nameTxtBox.clear();
        nameTxtBox.sendKeys(name);
    }

    public void enterAge(String age) {
        ageTxtBox.sendKeys(age);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public String getErrorMsg() {
        return errorMesg.getText();
    }
}
