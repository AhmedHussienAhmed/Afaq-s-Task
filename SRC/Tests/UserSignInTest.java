package Tests;

import Pages.HomePage;
import Pages.UserSignupPage;
import org.testng.annotations.Test;


public class UserSignInTest extends testBase{

    HomePage homeObject;

    @Test
    public void UserSignInSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.userNavigatesSignupPageToSignIn();
        homeObject.userSignIn("ahmedhussien1110@outlook.com","A12345678900");
        //homeObject.userLogout();
    }



}
