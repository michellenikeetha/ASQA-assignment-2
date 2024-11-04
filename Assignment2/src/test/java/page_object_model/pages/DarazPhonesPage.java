package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DarazPhonesPage extends BasePage{

    @FindBy(xpath = "//a[@class='DMfHy ']")
    public WebElement DarazPhonesLink;

    @FindBy(xpath = "//div[@class='ant-select-selector']")
    public WebElement SortSelector;

    @FindBy(xpath = "//div[text()='Price low to high']")
    public WebElement PriceLow;

    public DarazPhonesPage(WebDriver driver) {
        super(driver);
    }

    public void clickDarazPhonesLink() {
        DarazPhonesLink.click();
    }

    public void clickSortSelector() {
        SortSelector.click();
    }

    public void clickPriceLow() {
        PriceLow.click();
    }
}
