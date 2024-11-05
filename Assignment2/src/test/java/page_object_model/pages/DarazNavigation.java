package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object_model.utilities.Log;

public class DarazNavigation extends BasePage{

    @FindBy(xpath = "//span[@id='myAccountTrigger']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//span[@class='account-icon test my-orders']")
    public WebElement myOrdersButton;

    @FindBy(xpath = "//span[@class='account-icon test manage-account']")
    public WebElement manageAccountButton;

    @FindBy(xpath = "//a[@id='account-popup-logout']")
    public WebElement logoutButton;

    public DarazNavigation(WebDriver driver) {
        super(driver);
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

    public DarazMyProfile clickManageAccountButton() {
        Log.info("Clicking on Manage Account button");
        manageAccountButton.click();
        return PageFactory.initElements(driver, DarazMyProfile.class);
    }

    public void clickLogoutButton() {
        myAccountButton.click();
        Log.info("Clicking on Logout button");
        logoutButton.click();
    }

}
