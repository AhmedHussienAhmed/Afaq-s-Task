package Tests;

import Pages.HomePage;
import Pages.UserSignupPage;
import org.testng.annotations.Test;

public class UserSignupTest extends testBase {

    HomePage homeObject;
    UserSignupPage signUpObject;

    @Test
    public void UserRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.userNavigatesSignupPage("ahmedhussien1111@outlook.com");
        signUpObject = new UserSignupPage(driver);
        signUpObject.userSignup("Ahmed", "Hussien",
                "A12345678900","11","February ","1994" ,
                "APPTCOM", "17 street Mohamed Ramzy",
                "Apartment 9", "Egypt", "Alaska",
                "00000", "0221111111",
                "0221111111", "01000033001","Heliopolis");
        signUpObject.clickOnRegister();
        homeObject.userLogout();

    }


}
