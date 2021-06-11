package selenium.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class GiveFeedBackPO {
    @FindBy(how = How.XPATH, using="//input[@id='fb_name']")
    private WebElement name;

    @FindBy(how=How.XPATH, using="//input[@id='fb_age']")
    private WebElement age;

    @FindBy(how=How.XPATH, using="//input[@type='checkbox']")
    private List<WebElement> language;

    @FindBy(how=How.XPATH,using="//input[@value='male']")
    private WebElement male;

    @FindBy(how=How.XPATH,using="//input[@value='female']")
    private WebElement female;

    @FindBy(how=How.XPATH,using="//select[@id='like_us']")
    private WebElement list;

    @FindBy(how = How.XPATH,using = "//option[text()='Choose your option']")
    private WebElement default_option;

    @FindBy(how = How.XPATH,using="//select[@id='like_us']/option")
    private List<WebElement> options;

    @FindBy(how=How.XPATH,using ="//textarea[@name='comment']")
    private WebElement comment;

    @FindBy(how=How.XPATH,using="//button[@type='submit']")
    private WebElement button;

    public void enterName(String name){
        this.name.sendKeys(name);
    }

    public String getName(){
        return name.getAttribute("value");
    }

    public void enterAge(int age){
        this.age.sendKeys(""+age);
    }

    public String getAge(){
        return age.getAttribute("value");
    }

    public void chooseLanguage(String language){
        for(WebElement e : this.language){
            if(language.contains(e.getAttribute("value"))){
                e.click();
            }
        }
    }

    public List<String> getLanguages(){
        List<String> result = new LinkedList<>();
        for(WebElement e : language){
            if(e.isSelected()){
                result.add(e.getAttribute("value"));
            }
        }
        return result;
    }

    public void chooseGender(String gender){
        if(gender=="male") male.click();
        if(gender=="female") female.click();
    }

    public String getGender(){
        if(male.isSelected()) return "male";
        if(female.isSelected()) return "female";
        return "null";
    }

    public void chooseOption(int option){
        Select select = new Select(list);
        if(option > 0 && option < 5) select.selectByIndex(option);
    }

    public String getOption(){
        for(WebElement e : options){
            if(e.isSelected()) return e.getAttribute("value");
        }
        return "null";
    }

    public void addComment(String comment){
        this.comment.sendKeys(comment);
    }

    public String getComment(){
        return comment.getAttribute("value");
    }

    public void submit(){
        button.click();
    }

    public void isEmpty(){
        Assert.assertEquals("",getName());
        Assert.assertEquals("",getAge());
        for(WebElement e : language){
            Assert.assertFalse(e.isSelected());
        }
        Assert.assertFalse(male.isSelected());
        Assert.assertFalse(female.isSelected());
        Assert.assertTrue(default_option.isSelected());
        Assert.assertEquals("",getComment());
    }

    public void checkButton(){
        String background_color = button.getCssValue("background-color");
        String text_color = button.getCssValue("text-decoration-color");

        Assert.assertEquals("rgba(33, 150, 243, 1)",background_color);
        Assert.assertEquals("rgb(255, 255, 255)",text_color);
    }
}