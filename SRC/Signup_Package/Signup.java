package Signup_Package;

import com.opencsv.CSVReader;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Signup {

    WebDriver driver;
    String Baseurl = "http://automationpractice.com/index.php";
    String CSVFile = "C:\\Users\\a.ragab\\Desktop\\Afaqys Task\\Signup-task-Afaqy\\TestData.csv";
    String DriverPath = "\"C:\\Users\\a.ragab\\Desktop\\Afaqys Task\\Signup-task-Afaqy\\Drivers\\chromedriver.exe";

    @Test
    public void user_Open_URL() throws Throwable {
        System.setProperty("webdriver.chrome.driver", DriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Baseurl);

    }

    @Test
    public void validateThatWebsiteOpenedCorrectly() throws Throwable {

        if (driver.getPageSource().contains("Contact Us") && driver.getPageSource().contains("Sign in")) {
            System.out.println("* Website Homepage Opened Successfully");
            System.out.println("");

        } else {
            System.out.println("* Website Homepage Failed To Be Opened");
            System.out.println("");


        }

    }

    @Test
    public void click_on_Signin() throws Throwable {


        WebElement Signin = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        Thread.sleep(2000);
        if (Signin.isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
            System.out.println("* Sign in Button clicked correctly");
            System.out.println("");
        } else {
            System.out.println("* Sign in Button Failed to be clicked");
            System.out.println("");
        }


    }

    @Test
    public void scrollDown() throws Throwable {

        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    }

    @Test
    public void validateSigninPage() throws Throwable {

        Thread.sleep(1000);
        WebElement EmailField = driver.findElement(By.id("email_create"));
        if (EmailField.isDisplayed())

        {
            System.out.println("*Sign in page Opened Successfully");
            System.out.println("");
        } else {
            System.out.println("* Sign in page Failed To Be Opened");
            System.out.println("");
        }
    }

    @Test
    public void enterEmailAddress() throws Throwable {


        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String emailaddressdata = data[i];
                driver.findElement(By.id("email_create")).sendKeys(emailaddressdata);
                System.out.println("* Email Address Entered Correctly");
                System.out.println("");

            }
        }
        Thread.sleep(5000);

    }

    @Test
    public void clickOnCreateAnAccount() throws Throwable {
        driver.findElement(By.id("SubmitCreate")).click();
        System.out.println("* Clicked on Register");
        System.out.println("");

    }

    @Test
    public void clickOnRegister() throws Throwable {

        WebElement RegisterButton = driver.findElement(By.id("submitAccount"));
        if (RegisterButton.isDisplayed()) {
            RegisterButton.click();
            System.out.println("* Register Button Clicked Correctly");
            System.out.println("");
        } else {
            System.out.println("* Register Button Failed To be Clicked ");
            System.out.println("");
        }


    }

    @Test
    public void userFillHisTitle() throws Throwable {

        WebElement title = driver.findElement(By.id("id_gender1"));

        title.click();
        if (title.isSelected()) {
            System.out.println("* Title is selected correctly");
            System.out.println("");

        } else {
            System.out.println("* Title is Failed to be clicked");
            System.out.println("");
        }
    }

    @Test
    public void userFillHisCustomerFirstname() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String firstName = data[i + 1];
                driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
                System.out.println("*  FirstName entered Correctly");
                System.out.println("");

            }
        }

    }

    @Test
    public void userFillHisCustomerLastname() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String lastName = data[i + 2];
                driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
                System.out.println("*  LastName entered Correctly");
                System.out.println("");
            }
        }

    }

    @Test
    public void userFillHisPassword() throws Throwable {
        Thread.sleep(1000);
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String password = data[i + 3];
                driver.findElement(By.id("passwd")).sendKeys(password);
                System.out.println("* password entered Correctly");
                System.out.println("");
            }
        }
    }

    @Test
    public void userFillHisDateOfBirth() throws Throwable {

        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String Day = data[i + 4];
                Select Days = new Select(driver.findElement(By.id("days")));
                Days.selectByValue(Day);
                System.out.println("* Day Selected Correctly");
                System.out.println("");

                String Month = data[i + 5];
                Select Months = new Select(driver.findElement(By.id("months")));
                Months.selectByValue(Month);
                System.out.println("* Month Selected Correctly");
                System.out.println("");

                String year = data[i + 6];
                Select years = new Select(driver.findElement(By.id("years")));
                years.selectByValue(year);
                System.out.println("* year Selected Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisCompany() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String company = data[i + 7];
                driver.findElement(By.id("company")).sendKeys(company);

                System.out.println("* CompanyName entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisAddress() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String address = data[i + 8];
                driver.findElement(By.id("address1")).sendKeys(address);

                System.out.println("* Address entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisCity() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String city = data[i + 10];
                driver.findElement(By.id("city")).sendKeys(city);

                System.out.println("* city entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisState() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String state = data[i + 11];
                Select states = new Select(driver.findElement(By.id("id_state")));
                states.selectByVisibleText(state);
                System.out.println("* State Selected Correctly");
                System.out.println("");

            }
        } //Alaska
    }

    @Test
    public void userFillHisPostalCode() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String city = data[i + 12];
                driver.findElement(By.id("postcode")).sendKeys(city);

                System.out.println("* city entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisCountry() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String city = data[i + 11];
                driver.findElement(By.id("postcode")).sendKeys(city);

                System.out.println("* city entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisInfo() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String info = data[i + 13];
                driver.findElement(By.id("other")).sendKeys(info);

                System.out.println("* info entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisPhone() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String phone = data[i + 14];
                driver.findElement(By.id("phone")).sendKeys(phone);

                System.out.println("* PhoneNumber entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisAlias() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String addressAlias = data[i + 16];
                driver.findElement(By.id("alias")).sendKeys(addressAlias);
                System.out.println("* Alias entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisFirstname() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String lastName = data[i + 2];
                driver.findElement(By.id("firstname")).sendKeys(lastName);
                System.out.println("* FirstName entered Correctly");
                System.out.println("");

            }
        }
        Thread.sleep(2000);
    }

    @Test
    public void userFillHisLastname() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String lastName = data[i + 2];
                driver.findElement(By.id("lastname")).sendKeys(lastName);
                System.out.println("* LastName entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisMobileNumber() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String mobileNumber = data[i + 15];
                driver.findElement(By.id("phone_mobile")).sendKeys(mobileNumber);
                System.out.println("* Mobile Number entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void userFillHisAddressSecondLine() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String addressSecond = data[i + 9];
                driver.findElement(By.id("address2")).sendKeys(addressSecond);
                System.out.println("* Address line 2 entered Correctly");
                System.out.println("");

            }
        }
    }

    @Test
    public void signout() throws Throwable {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
    }

    @Test
    public void validateLogin() throws Throwable {
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        String[] data;
        while ((data = reader.readNext()) != null) {
            for (int i = 0; i < 1; i++) {
                String accountName = data[i + 17];
                Thread.sleep(3000);
                if (driver.getPageSource().contains(accountName) || driver.getPageSource().contains("MY WISHLISTS")) {
                    System.out.println("* User Validate Sign in Correctly");
                    System.out.println("");
                } else {
                    System.out.println("* User Failed To sign in");
                    System.out.println("");
                }


            }
        }
    }

    @Test
    public void validateSigningOut() throws Throwable {

        if (driver.getPageSource().contains("Contact Us") && driver.getPageSource().contains("Sign in")) {
            System.out.println("* Website Homepage Opened Successfully");
            System.out.println("");

        } else {
            System.out.println("* Website Homepage Failed To Be Opened");
            System.out.println("");

        }

    }

    @Test
    public void closeWebsite() throws Throwable {
        driver.close();
        System.out.println("* Website Closed Successfully");
        System.out.println("");

    }
}
