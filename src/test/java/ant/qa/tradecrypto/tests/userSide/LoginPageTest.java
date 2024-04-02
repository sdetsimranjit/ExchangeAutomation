package ant.qa.tradecrypto.tests.userSide;

import ant.qa.tradecrypto.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeTest
    public void preReq()
    {
        loginPage = homePage.login();
    }

    @Test
    public void loginToPlatform () throws InterruptedException {
        loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password") );
    }





}
