package ant.qa.tradecrypto.tests.Admin;

import Ant.qa.tradecrypto.factory.DriverFactory;
import ant.qa.tradecrypto.base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminDashboardTest extends BaseTest {
    @BeforeTest
    public void preReq()
    {
        adminLandingPage = DriverFactory.launchAdmin(prop);
        adminDashboard =    adminLandingPage.doAdminLogin(prop.getProperty("adminEmail"), prop.getProperty("adminPassword"));
    }

    @Test
    public void loginToAdmin()
    {
        adminDashboard.goToKYCTab();
    }



}
