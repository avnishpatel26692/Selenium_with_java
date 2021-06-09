package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Age {
    @FindBy(how = How.NAME, using = "name")
    private WebElement nameTextbox;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Submit']")
    private WebElement submitBtn;

    @FindBy(how = How.CSS, using = "p.error")
    private WebElement errorMsg;

    public void enterName(String name)
    {
        nameTextbox.clear();
        nameTextbox.sendKeys(name);
    }

    public void enterAge(String age)
    {
        ageTextbox.sendKeys(age);
    }

    public void clickOnSubmitBtn()
    {
        submitBtn.click();
    }

    public String getErrorMsg()
    {
        return errorMsg.getText();
    }
}
