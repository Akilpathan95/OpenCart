package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.Dataproviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = Dataproviders.class, groups = "Datadriven") //getting dataprovider from different class
    public void verfiy_logiDDT(String email, String pwd, String exp) throws InterruptedException
    {
        logger.info("**** Starting TC003 LoginDDT started  ****");

        try {


            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("**** Click on My Account  ****");
            hp.clickLogin();
            logger.info("**** Click on My Login  ****");

            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(email);
            lp.enterLoginPassword(pwd);
            lp.clkLogin();

            //MyAccountPage
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();

        /*
Data is valid - login success - test pass - logout
Data is valid - login failed - test fail

Data is Invalid - login success - test fail - logout
Data is Invalid - login failed - test pass

 */
            if (exp.equalsIgnoreCase("Valid"))
            {
                if (targetPage == true)
                {
                    macc.clkLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid"))
            {
                if (targetPage == true)
                {
                    macc.clkLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e)
        {
            Assert.fail();
        }

        //Thread.sleep(2000);
        logger.info("**** Ending TC003 LoginDDT  ****");
    }

}
