package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sign in")
    WebElement signinButton;
    @FindBy(id = "email_create")
    WebElement enterEmailAddress;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    @FindBy (id = "email")
    WebElement RegisteredEmail ;

    @FindBy (id = "passwd")
    WebElement PassTxt ;

    @FindBy (id = "SubmitLogin")
    WebElement signInBtn ;



    public void userSignIn(String email , String passwd) throws InterruptedException
    {
        setText(RegisteredEmail,email);
        setText(PassTxt,passwd);
        clickButton(signInBtn);

    }

    public void userNavigatesSignupPageToSignIn() throws InterruptedException {

        if (signinButton.isDisplayed()) {
            clickButton(signinButton);
            System.out.println("* User clicked on sign in correctly");
            System.out.println("");

        } else {
            System.out.println("* User Failed to click on sign in");
            System.out.println("");
        }
        Thread.sleep(1000);
        scrollDown();
    }


    public void userNavigatesSignupPage(String emailaddress) throws InterruptedException {

        if (signinButton.isDisplayed())
        {
            clickButton(signinButton);
            System.out.println("* User clicked on sign in correctly");
            System.out.println("");

        }
        else
        {
            System.out.println("* User Failed to click on sign in");
            System.out.println("");
        }
        Thread.sleep(1000);
        scrollDown();
        if (enterEmailAddress.isDisplayed())
        {
            enterEmailAddress.sendKeys(emailaddress);
            System.out.println("* User enters email address correctly");
            System.out.println("");

        }
        else
        {
            System.out.println("* User failed to enter email address");
            System.out.println("");
        }
        Thread.sleep(1000);
        if (createAnAccountButton.isDisplayed())
        {
            clickButton(createAnAccountButton);
            System.out.println("* User clicked on create account correctly");
            System.out.println("");

        }
        else
        {
            System.out.println("* User Failed to click on create account");
            System.out.println("");
        }

    }

    public void userLogout() throws InterruptedException {

        Thread.sleep(3000);
        if (signOut.isDisplayed())
        {
            System.out.println("* User created Account Successfully");
            System.out.println("");
            clickButton(signOut);
            System.out.println("* User Signout correctly From website");
            System.out.println("");
        }
        else
        {
            System.out.println("* User Failed to signout");
            System.out.println("");
        }

    }


}
