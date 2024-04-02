package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    WebDriver driver;
    ElementUtil elementUtil;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    private By kycLink = By.xpath("//a[@href='/auth/settings/kyc']");
    private By GAuthLink = By.xpath("//a[@href='/auth/settings/authentication']");


    // =================================== Methods ====================================== //

    public KYCPage doKYC ()
    {
        elementUtil.checkElementClickable(kycLink, 5);
        elementUtil.doClick(kycLink);
        elementUtil.waitForPageLoad(10);
        return new KYCPage(driver);
    }

    public AuthenticatorPage setup2FA ()
    {
        elementUtil.checkElementClickable(GAuthLink, 5);
        elementUtil.doClick(GAuthLink);
        elementUtil.waitForPageLoad(10);
        return new AuthenticatorPage(driver);
    }



}
