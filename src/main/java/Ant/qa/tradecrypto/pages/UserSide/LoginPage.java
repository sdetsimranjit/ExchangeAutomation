package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    ElementUtil elementUtil;
    OTPPage otpPage;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
        otpPage = new OTPPage(this.driver);
    }


    private By loginEmail = By.name("username");
    private By loginPassword = By.name("password");
    private By submitBtn = By.xpath("//button[@type='submit']");

    private By userNavLink = By.xpath("//a[@class='dropdown-toggle nav-link']");
    private By logoutLink = By.xpath("//div[@class='dropdown-menu show']/p");
    private By requestPopupYes = By.xpath("(//div[@class='cancelRequestbuttons']/button)[1]");
    private By loginLink = By.xpath("//a[@href='/login']");





    // ================== Methods ================================================== //

    public SettingsPage doLogin (String email, String  Password) throws InterruptedException {
        elementUtil.waitForElementVisible(loginEmail, 10);
        elementUtil.doSendKeys(loginEmail, email);
        elementUtil.doSendKeys(loginPassword, Password);
        elementUtil.doClick(submitBtn);
        otpPage.submitOtp();
        Thread.sleep(3000);
        driver.navigate().refresh();
        return new SettingsPage(driver);
    }

    public Wallet doLogoutAndLogin(String email, String password) throws InterruptedException {
        Thread.sleep(4000);
        elementUtil.waitForElementVisible(userNavLink,10);
        elementUtil.doClick(userNavLink);
        Thread.sleep(2000);
        elementUtil.waitForElementVisible(logoutLink, 10);
        elementUtil.doClick(logoutLink);
        elementUtil.doClick(requestPopupYes);
        Thread.sleep(4000);
        elementUtil.waitForElementVisible(loginLink, 10);
        elementUtil.doClick(loginLink);
        doLogin(email, password);
        elementUtil.naviGateTo("https://stage.domuscrypto.com/auth/wallet");
        return new Wallet(driver);
    }






}

