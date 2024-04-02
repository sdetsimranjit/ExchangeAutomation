package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class KYCPage {
    WebDriver driver;
    ElementUtil elementUtil;
    OTPPage otpPage;

    public KYCPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
        otpPage = new OTPPage(this.driver);

    }

    // ================================ Basic KYC Locators ===================================== //
    private By headerCard = By.xpath("(//div[@class='cardTopDiv'])[1]");
    private By basicKYCLink = By.xpath("(//button[@type='submit'])[1]");
    private By countryDropDown = By.id("rfs-btn");
    private By cointryIndia = By.id("rfs-IN");
    private By name = By.name("username");
    private By dob = By.name("dob");
    private By submitDetails = By.xpath("//div[@class='col-md-12 col-12']/button");
    private By dobCalender = By.className("react-datepicker__month-container");
    private By address = By.name("address");
    private By pincode = By.name("pinCode");
    private By city = By.name("city");
    private By mobileNo = By.xpath("//input[@placeholder='Enter your mobile']");
    private By nationalId = By.name("nationalId");
    private By verifyMobile = By.xpath("//div[@class='phone_input']/button");
 //   private By basicVerificationTick = By.xpath("//img[@alt='verification tick']");
    private By basicVerificationTick = By.xpath("(//button[@disabled])[1]");


    // ================================ Intermediate KYC Locators ===================================== //

    private By intermediateKYCLink = By.xpath("(//button[@type='submit'])[2]");
    private By imageNote = By.xpath("//div[@class='row']/h6");
    private By frontImageUpload = By.name("frontImage");
    private By backImageUpload = By.name("backImage");
    private By removeButton = By.className("removeBtn");
    private By selfieUpload = By.xpath("//input[@id='file']");
    private  By submitIntermediateKYC = By.xpath("//div[@class='mt-4 col-md-12 col-12']/button");
    private By dobDate = By.xpath("(//div[@class='react-datepicker__day react-datepicker__day--006'])[1]");





    public void basicKYC(String userName, String mobile, String nationalID) {
        // 1st Popuop
        elementUtil.waitForElementVisible(headerCard, 10);
        elementUtil.doClick(basicKYCLink);
        elementUtil.waitForElementVisible(countryDropDown, 10);
        elementUtil.doClick(countryDropDown);
        elementUtil.doClick(cointryIndia);
        elementUtil.doSendKeys(name, userName);
        elementUtil.doClick(dob);
        elementUtil.waitForElementsVisible(dobCalender, 10);
        elementUtil.doClick(dobDate);
      //  elementUtil.doSendKeys(dob, "08/10/1997");
       // elementUtil.waitForElementsVisible(dobCalender, 10);
        elementUtil.doClick(submitDetails);

        //2nd Popup
        elementUtil.waitForElementsVisible(address, 10);
        elementUtil.doSendKeys(address, "Registered By Automation");
        elementUtil.doSendKeys(pincode, "147301");
        elementUtil.doSendKeys(city, "Mandi Gobindgarh");
        elementUtil.doSendKeys(nationalId, nationalID);
        elementUtil.doSendKeys(mobileNo, mobile);
        elementUtil.doClick(verifyMobile);
        otpPage.submitOtp();
        elementUtil.checkElementClickable(submitDetails, 10);
        elementUtil.doClick(submitDetails);
    }


    public void intermediateKYC()  {

        elementUtil.waitForElementVisible(headerCard, 20);
        System.out.println("============= KYC Status ==================== " + elementUtil.doGetElementText(basicKYCLink) );
        if (Objects.equals(elementUtil.doGetElementText(basicKYCLink), "APPROVED"))
        {
            elementUtil.doClick(intermediateKYCLink);
            elementUtil.waitForElementsVisible(submitDetails, 10);
            elementUtil.doClick(submitDetails);
            elementUtil.waitForElementVisible(imageNote, 10);
            elementUtil.doSendKeys(frontImageUpload, "E:\\Domus\\Automation\\(2).jpg");
            elementUtil.waitForElementVisible(removeButton, 30);
            elementUtil.doSendKeys(backImageUpload, "E:\\Domus\\Automation\\(3).jpg");
            elementUtil.checkElementClickable(submitDetails, 30);
            elementUtil.doClick(submitDetails);
            elementUtil.waitForElementVisible(imageNote, 10);
            elementUtil.doSendKeysSelfie(selfieUpload, "E:\\Domus\\Automation\\(5).jpg");
            elementUtil.waitForElementVisible(removeButton,30);
            elementUtil.checkElementClickable(submitIntermediateKYC, 30);
            elementUtil.doClick(submitIntermediateKYC);
            elementUtil.waitForElementVisible(headerCard,20);
        }
        else
        {
            System.out.println("====================> Please Complete the Basic KYC First <====================================");
        }
    }
}
