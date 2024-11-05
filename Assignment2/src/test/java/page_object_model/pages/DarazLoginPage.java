package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_object_model.utilities.Log;

public class DarazLoginPage extends BasePage{

    @FindBy(xpath = "//button[text()='LOG IN']")
    public WebElement logInButton;

    //@FindBy(xpath = "//input[@data-spm-anchor-id='a2a0e.tm80335410.0.i0.1a5b79e0Vz1OUe']")
    //@FindBy(xpath = "//input[text()='Please enter your Phone Number or Email']")
    //@FindBy(xpath = "/html/body/div[5]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/input")
    //public WebElement username;

    @FindBy(xpath = "//input[@placeholder='Please enter your Phone Number or Email']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Please enter your password']")
    public WebElement passwordField;

    @FindBy(xpath = "//span[@id='myAccountTrigger']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//span[@class='account-icon test my-orders']")
    public WebElement myOrdersButton;

    public DarazLoginPage(WebDriver driver) {
        super(driver);
        Log.info("DarazLoginPage initialized");
    }

    public boolean isLogInButtonDisplayed() {
        Log.info("isLogInButtonDisplayed");
        return logInButton.isDisplayed();
    }

//    public void enterUsername(String username) {
//        this.username.sendKeys(username);
//    }

    public void enterUsername(String username) {
        Log.info("enterUsername: " + username);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        Log.info("enterPassword: " + password);
        passwordField.sendKeys(password);
    }

    public void clickLogInButton() {
        Log.info("Clicking on Log In button");
        logInButton.click();
    }

    public boolean isMyAccountButtonDisplayed() {
        Log.info("isMyAccountButtonDisplayed");
        return myAccountButton.isDisplayed();
    }

    public void clickMyAccountButton() {
        Log.info("Clicking on My Account button");
        myAccountButton.click();
    }

    public void clickMyOrdersButton() {
        Log.info("Clicking on My Orders button");
        myOrdersButton.click();
    }

}
