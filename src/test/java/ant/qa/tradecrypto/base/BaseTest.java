package ant.qa.tradecrypto.base;

import Ant.qa.tradecrypto.factory.DriverFactory;
import Ant.qa.tradecrypto.pages.Admin.AdminDashboard;
import Ant.qa.tradecrypto.pages.Admin.AdminLandingPage;
import Ant.qa.tradecrypto.pages.Admin.KYCLsitingPage;
import Ant.qa.tradecrypto.pages.UserSide.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected KYCPage kycPage;
    protected  SettingsPage settingsPage;
    public static OTPPage otpPage;
    protected DriverFactory df;
    protected Properties prop;

    // ============ Admin =============================== //
    protected AdminLandingPage adminLandingPage;
    protected AdminDashboard adminDashboard;
    protected KYCLsitingPage kycLsitingPage;
    protected Wallet wallet;

  //  @Parameters({"browser"})
    @BeforeTest
    public void setUp() {
       df = new DriverFactory();
       prop = df.initProp();

//       if(browserName!=null)
//       {
//           prop.setProperty("browser", browserName);
//       }
       driver = df.initDriver(prop);
       homePage = new HomePage(driver);
       otpPage = new OTPPage(driver);
    }


    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
}
