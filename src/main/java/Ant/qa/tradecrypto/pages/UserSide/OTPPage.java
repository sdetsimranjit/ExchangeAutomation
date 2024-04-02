package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OTPPage {
    WebDriver driver;
    ElementUtil elementUtil;
    String staticOTP = "111111";

    public OTPPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }
   private By toastMessage = By.xpath("//div[@role='status']");
   private By otpInput = By.xpath("//div[@class='otpInput']/input");
    private By submitBtn = By.xpath("//button[@class='commonBtn_style mt-4 internalComn_btn false']");


 // ============= Admin ========================================== //

    private By adminOTPField  = By.name("otp");
    protected By submit = By.xpath("//button[@type='submit']");


   // ========================================= Methods ================================================ //


    public void submitOtp()  {
        //Thread.sleep(5000);
       elementUtil.waitForElementVisible(toastMessage, 20);
       elementUtil.doClick(otpInput);
       elementUtil.doSendKeys(otpInput, staticOTP);
       elementUtil.doClick(submitBtn);
       elementUtil.waitForElementVisible(toastMessage, 10);
    }

    public void submitAdminOTP()
    {
        elementUtil.waitForElementVisible(adminOTPField, 10);
        elementUtil.doSendKeys(adminOTPField, staticOTP);
        elementUtil.doClick(submit);
    }

    public void submitWithdrawOTP()
    {
        //Thread.sleep(5000);
      //  elementUtil.waitForElementVisible(toastMessage, 20);
        elementUtil.doClick(otpInput);
        elementUtil.doSendKeys(otpInput, staticOTP);
        elementUtil.doClick(submitBtn);
        //elementUtil.waitForElementVisible(toastMessage, 10);
    }





}
