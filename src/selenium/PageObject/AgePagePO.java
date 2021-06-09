package selenium.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePagePO extends NavBarPO {
    @FindBy(how = How.NAME, using = "name")
    private WebElement nameTxtBox;

    @FindBy(how=How.ID, using="age")
    private WebElement ageTxtBox;

    @FindBy(how=How.XPATH, using="//button[@id='submit']")
    private WebElement button;

    @FindBy(how = How.CSS,using="p.error")
    private WebElement errorMsg;

    public void enterName(String name){
        nameTxtBox.clear();
        nameTxtBox.sendKeys(name);
    }

    public void enterAge(String age){
        ageTxtBox.clear();
        ageTxtBox.sendKeys(age);
    }

    public void submit(){
        button.click();
    }

    public String errorMsg(){
        return errorMsg.getText();
    }
}
