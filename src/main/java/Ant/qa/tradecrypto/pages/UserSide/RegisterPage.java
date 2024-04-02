package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage  {
    private WebDriver driver;
    ElementUtil elementUtil;
    OTPPage otpPage;
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
        otpPage = new OTPPage(this.driver);
    }

    // ============================== Elements ======================================== //

    private By emailId = By.xpath("//input[@name='username']");
    private By emailIdError = By.xpath("(//div[@class='customInput undefined']/div)[1]");
    private By password = By.xpath("//input[@name='password']");
    private By confirmPassword = By.xpath("//input[@name='confirmPassword']");
    private By tandcCheckBox = By.id("termsOfService");
    private By submitBtn = By.xpath("//button[@type='submit']");
    private By skip2FA = By.cssSelector(".mt-4");
    private By body = By.tagName("body");




    // ===================================== Methods ================================ //

    public String getRegisterPageTitle ()
    {
        String title = driver.getTitle();
        System.out.println("Register Page Title is: " + title);
        return title;
    }

    public SettingsPage createAccount(String email, String accPassword) throws InterruptedException {
//        elementUtil.doClick(emailId);
//        elementUtil.doClick(body);
        elementUtil.doSendKeys(emailId, email);
        elementUtil.doSendKeys(password, accPassword);
        elementUtil.doSendKeys(confirmPassword, accPassword);
        elementUtil.doClick(tandcCheckBox);
        elementUtil.doClick(submitBtn);
        otpPage.submitOtp();
        elementUtil.checkElementClickable(skip2FA, 5);
        elementUtil.doClick(skip2FA);
        return new SettingsPage(driver);
    }
    public String createAccountNegative(String email) throws InterruptedException {
        elementUtil.doClick(emailId);
        elementUtil.doClick(body);
        elementUtil.doSendKeys(emailId, email);
        return elementUtil.doGetElementText(emailIdError);
    }










}
