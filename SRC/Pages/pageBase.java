package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class pageBase {

    protected WebDriver driver;
    public pageBase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected static void clickButton(WebElement button)
    {
        button.click();
    }

    protected static void setText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }


    public void scrollDown()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    }

    public void scrollUp()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(300,0)");

    }


}
