package selenium.pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class feedBack  {
    @FindBy(how= How.XPATH,using="//span[@id='name']")
    private WebElement name;

    @FindBy(how= How.XPATH,using="//span[@id='age']")
    private WebElement age;

    @FindBy(how= How.XPATH,using="//span[@id='language']")
    private WebElement language;

    @FindBy(how= How.XPATH,using="//span[@id='gender']")
    private WebElement gender;

    @FindBy(how= How.XPATH,using="//span[@id='option']")
    private WebElement option;

    @FindBy(how= How.XPATH,using="//span[@id='comment']")
    private WebElement comment;

    @FindBy(how= How.XPATH,using="//button[contains(@class,'w3-green')]")
    private WebElement green_btn;

    @FindBy(how= How.XPATH,using="//button[contains(@class,'w3-red')]")
    private WebElement red_btn;

    public String resultName(){
        return name.getText();
    }

    public String resultAge(){
        return age.getText();
    }

    public String resultLanguage(){
        return language.getText();
    }

    public String resultGender(){
        return gender.getText();
    }

    public String resultOption(){
        return option.getText();
    }

    public String resultComment(){
        return comment.getText();
    }

    public void isEmpty(){
        Assert.assertEquals("",name.getText());
        Assert.assertEquals("",age.getText());
        Assert.assertEquals("",language.getText());
        Assert.assertEquals("null",gender.getText());
        Assert.assertEquals("null",option.getText());
        Assert.assertEquals("",comment.getText());
    }

    public void checkButtons(){
        String button_color1 = green_btn.getCssValue("background-color");
        String text_color1 = green_btn.getCssValue("text-decoration-color");

        String button_color2 = red_btn.getCssValue("background-color");
        String text_color2 = red_btn.getCssValue("text-decoration-color");

        Assert.assertEquals("rgba(76, 175, 80, 1)",button_color1);
        Assert.assertEquals("rgba(244, 67, 54, 1)",button_color2);
        Assert.assertEquals("rgb(255, 255, 255)",text_color1);
        Assert.assertEquals("rgb(255, 255, 255)",text_color2);
    }
}