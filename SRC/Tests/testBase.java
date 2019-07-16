package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class testBase {


    public static WebDriver driver;
    public String Baseurl = "http://automationpractice.com/index.php";
    public String DriverPath = "G:\\Task\\Afaq-s-Task-master\\Drivers\\chromedriver.exe";
    //public String CSVFile = "C:\\Users\\a.ragab\\Desktop\\Afaqys Task\\Signup-task-Afaqy\\TestData.csv";

    @BeforeTest
    public void startDriver() {
        //System.setProperty("webdriver.chrome.driver", DriverPath);
        //C:\Users\a.ragab\Desktop\Signup-task-Afaqy\Drivers
        System.setProperty("webdriver.chrome.driver", DriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Baseurl);

    }


    @AfterTest
    public void stopDriver() throws InterruptedException {

        Thread.sleep(4000);
        driver.close();
        driver.quit();
    }


}
