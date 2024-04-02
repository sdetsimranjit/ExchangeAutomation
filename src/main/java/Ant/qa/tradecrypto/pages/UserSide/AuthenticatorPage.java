package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticatorPage {
    WebDriver driver;
    ElementUtil elementUtil;
    public AuthenticatorPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }


    private By setupBtn = By.xpath("//button[@type='submit']");




}
