package ant.qa.tradecrypto.tests.userSide;

import ant.qa.tradecrypto.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    String errmsg;

    @BeforeClass
    public void preReq()
    {
       registerPage =  homePage.goToSignUp();
    }
    @Test
    public void registerPageTitleTest()
    {
        String actTitle =  registerPage.getRegisterPageTitle();
        Assert.assertEquals(actTitle, "Domus");
    }
    @Test(priority = 33)
    public void emailNotBeEmpty() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("");
        Assert.assertEquals(errmsg, "*Email is required");
    }
    @Test(priority = 34)
    public void invalidEmail1() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("Abc.example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 35)
    public void invalidEmail2() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("A@b@c@example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 36)
    public void invalidEmail3() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("a\"b(c)d,e:f;g<h>i[j\\k]l@example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 37)
    public void invalidEmail4() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("just\"not\"right@example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 38)
    public void invalidEmail5() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("this is\"not\\allowed@example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 39)
    public void invalidEmail6() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("this\\ still\\\"not\\\\allowed@example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 40, enabled = false)
    public void invalidEmail7() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("1234567890123456789012345678901234567890123456789012345678901234+x@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 41, enabled = false)
    public void invalidEmail8() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("i_like_underscore@but_its_not_allowed_in_this_part.example.com");
        Assert.assertEquals(errmsg, "*Invalid Email");
    }
    @Test(priority = 42)
    public void validEmail1() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("simple@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 43)
    public void validEmail2() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("very.common@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 44)
    public void validEmail3() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("disposable.style.email.with+symbol@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 45)
    public void validEmail4() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("other.email-with-hyphen@and.subdomains.example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 46)
    public void validEmail5() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("fully-qualified-domain@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 47)
    public void validEmail6() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("x@example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 48)
    public void validEmail7() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("example-indeed@strange-example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 49)
    public void validEmail8() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("test/test@test.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 50)
    public void validEmail9() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("example@s.example");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 51, enabled = false)
    public void validEmail10() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("\" \"@example.org");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 52, enabled = false)
    public void validEmail11() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("\"john..doe\"@example.org");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 53)
    public void validEmail12() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("mailhost!username@example.org");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 54, enabled = false)
    public void validEmail13() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("\"very.(),:;<>[]\\\".VERY.\\\"very@\\\\ \\\"very\\\".unusual\"@strange.example.com");
        Assert.assertEquals(errmsg, "");
    }
    @Test(priority = 55)
    public void validEmail14() throws InterruptedException {
        errmsg = registerPage.createAccountNegative("user-@example.org");
        Assert.assertEquals(errmsg, "");
    }

    @Test(groups = {"Regression"}, priority = 56)
    public void enterEmail() throws InterruptedException {
       registerPage.createAccount(prop.getProperty("email"), prop.getProperty("password"));
     //  registerPage.createAccount(prop.getProperty("email"), prop.getProperty("password"));
    }
}

