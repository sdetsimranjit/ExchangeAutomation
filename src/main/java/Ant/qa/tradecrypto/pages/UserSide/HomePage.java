package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    ElementUtil elementUtil;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    private final By registerLink = By.xpath("//a[@href='/signup']");


    public RegisterPage goToSignUp()
    {
        elementUtil.getTitle();
        elementUtil.naviGateTo("https://stage.domuscrypto.com/signup");
        return new RegisterPage(driver);
    }
    public LoginPage login()
    {
        elementUtil.naviGateTo("https://stage.domuscrypto.com/login");
        return new LoginPage(driver);
    }

    public Wallet wallet()

    {
        elementUtil.naviGateTo("https://stage.domuscrypto.com/auth/wallet");
        return new Wallet(driver);
    }


}
