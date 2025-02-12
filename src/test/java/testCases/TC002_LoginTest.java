package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_Login()
    {
        logger.info("**** Starting TC002 Login  ****");
        try
        {
            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            logger.info("**** Click on My Account  ****");
            hp.clickLogin();
            logger.info("**** Click on My Login  ****");

            LoginPage lp=new LoginPage(driver);
            lp.enterEmail(p.getProperty("email"));
            lp.enterLoginPassword(p.getProperty("password"));
            lp.clkLogin();

            //MyAccountPage
            MyAccountPage macc=new MyAccountPage(driver);
            boolean targetPage=macc.isMyAccountPageExists();

            Assert.assertEquals(targetPage, true);

        }

        catch (Exception e)
        {
            Assert.assertTrue(false);
        }
        logger.info("**** Finished Tc_002  ****");
    }

}
