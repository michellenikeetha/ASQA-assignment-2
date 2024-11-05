package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_object_model.utilities.Log;

public class DarazHomePage extends BasePage {

    @FindBy(xpath = "//input[@id='q']")
    public WebElement SearchBox;

    @FindBy(xpath = "//a[@class='search-box__button--1oH7']")
    public WebElement Button;

    @FindBy(xpath = "//div[@id='anonLogin']")
    public WebElement AnonLogin;

    public String visibleText = "";

    public DarazHomePage(WebDriver driver) {
        super(driver);
    }

    public void typeTextToSearchBox(String searchText) {
        Log.info("Typing text to search box: " + searchText);
        SearchBox.sendKeys(searchText);
    }

    public <T> T clickButton() {
        Log.info("Clicking the search button with visible text: " + visibleText);
        Button.click();

//        if(visibleText.equals("rings")) {
//            return (T) PageFactory.initElements(driver, DarazRingsPage.class);
//        } else {
//            return (T) PageFactory.initElements(driver, DarazPhonesPage.class);
//        }

        switch (visibleText.toLowerCase()) {
            case "rings":
                Log.info("navigating to rings page");
                return (T) PageFactory.initElements(driver, DarazRingsPage.class);
            case "phones":
                Log.info("navigating to phones page");
                return (T) PageFactory.initElements(driver, DarazPhonesPage.class);
            case "watches":
                Log.info("navigating to watches page");
                return (T) PageFactory.initElements(driver, DarazWatchesPage.class);
            default:
                Log.info("navigating to home page");
                return (T) PageFactory.initElements(driver, DarazHomePage.class);
        }

    }

    public DarazLoginPage clickLogin() {
        Log.info("Clicking login button");
        AnonLogin.click();
        Log.info("navigating to login page");
        return PageFactory.initElements(driver, DarazLoginPage.class);
    }

}
