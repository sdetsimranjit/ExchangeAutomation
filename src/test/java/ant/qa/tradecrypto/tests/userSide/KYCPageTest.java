package ant.qa.tradecrypto.tests.userSide;

import ant.qa.tradecrypto.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KYCPageTest extends BaseTest {
    @BeforeTest
    public void preReq() throws InterruptedException {
        loginPage = homePage.login();
        settingsPage =   loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        kycPage = settingsPage.doKYC();
    }


    @Test(priority = 1)
    public void doBasicKYC()
    {
        kycPage.basicKYC("Simran", prop.getProperty("mobileNo"), prop.getProperty("nationalID")) ;
    }

    @Test(priority = 2)
    public void doIntermediateKYC() {
        kycPage.intermediateKYC();
    }










}
