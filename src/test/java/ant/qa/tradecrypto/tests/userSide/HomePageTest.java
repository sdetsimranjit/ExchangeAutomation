package ant.qa.tradecrypto.tests.userSide;

import ant.qa.tradecrypto.base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void launch()
    {
        homePage.goToSignUp();
    }

}
