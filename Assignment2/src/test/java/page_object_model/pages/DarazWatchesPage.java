package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DarazWatchesPage extends BasePage{

    @FindBy(xpath = "//i[@class='lzd-search-common-icon ic-common-list _6psZk ']")
    public WebElement list;

    public DarazWatchesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnList(){
        list.click();
    }
}
