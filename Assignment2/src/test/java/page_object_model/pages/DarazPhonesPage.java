package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_object_model.utilities.Log;

public class DarazPhonesPage extends BasePage{

    @FindBy(xpath = "//a[@class='DMfHy ']")
    public WebElement DarazPhonesLink;

    @FindBy(xpath = "//div[@class='ant-select-selector']")
    public WebElement SortSelector;

    @FindBy(xpath = "//div[text()='Price low to high']")
    public WebElement PriceLow;

    public DarazPhonesPage(WebDriver driver) {
        super(driver);
        Log.info("DarazPhonesPage Initialized");
    }

    public void clickDarazPhonesLink() {
        DarazPhonesLink.click();
        Log.info("DarazPhonesLink clicked");
    }

    public void clickSortSelector() {
        SortSelector.click();
        Log.info("SortSelector clicked");
    }

    public void clickPriceLow() {
        PriceLow.click();
        Log.info("PriceLow clicked");
    }
}
