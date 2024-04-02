package ant.qa.tradecrypto.tests.Admin;

import Ant.qa.tradecrypto.factory.DriverFactory;
import ant.qa.tradecrypto.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminKYCTest extends BaseTest {
    @BeforeTest
    public void preReq()
    {
        adminLandingPage = DriverFactory.launchAdmin(prop);
        adminDashboard =    adminLandingPage.doAdminLogin(prop.getProperty("adminEmail"), prop.getProperty("adminPassword"));
        kycLsitingPage = adminDashboard.goToKYCTab();
    }


    @Test
    public void getListing() throws InterruptedException {
        kycLsitingPage.getIntermediateKYCListing(prop.getProperty("email"));
    }



}
