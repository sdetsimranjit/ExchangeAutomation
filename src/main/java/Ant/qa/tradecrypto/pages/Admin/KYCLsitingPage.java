package Ant.qa.tradecrypto.pages.Admin;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class KYCLsitingPage {
    WebDriver driver;
    ElementUtil elementUtil;

    public KYCLsitingPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    //private By kycLevelDropdown = By.xpath("(//div[@role='listbox'])[1]");
    private By kycLevelDropdown = By.xpath("(//div[@class=\"field\"]/div)[1]");
    private By kycLevelIntermediate = By.xpath("(//div[@role='option'])[2]");
    private By kycStatus = By.xpath("(//div[@role='listbox'])[2]");
    private By kycStatusSubmit = By.xpath("(//div[@role='option'])[6]");
    private By approveFirstEntry = By.xpath("(//button[@class=\"ui button smallbtn greenBtn\"])[1]");

    private By kycEmailListing = By.xpath("//table[@class=\"ui celled table\"]/tbody/tr/td[2]");
  // WebElement  approveButton = kycEmailListing.findElement(By.xpath(""));

    public void getListingData(String emailNeed)
    {
            List<WebElement> data = driver.findElements(kycEmailListing);
            for (WebElement email : data)
            {
                if (Objects.equals(email.getText(), emailNeed))
                {
                    System.out.println("============= Email Found ===================");
                    elementUtil.doClick(approveFirstEntry);

                }
            }

    }

    public void  getIntermediateKYCListing(String email) throws InterruptedException {
        Thread.sleep(3000);
        elementUtil.waitForElementVisible(kycLevelDropdown, 10);
        elementUtil.checkElementClickable(kycLevelDropdown, 10);
        elementUtil.doClick(kycLevelDropdown);
        elementUtil.doClick(kycLevelIntermediate);
        elementUtil.doClick(kycStatus);
        elementUtil.checkElementClickable(kycStatusSubmit, 5);
        elementUtil.doClick(kycStatusSubmit);
        elementUtil.waitForElementsVisible(kycEmailListing,20);
        Thread.sleep(5000);
        getListingData(email);
    }



}
