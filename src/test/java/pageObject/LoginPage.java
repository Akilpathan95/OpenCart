package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtLoginPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    public void enterEmail(String emailLogin)
    {
        txtEmail.sendKeys(emailLogin);
    }

    public void enterLoginPassword(String passwordLogin)
    {
        txtLoginPassword.sendKeys(passwordLogin);
    }

    public void clkLogin()
    {
        btnLogin.click();
    }
}
