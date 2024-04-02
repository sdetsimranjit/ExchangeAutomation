package Ant.qa.tradecrypto.pages.Admin;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboard {
    WebDriver driver;
    ElementUtil elementUtil;
    public AdminDashboard(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    protected By kycTab = By.xpath("//h3[@href='https://stage-admin.domuscrypto.com/kyc']");



    public KYCLsitingPage goToKYCTab()
    {
        elementUtil.waitForElementVisible(kycTab, 10);
        elementUtil.doClick(kycTab);
        return new KYCLsitingPage(driver);

    }





}
