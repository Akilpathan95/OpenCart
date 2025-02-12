package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationForm;
import pageObject.HomePage;
import testBase.BaseClass;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_Account_Registration()
    {

        logger.info("**** Starting TC001 AccountRegistration  ****");
        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("**** Click on Account link  ****");
            hp.clickRegister();
            logger.info("**** Click to register link  ****");

            AccountRegistrationForm regPage = new AccountRegistrationForm(driver);
            regPage.setFirstName(randomString().toUpperCase());
            regPage.setLastName(randomString().toUpperCase());
            regPage.setEmail(randomString() + "@gmail.com"); //randomly generated the mail
            regPage.setTelephone(randomNumber());
            String password = randomAlphaNumeric();
            regPage.setPassword(password);
            regPage.setConfirmPassword(password);
            regPage.clickRdobtnNewsLetter();
            regPage.setPrivacyPolicy();
            regPage.clickBtnContinue();
            logger.info("**** Form submission complete  ****");
            logger.info("**** Validation confirmation message  ****");
            String confmsg = regPage.getConfirmationMessage();

            if (confmsg.equals("Your Account Has Been Created!"))
            {
                Assert.assertTrue(true);
            }
            else
            {
                logger.error("Test failed");
                logger.debug("Debug logs");
                Assert.assertTrue(false);
            }
            //Assert.assertEquals(confmsg,"Your Account Has Been Created!");
        }

        catch(Exception e) {
            Assert.fail();

        }
    }



}
