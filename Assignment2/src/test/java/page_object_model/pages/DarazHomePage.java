package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class DarazHomePage extends BasePage {

    @FindBy(xpath = "//input[@id='q']")
    public WebElement SearchBox;

    @FindBy(xpath = "//a[@class='search-box__button--1oH7']")
    public WebElement Button;

    public String visibleText = "";

    public DarazHomePage(WebDriver driver) {
        super(driver);
    }

    public void typeTextToSearchBox(String searchText) {
        SearchBox.sendKeys(searchText);
    }

    public <T> T clickButton() {
        Button.click();

//        if(visibleText.equals("rings")) {
//            return (T) PageFactory.initElements(driver, DarazRingsPage.class);
//        } else {
//            return (T) PageFactory.initElements(driver, DarazPhonesPage.class);
//        }

        switch (visibleText.toLowerCase()) {
            case "rings":
                return (T) PageFactory.initElements(driver, DarazRingsPage.class);
            case "phones":
                return (T) PageFactory.initElements(driver, DarazPhonesPage.class);
            case "watches":
                return (T) PageFactory.initElements(driver, DarazWatchesPage.class);
            default:
                return (T) PageFactory.initElements(driver, DarazHomePage.class);
        }

    }

}
