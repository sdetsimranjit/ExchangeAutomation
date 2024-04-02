package Ant.qa.tradecrypto.pages.Admin;

import Ant.qa.tradecrypto.pages.UserSide.OTPPage;
import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLandingPage {
    WebDriver driver;
    ElementUtil elementUtil;
    OTPPage otpPage;

    public AdminLandingPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
        otpPage = new OTPPage(this.driver);
    }

    protected By adminEmail = By.id("email");
    protected By password = By.id("password");
    protected By submit = By.xpath("//button[@type='submit']");




    public AdminDashboard doAdminLogin (String email, String Password)
    {
        elementUtil.waitForElementVisible(adminEmail, 20);
        elementUtil.doSendKeys(adminEmail, email);
        elementUtil.doSendKeys(password, Password);
        elementUtil.doClick(submit);
        otpPage.submitAdminOTP();
        return new AdminDashboard(driver);

    }

}
