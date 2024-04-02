package ant.qa.tradecrypto.tests.userSide;

import ant.qa.tradecrypto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class WalletPageTest extends BaseTest {

    @BeforeTest
    public void preReq() throws InterruptedException {
        loginPage = homePage.login();
        settingsPage =   loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        wallet = homePage.wallet();
    }

    @Test(priority = 1)
    public void doWithdarw() throws IOException, UnsupportedFlavorException, InterruptedException {
        wallet.getETHBal();
        wallet.getETHDepositAddress();
        loginPage.doLogoutAndLogin("test0603@yopmail.com", "Admin@791");
        wallet.doWithdraw(String.valueOf(prop.getProperty("amount")));
       // wallet.checkWithdraw();
      //  loginPage.doLogoutAndLogin(prop.getProperty("email"), "Admin@791");
      //  wallet.checkDeposit();
    }

    @Test(priority = 2)
    public void checkWithDrawAmount ()
    {
        boolean res = wallet.checkWithdraw();
        Assert.assertTrue(res, "Withdraw Balance is Correct");
    }

    @Test(priority =3)
    public void checkDepositAmount () throws InterruptedException {
        loginPage.doLogoutAndLogin(prop.getProperty("email"), "Admin@791");
        boolean res = wallet.checkDeposit();
        Assert.assertTrue(res, "Deposit Balance is Correct");
    }


}
