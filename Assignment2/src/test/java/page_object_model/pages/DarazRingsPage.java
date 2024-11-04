package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_object_model.utilities.Log;

public class DarazRingsPage extends BasePage{

    @FindBy(xpath = "//span[text()='Cubic Zirconia']")
    //@FindBy(xpath = "//input[class='ant-checkbox-input']")
    public WebElement checkBoxCubic;

    public DarazRingsPage(WebDriver driver) {
        super(driver);
        Log.info("DarazRingsPage Initialized");
    }

    public void clickCheckBoxCubic() {
        checkBoxCubic.click();
        Log.info("DarazRingsPage Clicked CheckBox Cubic");
    }

}
