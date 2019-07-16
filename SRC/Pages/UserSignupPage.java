package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserSignupPage extends pageBase {

    public UserSignupPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(id = "id_gender1")
    WebElement titleRdBtn;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "passwd")
    WebElement userPassword;

    @FindBy(id = "days")
    WebElement daysDdList;

    @FindBy(id = "months")
    WebElement monthsDdList;

    @FindBy(id = "years")
    WebElement yearsDdList;

    @FindBy(id = "company")
    WebElement companyName;

    @FindBy(id = "address1")
    WebElement userAddress;

    @FindBy(id = "address2")
    WebElement userAddressLine2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement userState;

    @FindBy(id = "postcode")
    WebElement userPostalCode;

    @FindBy(id = "other")
    WebElement addInfo;

    @FindBy(id = "phone")
    WebElement homePhone;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement addressAlias;

    @FindBy(id = "submitAccount")
    WebElement registerButton;


    public void userSignup(String firstName, String lastName, String password,
                           String days,String month,String year,String compName, String useraddress,
                           String addressLine2,
                           String userCity,String states, String postalCode,
                           String additionalInfo, String phone, String mobile
            , String alias) throws InterruptedException {

        clickButton(titleRdBtn);
        scrollDown();
        setText(customerFirstName,firstName);
        setText(customerLastName,lastName);
        setText(userPassword,password);
        Thread.sleep(1000);
        setText(daysDdList,days);
        setText(monthsDdList,month);
        Thread.sleep(2000);
        setText(yearsDdList,year);
        scrollDown();
        setText(companyName,compName);
        setText(userAddress,useraddress);
        setText(userAddressLine2,addressLine2);
        setText(city,userCity);
        setText(userState,states);
        setText(userPostalCode,postalCode);
        setText(addInfo,additionalInfo);
        Thread.sleep(1000);
        setText(homePhone,phone);
        setText(mobilePhone,mobile);
        setText(addressAlias,alias);
    }

    public void clickOnRegister()
    {
        if (registerButton.isDisplayed())
        {
            clickButton(registerButton);
            System.out.println("* User Clicked on RegisterButton Successfully");
            System.out.println("");

        }
        else
        {
            System.out.println("* User failed to clicked on RegisterButton Successfully");
            System.out.println("");
        }

    }

}
