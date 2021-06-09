package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePageP0 {

    @FindBy (how = How.NAME,using = "name")
    private WebElement textfield;


    @FindBy (how = How.ID,using = "age")
    private WebElement agefield;

    @FindBy (how = How.CSS,using = "button#submit")
    private WebElement submitbutton;

    @FindBy (how = How.ID,using = "error")
    private WebElement error;


    public void Entername(String name)
    {
        textfield.clear();
        textfield.sendKeys(name);
    }
    public void Enterage(String age)
    {
        agefield.sendKeys(age);
    }

    public void Submit()
    {
        submitbutton.click();
    }

    public String GetErrorMsg()
    {
        return error.getText();
    }



}
