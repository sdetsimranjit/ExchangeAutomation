package Ant.qa.tradecrypto.pages.UserSide;

import Ant.qa.tradecrypto.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Wallet {
    WebDriver driver;
    ElementUtil elementUtil;
    OTPPage otpPage;

    public Wallet(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
        otpPage = new OTPPage(this.driver);


    }

    private By ethBal = By.xpath("(//table[@class='customTable undefined table']/tbody/tr/td)[4]");
    private By ethBalWithDrawAcc = By.xpath("(//table[@class='customTable undefined table']/tbody/tr[2]/td)[4]");
    private By ethDeposit = By.xpath("(//td[@class='linkTo_Wallet']/a)[1]");
    private By ethWithDraw = By.xpath("(//td[@class='linkTo_Wallet']/a)[4]");
    private By ethDepositCopyAddress = By.className("addressCopy_Icon");
    private By ethWithdrawAmountValue = By.name("amountValue");
    private By ethWithdrawAddress = By.id(" withdraw-address");
    private By submitWithdraw = By.xpath("//button[@type='submit']");
    private By toastMessage = By.className("ct-text");
    private By balonWithdraw = By.xpath("//span[@class='balanceTxt']/span");
    double withDrawAccEthBal;
    double amountInDouble;
    double balAfterWithDraw;
    double depositETHBal;
    double ethDepBal;





    public double getETHBal()
    {
        elementUtil.waitForElementVisible(ethBal, 10);
        System.out.println("--------- ETH Bal Is ----------------- " + elementUtil.doGetElementText(ethBal));
        String bal = elementUtil.doGetElementText(ethBal);
        String balarr [] = bal.split(" ");
        ethDepBal = Double.parseDouble(balarr[0]);
        System.out.println("--------- ETH Bal in double is ----------------- " + ethBal);
        return ethDepBal;

    }

    public double getETHBalWAcc()
    {
        elementUtil.waitForElementVisible(ethBalWithDrawAcc, 10);
        System.out.println("--------- ETH Bal Is ----------------- " + elementUtil.doGetElementText(ethBalWithDrawAcc));
        String bal = elementUtil.doGetElementText(ethBalWithDrawAcc);
        String balarr [] = bal.split(" ");
        double ethBal = Double.parseDouble(balarr[0]);
        System.out.println("--------- ETH Bal in double is ----------------- " + ethBal);
        return ethBal;

    }

    public String getETHDepositAddress() throws IOException, UnsupportedFlavorException, InterruptedException {
        elementUtil.waitForElementVisible(ethDeposit, 10);
        elementUtil.doClick(ethDeposit);
        //elementUtil.naviGateTo(ethDepositLink);
        elementUtil.waitForElementVisible(ethDepositCopyAddress, 10);
        elementUtil.doClick(ethDepositCopyAddress);
        //elementUtil.waitForElementInVisible(toastMessage, 10);
        Thread.sleep(4000);
        String depositAddress = elementUtil.pasteData();
        System.out.println("======== Deposit Address Is:-  "   + depositAddress);
        return depositAddress;
    }

    public void doWithdraw(String amount) throws IOException, UnsupportedFlavorException, InterruptedException {
        withDrawAccEthBal = getETHBalWAcc();
        elementUtil.waitForElementVisible(ethWithDraw, 10);
        elementUtil.doClick(ethWithDraw);
        elementUtil.waitForElementVisible(ethWithdrawAmountValue, 10);
        elementUtil.doSendKeys(ethWithdrawAmountValue, amount);
        amountInDouble = Double.parseDouble(amount);
        Thread.sleep(2000);
        elementUtil.doSendKeys(ethWithdrawAddress, elementUtil.pasteData());
        elementUtil.doClick(submitWithdraw);
        otpPage.submitWithdrawOTP();
        elementUtil.waitForElementVisible(toastMessage, 10);
      //  driver.navigate().refresh();
        elementUtil.waitForElementVisible(balonWithdraw, 10);
        String withArr  = elementUtil.doGetElementText(balonWithdraw);
        System.out.println("---------------------ssssss -------------" + withArr);
        String withArrsplit [] = elementUtil.doGetElementText(balonWithdraw).split(" ");
        balAfterWithDraw = Double.parseDouble(withArrsplit[0]);
    }

    public boolean checkWithdraw()
    {
        boolean b = true;
        double neededBal = withDrawAccEthBal - amountInDouble;
        System.out.println("needed bal is cvvvvvvccccccccccccccccccccv " + neededBal);
        if(balAfterWithDraw == neededBal)
        {
            System.out.println("------------ Correct Withdraw Bal ---------------------------------------------");
        }
        else {
            System.out.println("----------------xxxxxxxxxxxxx System Hang xxxxxxxxxxxxxxxxx-------------------");
            b = false;
        }
        return b;
    }


    public boolean checkDeposit()
    {
        double beforeDepBal = ethDepBal;
        depositETHBal = getETHBal();
        double balNeed = beforeDepBal + amountInDouble;
        boolean b = true;
        if (depositETHBal == balNeed)
        {
            System.out.println("********************** Deposit Done Successfully *******************************");

        }
        else
        {
            b = false;
            System.out.println("********************** Deposit notc cccccccccccccccccc Successfully *******************************");
        }
        return b;
    }












}
