package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //Click on My Account
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    //Click on register
    @FindBy(xpath = "//a[normalize-space()='Register']") WebElement lnkRegister;

    //Click on Login
    @FindBy(xpath = "//a[normalize-space()='Login']") WebElement lnkLogin;

    public void clickMyAccount()
    {
        lnkMyaccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        lnkLogin.click();
    }

}
