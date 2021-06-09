package selenium.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedback  extends FeedbackFinal {

    @FindBy(how = How.ID,using = "fb_name")
    private WebElement Name;

    @FindBy(how = How.ID,using = "fb_age")
    private WebElement Age;

    @FindBy (how=How.XPATH, using = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy (how=How.XPATH, using = "//input[@type = 'radio']")
    private List<WebElement> radiobuttons;

    @FindBy(how = How.CSS, using = "select#like_us")
    private WebElement Selectoption;

    @FindBy(how = How.XPATH,using = "//textarea[@name='comment']")
    private WebElement textarea;
    @FindBy(how = How.XPATH,using = "//button[@type='submit']")
    private WebElement submitbutton;


    public void setName (String name)
    {
        Name.sendKeys(name);
    }
    public String getName()   {
        return Name.getText();
    }


    public void setAge (String age)
    {
        Age.sendKeys(age);
    }
    public String getAge(){
        return Age.getText();
    }

    public void Checkboxes(int index) {
        checkboxes.get(index).click();
    }

    public boolean getcheckboxes(int index)
    {
        checkboxes.get(index).isSelected();
        return checkboxes.get(index).isSelected();
    }

    public void radioButtons(int index){
        radiobuttons.get(index).click();
    }
    public boolean getradiobuttons(int index)
    {
        radiobuttons.get(index).isSelected();
        return radiobuttons.get(index).isSelected();
    }

    public void selectDropdown(String option){
        Select dropdown1 = new Select(Selectoption);
        dropdown1.selectByVisibleText(option);
    }
    public String getDropDown(){
        Select dropdown1 = new Select(Selectoption);
        return dropdown1.getFirstSelectedOption().getText();

    }
    public void setTextarea(String comment){
        textarea.sendKeys(comment);
    }
    public String getTextArea () {
        return textarea.getText();
    }
    public WebElement submit(){
        return submitbutton;
    }








}
