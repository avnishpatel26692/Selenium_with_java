package selenium.sample.ActivityDayThree.ActivityDayThreePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FinalMessagePO
{
@FindBy (how = How.XPATH, using = "//h2[@id='message']")
    private WebElement message;

    public WebElement getMessage(){
        return message;
    }
}
